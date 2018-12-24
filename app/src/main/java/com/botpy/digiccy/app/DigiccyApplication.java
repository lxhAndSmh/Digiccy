package com.botpy.digiccy.app;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;

import com.botpy.digiccy.component.TLog;
import com.botpy.digiccy.util.LanguageUtil;
import com.squareup.leakcanary.LeakCanary;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @author liuxuhui
 * @date 2018/11/15
 */
public class DigiccyApplication extends Application {

    private static Context mContext;
    private static DigiccyApplication application;
    private Set<Activity> mActivities;

    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
        mContext = getApplicationContext();

        //初始化LeakCanary
        if (LeakCanary.isInAnalyzerProcess(this)) {
            return;
        }
        LeakCanary.install(this);

        //初始化日志打印
        TLog.init();

        //设置App的语言
        LanguageUtil.setAppLanguage(this);
    }

    @Override
    protected void attachBaseContext(Context base) {
        //保存系统选择的语言
        super.attachBaseContext(LanguageUtil.setLocale(base));
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        //保存系统选择的语言
        LanguageUtil.setAppLanguage(getApplicationContext());
    }

    public static synchronized Context getContext() {
        return mContext;
    }

    public static synchronized DigiccyApplication getInstance() {
        return application;
    }

    public void addActivity(Activity activity) {
        if (mActivities == null) {
            mActivities = new HashSet<>();
        }
        mActivities.add(activity);
    }

    public void removeActivity(Activity activity) {
        if (mActivities != null) {
            mActivities.remove(activity);
        }
    }

    public void exitActivity() {
        if (mActivities != null) {
            synchronized (mActivities) {
                Iterator<Activity> iterator = mActivities.iterator();
                while (iterator.hasNext()) {
                    iterator.remove();
                }
            }

        }
    }
}
