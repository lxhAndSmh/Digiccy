package com.botpy.digiccy.app;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;

import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.annotation.GlideModule;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.module.AppGlideModule;
import com.bumptech.glide.request.RequestOptions;

/**
 * 继承自 AppGlideModule 的类。此类可生成出一个流式 API，内联了多种选项，和集成库中自定义的选项
 * @author liuxuhui
 * @date 2018/11/27
 */
@GlideModule
public final class DigiccyAppGlideModule extends AppGlideModule {

    @Override
    public void applyOptions(@NonNull Context context, @NonNull GlideBuilder builder) {
        builder.setDefaultRequestOptions(
                new RequestOptions()
                        .format(DecodeFormat.PREFER_RGB_565)
                        .disallowHardwareConfig())
                .setLogLevel(Log.DEBUG);
    }
}
