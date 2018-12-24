package com.botpy.digiccy.app;

import android.os.Environment;

import java.io.File;

/**
 *
 * @author liuxuhui
 * @date 2018/11/16
 */
public class ConstantValues {

    public static final String SP_NAME = "digiccy";
    public static final String LANGUAGE_KEY = "current_language";

    //================= PATH ====================

    public static final String PATH_DATA = DigiccyApplication.getContext().getCacheDir().getAbsolutePath() + File.separator + "data";

    public static final String PATH_CACHE = PATH_DATA + "/NetCache";

    public static final String PATH_SDCARD = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "botpy" + File.separator + "digiccy";

    public static final String FILE_PROVIDER_AUTHORITY="com.botpy.digiccy.fileprovider";

}
