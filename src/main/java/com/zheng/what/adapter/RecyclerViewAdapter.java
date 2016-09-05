package com.zheng.what.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.zheng.what.R;
import com.zheng.what.bean.NewsList;

import java.util.List;

/**
 * Created by zheng on 2016/9/1.
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private Context mContext;
    private OnItemClickListener listener;
    private View rootView;
    private List<NewsList.ResultBean.DataBean> newsData;

    public RecyclerViewAdapter(Context mContext,List<NewsList.ResultBean.DataBean> newsData) {
        this.mContext = mContext;
        this.newsData=newsData;
    }

    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        rootView =
                LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_card_main, parent, false);
        return new ViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(final RecyclerViewAdapter.ViewHolder holder, final int position) {
        rootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(position);
            }
        });
        NewsList.ResultBean.DataBean dataBean=newsData.get(position);
        holder.tv_desc.setText(dataBean.getTitle());
        //Glide 加载图片
        Glide.with(mContext)
                .load(dataBean.getThumbnail_pic_s())
                //.asGif()
                .placeholder(R.drawable.loading)
                .error(R.drawable.photo)
                .diskCacheStrategy(DiskCacheStrategy.RESULT)
                .crossFade()
                .into(holder.iv_img);
    }

    @Override
    public int getItemCount() {
        return newsData.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView iv_img;
        private TextView tv_desc;

        public ViewHolder(View view) {
            super(view);
            iv_img = (ImageView) view.findViewById(R.id.iv_img);
            tv_desc = (TextView) view.findViewById(R.id.tv_desc);
        }
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }


    public interface OnItemClickListener {
        void onItemClick(int position);

        void onItemLongClick();
    }


}
