package com.ellen.java.jmvp.base;

public abstract class BaseModel{
    /**
     * 被Presenter绑定时调用
     */
    protected void attachedByPresenter(){}

    /**
     * 被Presenter解绑时调用
     */
    protected void detachedByPresenter(){}
}
