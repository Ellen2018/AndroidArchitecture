package com.ellen.androidarchitecture.kmvp.base.model

abstract class BaseLModel<L:LocalModel> : BaseModel() {

    init {
        initModel()
    }

    /**
     * 本地Model
     * 数据库
     * key-value存储
     * 文件存储等本地数据源
     */
    protected lateinit var lModel:L

    /**
     * 初始化Model
     */
    abstract fun initModel()
}