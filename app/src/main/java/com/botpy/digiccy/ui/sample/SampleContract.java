package com.botpy.digiccy.ui.sample;

import com.botpy.digiccy.base.BaseView;
import com.botpy.digiccy.base.RxPresenter;

/**
 * @author liuxuhui
 * @date 2018/11/19
 */
public interface SampleContract {

    interface View extends BaseView {
        void setName(String name);
    }

    interface Presenter {
        void getData();
    }
}
