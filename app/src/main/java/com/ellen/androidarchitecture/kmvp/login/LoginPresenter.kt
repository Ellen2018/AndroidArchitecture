package com.ellen.androidarchitecture.kmvp.login

import android.text.TextUtils
import android.util.Log
import com.ellen.androidarchitecture.kmvp.base.BasePresenter
import com.ellen.androidarchitecture.kmvp.login.bean.LoginBean
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.functions.Consumer
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.*
import javax.inject.Inject

/**
 * 登录Presenter层
 */
class LoginPresenter : BasePresenter<LoginModel, LoginContract.LoginView> {

    @Inject
    constructor(mModel: LoginModel, mView: LoginContract.LoginView) : super(mModel, mView)

    fun login(account: String, password: String){
        if(TextUtils.isEmpty(account) || TextUtils.isEmpty(password)){
            mView.loginFailure("帐号或者密码不能为空!")
            return
        }
        val observable = mModel.loginByAccountPassword(account, password)
        Log.e("Ellen2020","获取RxJava成功")
        observable.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Observer<LoginBean>{

                override fun onSubscribe(d: Disposable) {

                }

                override fun onNext(t: LoginBean) {
                    if(t.data == null){
                        mView.loginFailure(t.errorMsg)
                    }else {
                        mView.loginSuccess(t)
                    }
                }

                override fun onError(e: Throwable) {
                    e.message?.let { mView.loginFailure(it) }
                }

                override fun onComplete() {
                }

            })
    }
}