package com.botpy.digiccy.component;

import android.app.Activity;
import android.content.Context;
import android.widget.ImageView;

import com.botpy.digiccy.R;
import com.botpy.digiccy.app.GlideApp;
import com.botpy.digiccy.component.glidelistener.GlideLogListener;
import com.botpy.digiccy.component.glidetransform.TransformBitmap;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import static com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade;

/**
 * 图片加载封装
 * @author liuxuhui
 * @date 2018/11/26
 */
public class ImageLoader {

    /**
     * 加载网络图片
     * @param context
     * @param url
     * @param imageView
     */
    public static void load(Context context, String url, ImageView imageView) {
        GlideApp.with(context)
                .load(url)
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                //url为空时的占位符
                .fallback(R.mipmap.ic_launcher)
                .centerCrop()
                //交叉淡入变换
                .transition(withCrossFade())
                //跳过缓存
                .skipMemoryCache(true)
                .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
                //处理Bitmap
                .transform(new TransformBitmap())
                //错误日志
                .listener(new GlideLogListener())
                .into(imageView);
    }

    /**
     * 加载网络图片
     * @param activity
     * @param url
     * @param imageView
     */
    public static void load(Activity activity, String url, ImageView imageView) {
        GlideApp.with(activity)
                .load(url)
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                //url为空时的占位符
                .fallback(R.mipmap.ic_launcher)
                .centerCrop()
                //交叉淡入变换
                .transition(withCrossFade())
                //跳过缓存
                .skipMemoryCache(true)
                .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
                //处理Bitmap
                .transform(new TransformBitmap())
                //错误日志
                .listener(new GlideLogListener())
                .into(imageView);
    }

    /**
     * 加载资源图片
     * @param context
     * @param resource
     * @param imageView
     */
    public static void load(Context context, int resource, ImageView imageView) {
        GlideApp.with(context)
                .load(resource)
                .into(imageView);
    }

    /**
     * 取消加载
     * @param context
     * @param imageView
     */
    public static void clear(Context context, ImageView imageView) {
        GlideApp.with(context)
                .clear(imageView);
    }
}

