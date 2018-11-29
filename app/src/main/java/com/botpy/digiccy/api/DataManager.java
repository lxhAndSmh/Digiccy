package com.botpy.digiccy.api;

import com.botpy.digiccy.api.parser.SampleParser;
import com.botpy.digiccy.model.Result;
import com.botpy.digiccy.model.UserInfoModel;
import com.botpy.digiccy.util.RxUtil;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;


import java.lang.reflect.Type;

import io.reactivex.Flowable;

/**
 * 数据请求
 * @author liuxuhui
 * @date 2018/11/18
 */
public class DataManager {

    private ApiService apiService;

    public static DataManager create() {
        return new DataManager();
    }

    public DataManager() {
        if (apiService == null) {
            apiService = RetrofitManger.create(null);
        }
    }

    public Flowable<UserInfoModel> getUserInfoData() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("phone", "18301421070");
        jsonObject.addProperty("code", "123456");

        Type type = new TypeToken<Result<UserInfoModel>>(){}.getType();
        Gson gson = new GsonBuilder().registerTypeAdapter(type, new SampleParser<Result<UserInfoModel>>()).create();

        return RetrofitManger.create(jsonObject.toString(), gson)
                .getUserInfo(jsonObject.toString())
                .compose(RxUtil.applySchedlers())
                .compose(RxUtil.handleResult());
    }
}
