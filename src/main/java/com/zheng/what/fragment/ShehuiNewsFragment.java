package com.zheng.what.fragment;

import android.content.Intent;

import com.zheng.what.activity.DetailActivity;
import com.zheng.what.adapter.RecyclerViewAdapter;
import com.zheng.what.api.NewsService;
import com.zheng.what.bean.NewsList;
import com.zheng.what.utils.Constants;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by zheng on 2016/9/5.
 */
public class ShehuiNewsFragment extends BaseFragment {

    private static ShehuiNewsFragment fragment;


    public static ShehuiNewsFragment newInstance() {
        if (fragment == null) {
            fragment = new ShehuiNewsFragment();
        }
        return fragment;
    }

    @Override
    public void onUnvisibleToUser() {

    }

    @Override
    public void onVisibleToUser() {

        Retrofit retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://v.juhe.cn/toutiao/")
                .build();

        NewsService newsService = retrofit.create(NewsService.class);

        rx.Observable<NewsList> githubBeanObservable = newsService.getNewsList("shehui", Constants.KEY);

        githubBeanObservable.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<NewsList>() {
                    @Override
                    public void call(final NewsList newsList) {

                        RecyclerViewAdapter adapter = new RecyclerViewAdapter(getActivity(), newsList.getResult().getData());
                        mRecyclerView.setAdapter(adapter);
                        adapter.setOnItemClickListener(new RecyclerViewAdapter.OnItemClickListener() {
                            @Override
                            public void onItemClick(int position) {
                                Intent intent = new Intent(getActivity(), DetailActivity.class);
                                intent.putExtra("title", newsList.getResult().getData().get(position).getTitle());
                                intent.putExtra("detailUrl", newsList.getResult().getData().get(position).getUrl());
                                startActivity(intent);
                            }

                            @Override
                            public void onItemLongClick() {

                            }
                        });
                    }


                });


    }
}
