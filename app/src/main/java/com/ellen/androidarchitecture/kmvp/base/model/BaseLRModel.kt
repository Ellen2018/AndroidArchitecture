package com.ellen.androidarchitecture.kmvp.base.model

/**
 * 带有本地Model和远程Model
 */
abstract class BaseLRModel<L: LocalModel,R: RemoteModel> : BaseModel(){

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
     * 远程Model
     * 网络
     * 蓝牙等远程数据源
     */
    protected lateinit var rModel:R

    /**
     * 初始化Model
     */
    protected abstract fun initModel()
}