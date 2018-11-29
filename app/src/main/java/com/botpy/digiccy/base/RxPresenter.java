package com.botpy.digiccy.base;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * @author liuxuhui
 * @date 2018/11/19
 * 控制订阅的生命周期和view的绑定
 */
public class RxPresenter<T extends BaseView> {

    protected T mView;
    protected CompositeDisposable mCompositeDisposable;

    protected void addSubscribe(Disposable disposable) {
        if(mCompositeDisposable == null) {
            mCompositeDisposable = new CompositeDisposable();
        }
        mCompositeDisposable.add(disposable);
    }

    private void unSubscribe() {
        if(mCompositeDisposable != null) {
            mCompositeDisposable.clear();
        }
    }

    public void attachView(T view) {
        this.mView = view;
    }

    public void detachView() {
        this.mView = null;
        unSubscribe();
    }
}
