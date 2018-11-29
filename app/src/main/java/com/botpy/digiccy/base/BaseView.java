package com.botpy.digiccy.base;

/**
 * @author liuxuhui
 * @date 2018/11/19
 */
public interface BaseView {

    void onRequestStart();

    void onRequestEnd();

    void onRequestError(String msg);
}
