package com.ellen.androidarchitecture.kmvp.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import javax.inject.Inject

abstract class BaseActivity<P : BasePresenter<*,*>> : AppCompatActivity(),BaseView {
    @Inject
    protected lateinit var mPresenter:P

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initMVP()
        mPresenter.attach()
        //让Presenter感知生命周期，以防止内存泄漏
        mPresenter.attachLifecycle(lifecycle)
    }

    abstract fun initMVP();
}