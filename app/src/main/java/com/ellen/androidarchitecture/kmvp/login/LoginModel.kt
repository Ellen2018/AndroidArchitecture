package com.ellen.androidarchitecture.kmvp.login

import android.util.Log
import com.ellen.androidarchitecture.kmvp.login.bean.LoginBean
import com.ellen.androidarchitecture.kmvp.net.RetrofitManager
import io.reactivex.rxjava3.core.Observable
import javax.inject.Inject

/**
 * 登录Model层
 */
class LoginModel @Inject constructor():  LoginContract.LoginModel {

    override fun loginByAccountPassword(account: String, password: String): Observable<LoginBean> {
        return RetrofitManager.instance.login(account, password)
    }

    override fun attachedByPresenter() {
        super.attachedByPresenter()
        Log.e("Ellen2020","LoginPresenter绑定了LoginModel")
    }

    override fun detachedByPresenter() {
        super.detachedByPresenter()
        Log.e("Ellen2020","LoginPresenter解绑了LoginModel")
    }
}


