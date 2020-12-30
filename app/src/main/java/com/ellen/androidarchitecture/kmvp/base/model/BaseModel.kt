package com.ellen.androidarchitecture.kmvp.base.model

/**
 * MVP中的M层
 */
abstract class BaseModel{


    /**
     * 绑定时调用
     */
    open fun attachedByPresenter(){}

    /**
     * 取消绑定时调用
     */
    open fun detachedByPresenter(){}
}