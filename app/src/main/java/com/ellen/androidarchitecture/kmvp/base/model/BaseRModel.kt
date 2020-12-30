package com.ellen.androidarchitecture.kmvp.base.model

abstract class BaseRModel<R:RemoteModel> : BaseModel() {

    init {
        initModel()
    }

    /**
     * 远程Model
     * 网络
     * 蓝牙等远程数据源
     */
    protected lateinit var rModel:R

    /**
     * 初始化Model
     */
    abstract fun initModel()
}