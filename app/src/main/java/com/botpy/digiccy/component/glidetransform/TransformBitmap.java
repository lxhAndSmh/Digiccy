package com.botpy.digiccy.component.glidetransform;

import android.graphics.Bitmap;
import android.support.annotation.NonNull;

import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;

/**
 * 变换Bitmap或者对请求的Bitmap进行处理
 * 必须重写equals和hashCode方法
 * @author liuxuhui
 * @date 2018/11/27
 */
public class TransformBitmap extends BitmapTransformation {

    private static final String ID = "com.botpy.digiccy.component.glidetransform.TransformBitmap";
    private static byte[] ID_BYTES;

    static {
        try {
            ID_BYTES = ID.getBytes(STRING_CHARSET_NAME);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected Bitmap transform(@NonNull BitmapPool pool, @NonNull Bitmap toTransform, int outWidth, int outHeight) {
        //bitmap二次处理
        return toTransform;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof TransformBitmap;
    }

    @Override
    public int hashCode() {
        return ID.hashCode();
    }

    @Override
    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) throws UnsupportedOperationException{
        messageDigest.update(ID_BYTES);
    }
}
