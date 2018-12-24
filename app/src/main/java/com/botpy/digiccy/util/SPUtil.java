package com.botpy.digiccy.util;

import android.content.Context;
import android.content.SharedPreferences;

import com.botpy.digiccy.app.ConstantValues;
import com.botpy.digiccy.app.DigiccyApplication;

import static com.botpy.digiccy.app.ConstantValues.LANGUAGE_KEY;

/**
 * 数据偏好工具类
 * @author liuxuhui
 * @date 2018/12/19
 */
public class SPUtil {

    private SharedPreferences mSharedPreferences;
    private static volatile SPUtil mInstance;

    public SPUtil(Context context) {
        if(mSharedPreferences == null) {
            mSharedPreferences = context.getSharedPreferences(ConstantValues.SP_NAME, Context.MODE_PRIVATE);
        }
    }

    public static SPUtil getInstance(Context context) {
        if(mInstance == null) {
            synchronized (SPUtil.class) {
                if(mInstance == null) {
                    mInstance = new SPUtil(context);
                }
            }
        }
        return mInstance;
    }

    /**
     * @param key key值
     * @return 返回int型的值
     */
    public int getInteger(String key) {
        return mSharedPreferences.getInt(key, 0);
    }

    /**
     * 保存int类型的数据
     * @param key key值
     * @param value 保存的值
     */
    public void saveInteger(String key, int value) {
        mSharedPreferences.edit()
                .putInt(key, value)
                .apply();
    }

    /**
     * @param key key值
     * @return 返回String型的值
     */
    public String getString(String key) {
        return mSharedPreferences.getString(key, "");
    }

    /**
     * 保存String类型的数据
     * @param key key值
     * @param value 保存的值
     */
    public void saveString(String key, String value) {
        mSharedPreferences.edit()
                .putString(key, value)
                .apply();
    }

    /**
     * @param key key值
     * @return 返回Boolean型的值
     */
    public boolean getBoolean(String key) {
        return mSharedPreferences.getBoolean(key, false);
    }

    /**
     * 保存Boolean类型的数据
     * @param key key值
     * @param value 保存的值
     */
    public void saveBoolean(String key, boolean value) {
        mSharedPreferences.edit()
                .putBoolean(key, value)
                .apply();
    }

    /**
     * @return 获取当前设置的语言
     */
    public int getCurrentLanguage() {
        return getInteger(LANGUAGE_KEY);
    }

    /**
     * 保存当前选择的语言
     */
    public void saveCurrentLanguage(int language) {
        saveInteger(LANGUAGE_KEY, language);
    }
}
