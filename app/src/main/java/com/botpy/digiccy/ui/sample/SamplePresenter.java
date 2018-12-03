package com.botpy.digiccy.ui.sample;

import com.botpy.digiccy.base.RxPresenter;
import com.botpy.digiccy.util.RxUtil;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;

/**
 * @author liuxuhui
 * @date 2018/11/19
 */
public class SamplePresenter extends RxPresenter<SampleContract.View> implements SampleContract.Presenter {
    @Override
    public void getData() {
        addSubscribe(Flowable.just("Hanmeimei")
                .doOnSubscribe(subscription -> mView.onRequestStart())
                .subscribeOn(AndroidSchedulers.mainThread())
                .compose(RxUtil.applySchedlers())
                .subscribe(name -> mView.setName(name),
                        error -> mView.onRequestError("数据错误"),
                        () -> mView.onRequestEnd()));
    }


}
