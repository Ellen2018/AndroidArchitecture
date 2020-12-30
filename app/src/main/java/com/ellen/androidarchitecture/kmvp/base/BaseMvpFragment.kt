package com.ellen.androidarchitecture.kmvp.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ellen.androidarchitecture.kmvp.base.model.BaseModel
import javax.inject.Inject

abstract class BaseMvpFragment<P : BasePresenter<BaseModel,BaseView>> : Fragment() {
    @Inject
    protected lateinit var mPresenter:P

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        initMVP()

        //调用MVP的绑定attach周期函数
        mPresenter.attachedByView()
        mPresenter.mView.attachedByPresenter()
        mPresenter.mModel.attachedByPresenter()

        //让Presenter感知生命周期，以防止内存泄漏
        mPresenter.attachLifecycle(lifecycle)
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    abstract fun initMVP()
}