package com.botpy.digiccy.ui.sample;

import android.view.View;
import android.widget.TextView;

import com.botpy.digiccy.R;
import com.botpy.digiccy.base.BaseActivity;
import com.botpy.digiccy.component.TLog;
import com.botpy.digiccy.util.LanguageUtil;
import com.botpy.digiccy.util.SPUtil;

import butterknife.BindView;
import butterknife.OnClick;

public class SampleActivity extends BaseActivity<SamplePresenter> implements SampleContract.View{

    @BindView(R.id.name_tv)
    TextView nameTv;
    @BindView(R.id.sex_tv)
    TextView sexTv;

    @Override
    protected int getLayout() {
        return R.layout.layout_sample_new;
    }

    @Override
    protected void onViewCreated() {
        mPresenter.getData();
    }

    @Override
    public void onRequestStart() {
    }

    @Override
    public void onRequestEnd() {
    }

    @Override
    public void onRequestError(String msg) {
        TLog.d(msg);
    }

    @Override
    public void setName(String name) {
    }

    @OnClick({R.id.btn1, R.id.btn2})
    public void switchLanguage(View view) {
        switch (view.getId()) {
            case R.id.btn1:
                SPUtil.getInstance(this).saveCurrentLanguage(0);
                LanguageUtil.setAppLanguage(this);
                reStart();
                break;
            case R.id.btn2:
                SPUtil.getInstance(this).saveCurrentLanguage(1);
                LanguageUtil.setAppLanguage(this);
                reStart();
                break;
                default:
                    break;
        }
    }
}
