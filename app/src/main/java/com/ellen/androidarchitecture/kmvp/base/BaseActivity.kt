package com.ellen.androidarchitecture.kmvp.base

import androidx.appcompat.app.AppCompatActivity
import javax.inject.Inject

open class BaseActivity<P : BasePresenter<*,*>> : AppCompatActivity(),BaseView {
    @Inject
    protected lateinit var mPresenter:P
}