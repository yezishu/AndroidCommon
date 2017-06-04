package yzs.itaxi.data.service;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import yzs.itaxi.data.module.NewsResponse;

/**
 * Des：服务器接口
 * create by Zishu.Ye on 2017/5/31  15:11
 */
public interface IMainService {

    @GET("news/latest")
    Flowable<NewsResponse> search();
}
