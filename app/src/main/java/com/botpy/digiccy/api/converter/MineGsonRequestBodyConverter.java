package com.botpy.digiccy.api.converter;

import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.FormBody;
import okhttp3.RequestBody;
import retrofit2.Converter;

/**
 * @author liuxuhui
 * @date 2018/11/18
 */
public class MineGsonRequestBodyConverter<T> implements Converter<T, RequestBody> {

    private boolean isLogin;
    private Gson gson;

    public MineGsonRequestBodyConverter(boolean isLogin, Gson gson) {
        this.isLogin = isLogin;
        this.gson = gson;
    }

    @Override
    public RequestBody convert(T value) throws IOException {
        //处理上传参数（可进行加密）
        FormBody formBody = new FormBody.Builder()
                .add("data", value.toString())
                .build();

        return formBody;
    }
}
