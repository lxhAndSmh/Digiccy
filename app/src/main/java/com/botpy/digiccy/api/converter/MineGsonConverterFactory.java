package com.botpy.digiccy.api.converter;

import com.google.gson.Gson;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import io.reactivex.annotations.Nullable;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;

/**
 * 重写转换器，对进行数据加密解密处理
 * @author liuxuhui
 * @date 2018/11/18
 */
public class MineGsonConverterFactory extends Converter.Factory {

    private boolean isLogin;
    private Gson gson;

    public static MineGsonConverterFactory create(boolean isLogin, Gson gson) {
        if (gson == null) {
            throw new NullPointerException("gson is null");
        }
        return new MineGsonConverterFactory(isLogin, gson);
    }

    public MineGsonConverterFactory(boolean isLogin, Gson gson) {
        this.isLogin = isLogin;
        this.gson = gson;
    }

    @Nullable
    @Override
    public Converter<?, RequestBody> requestBodyConverter(Type type, Annotation[] parameterAnnotations, Annotation[] methodAnnotations, Retrofit retrofit) {
        return new MineGsonRequestBodyConverter<>(isLogin, gson);
    }

    @Nullable
    @Override
    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
        return new MineGsonResponseBodyConverter<>(isLogin, gson, type);
    }
}
