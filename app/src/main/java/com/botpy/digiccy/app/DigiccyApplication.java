package com.botpy.digiccy.app;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

import com.botpy.digiccy.util.TLog;
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
        mContext = getApplicationContext();
        application = this;

        //初始化LeakCanary
        if (LeakCanary.isInAnalyzerProcess(this)) {
            return;
        }
        LeakCanary.install(this);

        //初始化日志打印
        TLog.init();
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
