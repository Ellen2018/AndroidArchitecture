package com.ellen.androidarchitecture.kmvp.base

import androidx.fragment.app.Fragment
import javax.inject.Inject

class BaseFragment<P : BasePresenter<BaseModel,BaseView>> : Fragment() {
    @Inject
    protected lateinit var mPresenter:P
}