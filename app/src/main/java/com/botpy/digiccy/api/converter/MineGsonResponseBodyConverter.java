package com.botpy.digiccy.api.converter;

import com.botpy.digiccy.util.TLog;
import com.google.gson.Gson;

import java.io.IOException;
import java.lang.reflect.Type;

import okhttp3.ResponseBody;
import retrofit2.Converter;

/**
 * @author liuxuhui
 * @date 2018/11/18
 */
public class MineGsonResponseBodyConverter<T> implements Converter<ResponseBody, T> {

    private boolean isLogin;
    private Gson gson;
    private Type type;

    public MineGsonResponseBodyConverter(boolean isLogin, Gson gson, Type type) {
        this.isLogin = isLogin;
        this.gson = gson;
        this.type = type;
    }

    @Override
    public T convert(ResponseBody value) throws IOException {
        String response = value.string();
        TLog.json(response);
        return gson.fromJson(response, type);
    }
}
