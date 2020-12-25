package com.ellen.androidarchitecture.kmvp.base

/**
 * MVP中的M层
 */
interface BaseModel{
    /**
     * 绑定时调用
     */
    fun attachPresenter(){}

    /**
     * 取消绑定时调用
     */
    fun detachPresenter(){}
}