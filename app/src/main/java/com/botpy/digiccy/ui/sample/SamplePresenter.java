package com.botpy.digiccy.ui.sample;

import com.botpy.digiccy.base.RxPresenter;
import com.botpy.digiccy.util.RxUtil;

import io.reactivex.Flowable;

/**
 * @author liuxuhui
 * @date 2018/11/19
 */
public class SamplePresenter extends RxPresenter<SampleContract.View> implements SampleContract.Presenter {
    @Override
    public void getData() {
        addSubscribe(Flowable.just("Hanmeimei")
        .compose(RxUtil.applySchedlers())
        .subscribe(name -> mView.setName(name),
            error -> mView.onRequestError("数据错误"),
            () -> mView.onRequestEnd()));
    }


}
