package com.botpy.digiccy.api;

import com.botpy.digiccy.BuildConfig;
import com.botpy.digiccy.api.converter.MineGsonConverterFactory;
import com.botpy.digiccy.component.TLog;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

/**
 * 网络请求封装
 * @author liuxuhui
 * @date 2018/11/15
 */
public class RetrofitManger {

    public static final int DEFAULT_TIMEOUT = 30;
    public static final String HEADER_CONTENT_TYPE = "Content-Type";
    public static final String HEADER_FORM_DATA    = "application/x-www-form-urlencoded";


    public static ApiService create(String data) {
        return create(data, new Gson());
    }

    public static ApiService create(String data, Gson gson) {
        return create(true, data, gson);
    }

    public static ApiService create(boolean isLogin, String data, Gson gson) {
        if (gson == null) {
            gson = new Gson();
        }
        Retrofit.Builder builder = new Retrofit.Builder();
        builder.baseUrl(BuildConfig.BASE_URL)
                .client(getClient(isLogin, data))
                .addConverterFactory(MineGsonConverterFactory.create(isLogin, gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        return builder.build().create(ApiService.class);
    }

    private static OkHttpClient getClient(boolean isLogin, String data) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        //添加头部拦截器
        Interceptor headerInterceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request.Builder requestBuilder = chain.request().newBuilder();
                requestBuilder.addHeader(HEADER_CONTENT_TYPE, HEADER_FORM_DATA);
                return chain.proceed(requestBuilder.build());
            }
        };
        builder.addInterceptor(headerInterceptor);

        if (BuildConfig.DEBUG) {
            //添加日志拦截器
            Interceptor logInterceptor = new Interceptor() {
                @Override
                public Response intercept(Chain chain) throws IOException {
                    //输出请求头和请求URL
                    Request request = chain.request();
                    Headers headers = request.headers();
                    StringBuilder stringBuilder = new StringBuilder();
                    for (int i = 0; i < headers.size(); i++) {
                        stringBuilder.append(headers.name(i) + ":");
                        stringBuilder.append(headers.value(i) + "\n");
                    }
                    stringBuilder.append(request.url());
                    TLog.d(stringBuilder.toString());

                    return chain.proceed(request);
                }
            };
            builder.addInterceptor(logInterceptor);
        }

        builder.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                .retryOnConnectionFailure(true);
        return builder.build();
    }
}
