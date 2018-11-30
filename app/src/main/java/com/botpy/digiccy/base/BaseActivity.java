package com.botpy.digiccy.base;

import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.botpy.digiccy.app.DigiccyApplication;
import com.botpy.digiccy.component.TLog;
import com.botpy.digiccy.util.TUtil;

import butterknife.ButterKnife;

/**
 * @author liuxuhui
 * @date 2018/11/19
 */
public abstract class BaseActivity<T extends RxPresenter> extends AppCompatActivity implements BaseView {

    protected T mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        ButterKnife.bind(this);

        mPresenter = TUtil.getT(this, 0);
        mPresenter.attachView(this);

        initPhotoError();
        TLog.json(DigiccyApplication.getInstance() + "app");
        TLog.json(this.getLocalClassName() + "name");
//        DigiccyApplication.getInstance().addActivity(this);

        onViewCreated();
    }

    protected abstract int getLayout();

    protected abstract void onViewCreated();

    /**
     * android 7.0系统解决拍照的问题
     */
    private void initPhotoError(){
        StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
        StrictMode.setVmPolicy(builder.build());
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR2) {
            builder.detectFileUriExposure();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        DigiccyApplication.getInstance().removeActivity(this);
        if (mPresenter != null) {
            mPresenter.detachView();
        }
    }
}
