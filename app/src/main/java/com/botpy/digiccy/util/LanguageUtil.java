package com.botpy.digiccy.util;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.LocaleList;


import com.botpy.digiccy.component.TLog;

import java.util.Locale;

/**
 * 多语言切换管理类
 * @author liuxuhui
 * @date 2018/12/18
 */
public class LanguageUtil {

    /**
     * 设置选择的语言
     * @param context
     */
    public static void setAppLanguage(Context context) {
        Locale locale = getSelectLanguage(context);
        Resources resources = context.getApplicationContext().getResources();
        Configuration configuration = resources.getConfiguration();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            configuration.setLocale(locale);
            context.createConfigurationContext(configuration);
        }else {
            configuration.locale = locale;
            resources.updateConfiguration(configuration, resources.getDisplayMetrics());
        }
    }

    /**
     * 设置语言
     * @param context
     * @return
     */
    public static Context setLocale(Context context) {
        Locale locale = getSelectLanguage(context);
        Locale.setDefault(locale);
        Resources resources = context.getResources();
        Configuration configuration = new Configuration(resources.getConfiguration());
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            configuration.setLocale(locale);
            context = context.createConfigurationContext(configuration);
        }else {
            configuration.locale = locale;
            resources.updateConfiguration(configuration, resources.getDisplayMetrics());
        }
        return context;
    }

    /**
     * @return 设置系统设置的语言
     */
    public static Locale getSystemLanguage() {
        Locale systemtLanguage;
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            systemtLanguage = LocaleList.getDefault().get(0);
        }else {
            systemtLanguage = Locale.getDefault();
        }
        return systemtLanguage;
    }

    /**
     * @return 获取选择的语言
     */
    public static Locale getSelectLanguage(Context context) {
        TLog.d("current:" + SPUtil.getInstance(context).getCurrentLanguage());
        switch (SPUtil.getInstance(context).getCurrentLanguage()) {
            //自动
            case 0:
                return getSystemLanguage();
            //English
            case 1:
                return Locale.ENGLISH;
            //默认系统
            default:
                return getSystemLanguage();
        }
    }
}
