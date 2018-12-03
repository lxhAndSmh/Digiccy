package com.botpy.digiccy.component;

import android.support.annotation.Nullable;

import com.botpy.digiccy.BuildConfig;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.FormatStrategy;
import com.orhanobut.logger.Logger;
import com.orhanobut.logger.PrettyFormatStrategy;

/**
 * 打印日志工具类
 * @author liuxuhui
 * @date 2018/11/18
 */
public class TLog {
    public final static String TAG = "com.botpy.digiccy";

    public static void init() {
        FormatStrategy formatStrategy = PrettyFormatStrategy.newBuilder()
                //是否显示打印所在的线程,默认true
                .showThreadInfo(false)
                //全局的日志过滤标签，默认PRETTY_LOGGER
                .tag(TAG)
                .build();
        Logger.addLogAdapter(new AndroidLogAdapter(formatStrategy) {
            @Override
            public boolean isLoggable(int priority, @Nullable String tag) {
                return BuildConfig.DEBUG;
            }
        });
    }

    public static void d(String msg) {
        Logger.d(msg);
    }

    /**
     * Custom tag for only one use
     * @param tag 过滤标签
     * @param msg 内容
     */
    public static void d(String tag, String msg) {
        Logger.t(tag).d(msg);
    }

    public static void e(String error) {
        Logger.e(error);
    }

    /**
     * Custom tag for only one use
     * @param tag 过滤标签
     * @param error 错误信息
     */
    public static void e(String tag, String error) {
        Logger.t(tag).e(error);
    }

    public static void json(String json) {
        Logger.json(json);
    }

    /**
     * Custom tag for only one use
     * @param tag 过滤标签
     * @param json json格式的数据
     */
    public static void json(String tag, String json) {
        Logger.t(tag).json(json);
    }

    public static void xml(String xml) {
        Logger.xml(xml);
    }

    /**
     * Custom tag for only one use
     * @param tag 过滤标签
     * @param xml xml格式的数据
     */
    public static void xml(String tag, String xml) {
        Logger.t(tag).xml(xml);
    }
}
