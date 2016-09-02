package com.zheng.what.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zheng.what.R;
import com.zheng.what.activity.DetailActivity;
import com.zheng.what.adapter.RecyclerViewAdapter;

/**
 * Created by zheng on 2016/9/1.
 */
public class BaseFragment extends Fragment {


    public static final String ARG_PAGE = "ARG_PAGE";
    private int mPage;
    private RecyclerView mRecyclerView;


    public static BaseFragment newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        BaseFragment pageFragment = new BaseFragment();
        pageFragment.setArguments(args);
        return pageFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPage = getArguments().getInt(ARG_PAGE);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mRecyclerView = (RecyclerView) inflater.inflate(R.layout.fragment_bse, container, false);
        return mRecyclerView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mRecyclerView.getContext()));
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(getActivity());
        mRecyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(new RecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick() {
               startActivity(new Intent(getActivity(),DetailActivity.class));
            }

            @Override
            public void onItemLongClick() {

            }
        });


    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if(isVisibleToUser){
            onVisibleToUser();
        }
        else{
            onUnvisibleToUser();
        }


    }

    private void onUnvisibleToUser() {
    }

    private void onVisibleToUser() {
//        Retrofit retrofit = new Retrofit.Builder()
//                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
//                .addConverterFactory(GsonConverterFactory.create())
//                .baseUrl("http://v.juhe.cn/toutiao/")
//                .build();
//
//        NewsService newsService=retrofit.create(NewsService.class);
//
//        rx.Observable<NewsList> githubBeanObservable=newsService.getNewsList("top");
//
//        githubBeanObservable.subscribeOn(Schedulers.newThread())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Action1<NewsList>() {
//                    @Override
//                    public void call(NewsList githubBean) {
//
//                        Toast.makeText(getActivity(),"成功",Toast.LENGTH_SHORT).show();
//                    }
//
//
//                });


    }

}
