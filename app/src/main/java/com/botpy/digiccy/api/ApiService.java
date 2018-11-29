package com.botpy.digiccy.api;

import com.botpy.digiccy.model.Result;
import com.botpy.digiccy.model.UserInfoModel;

import io.reactivex.Flowable;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * @author liuxuhui
 * @date 2018/11/15
 */
public interface ApiService {

    @POST("login")
    Flowable<Result<UserInfoModel>> getUserInfo(@Body String options);
}
