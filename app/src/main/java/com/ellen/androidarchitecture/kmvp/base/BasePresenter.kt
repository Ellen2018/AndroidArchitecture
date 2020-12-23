package com.ellen.androidarchitecture.kmvp.base

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import com.ellen.androidarchitecture.kmvp.base.life.MvpLifeCycle

/**
 * MVP中的Presenter层
 */
abstract class BasePresenter<M : BaseModel,V : BaseView>(
    /**
     * M层
     */
    var mModel: M,
    /**
     * V层
     */
    var mView: V
) {

    /**
     * 生命周期感知，防止内存泄漏 & 及时释放资源
     */
    private lateinit var lifecycle:Lifecycle
    private lateinit var lifecycleObserver: LifecycleObserver

    /**
     * 这个方法用于生命周期的绑定
     */
    fun attachLifecycle(lifecycle: Lifecycle){
        this.lifecycle = lifecycle
        lifecycleObserver = MvpLifeCycle(object : MvpLifeCycle.Callback{
            override fun onDestroy() {
                detach()
                this@BasePresenter.lifecycle.removeObserver(lifecycleObserver)
            }
        })
        this.lifecycle.addObserver(lifecycleObserver)
    }

    open fun attach(){
    }

    open fun detach(){
    }
}