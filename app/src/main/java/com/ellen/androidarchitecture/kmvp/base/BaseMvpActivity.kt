package com.ellen.androidarchitecture.kmvp.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import javax.inject.Inject

abstract class BaseMvpActivity<P : BasePresenter<*,*>> : AppCompatActivity(),BaseView {
    @Inject
    protected lateinit var mPresenter:P

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initMVP()

        //调用MVP的绑定attach周期函数
        mPresenter.attachedByView()
        mPresenter.mView.attachedByPresenter()
        mPresenter.mModel.attachedByPresenter()

        //让Presenter感知生命周期，以防止内存泄漏
        mPresenter.attachLifecycle(lifecycle)
    }

    abstract fun initMVP();
}