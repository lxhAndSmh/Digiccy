package com.botpy.digiccy.component.glidelistener;

import android.support.annotation.Nullable;

import com.botpy.digiccy.util.TLog;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

/**
 * @author liuxuhui
 * @date 2018/11/27
 */
public class GlideLogListener implements RequestListener {


    @Override
    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target target, boolean isFirstResource) {
        TLog.e("Glide Error:" + e.toString());
        for(Throwable throwable : e.getRootCauses()) {
            TLog.e("Glide Caused by: " + throwable);
        }
        return false;
    }

    @Override
    public boolean onResourceReady(Object resource, Object model, Target target, DataSource dataSource, boolean isFirstResource) {
        return false;
    }
}
