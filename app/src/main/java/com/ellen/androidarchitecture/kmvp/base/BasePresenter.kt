package com.ellen.androidarchitecture.kmvp.base

import javax.inject.Inject

/**
 * MVP中的Presenter层
 */
abstract class BasePresenter<M : BaseModel,V : BaseView> {
    /**
     * P层持有M层引用
     */
    @Inject
    lateinit var mModel:M

    /**
     * P层持有V层引用
     */
    lateinit var mView:V

    abstract fun attachView(mView:V)
    abstract fun destroy()
}