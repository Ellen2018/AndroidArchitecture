package com.ellen.androidarchitecture.kmvp.base

/**
 * MVP中的Presenter层
 */
abstract class BasePresenter<M : BaseModel,V : BaseView> constructor(var mModel:M,var mView:V)