package com.ellen.java.jmvp.base;

public interface BaseView{
    /**
     * 被Presenter绑定时调用
     */
    void attachedByPresenter();

    /**
     * 被Presenter解绑时调用
     */
    void detachedByPresenter();
}
