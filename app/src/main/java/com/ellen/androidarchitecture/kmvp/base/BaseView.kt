package com.ellen.androidarchitecture.kmvp.base

/**
 * MVP中的V层
 */
interface BaseView{
    /**
     * 绑定时调用
     */
    fun attachPresenter(){}

    /**
     * 取消绑定时调用
     */
    fun detachPresenter(){}
}