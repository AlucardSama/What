package com.zheng.what.api;

import com.zheng.what.bean.NewsList;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by zheng on 2016/9/5.
 */
public interface NewsService {

    @GET("index")
    Observable<NewsList> getNewsList(@Query("type") String type,@Query("key") String key);


}
