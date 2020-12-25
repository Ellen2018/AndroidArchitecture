package com.ellen.java.jmvp.base;

public abstract class BaseModel<P extends BasePresenter> {
    /**
     * 绑定Presenter时调用
     * @param mPresenter
     */
    protected void attachPresenter(P mPresenter){}

    /**
     * 解绑Presenter时调用
     * @param mPresenter
     */
    protected void detachPresenter(P mPresenter){}
}
