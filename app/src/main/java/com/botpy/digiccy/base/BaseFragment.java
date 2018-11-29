package com.botpy.digiccy.base;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.botpy.digiccy.R;
import com.botpy.digiccy.util.TUtil;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @author liuxuhui 
 * @date 2018/11/26
 */
public abstract class BaseFragment<T extends RxPresenter> extends Fragment implements BaseView{

    protected Context mContext;
    protected T mPresenter;
    private Unbinder mUnbinder;

    public BaseFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        mContext = context;
        super.onAttach(context);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(getLayout(), null);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mUnbinder = ButterKnife.bind(this, view);
        mPresenter = TUtil.getT(this, 0);
        mPresenter.attachView(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mUnbinder.unbind();
        mPresenter.detachView();
    }

    protected abstract int getLayout();

}
