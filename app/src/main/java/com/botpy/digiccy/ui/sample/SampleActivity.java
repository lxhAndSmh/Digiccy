package com.botpy.digiccy.ui.sample;

import android.widget.TextView;

import com.botpy.digiccy.R;
import com.botpy.digiccy.base.BaseActivity;
import com.botpy.digiccy.util.ToastUtil;

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
        ToastUtil.show(this, "开始");
    }

    @Override
    public void onRequestEnd() {
        ToastUtil.show(this, "结束");
    }

    @Override
    public void onRequestError(String msg) {
        nameTv.setText(msg);
    }

    @Override
    public void setName(String name) {
        nameTv.setText(name);
    }
}
