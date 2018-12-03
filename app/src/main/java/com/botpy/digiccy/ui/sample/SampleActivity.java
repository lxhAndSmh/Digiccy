package com.botpy.digiccy.ui.sample;

import android.widget.TextView;

import com.botpy.digiccy.R;
import com.botpy.digiccy.base.BaseActivity;
import com.botpy.digiccy.component.TLog;

import butterknife.BindView;

public class SampleActivity extends BaseActivity<SamplePresenter> implements SampleContract.View{

    @BindView(R.id.name_tv)
    TextView nameTv;

    @Override
    protected int getLayout() {
        return R.layout.activity_sample;
    }

    @Override
    protected void onViewCreated() {
        mPresenter.getData();
    }

    @Override
    public void onRequestStart() {
        TLog.d("SampleActivity", "开始");
    }

    @Override
    public void onRequestEnd() {
        TLog.d("结束");
    }

    @Override
    public void onRequestError(String msg) {
        nameTv.setText(msg);
        TLog.d(msg);
    }

    @Override
    public void setName(String name) {
        nameTv.setText(name);
    }
}
