package com.ellen.androidarchitecture.kmvp.login

import android.util.Log
import com.ellen.androidarchitecture.kmvp.base.BasePresenter
import com.ellen.androidarchitecture.kmvp.login.bean.LoginBean
import com.ellen.androidarchitecture.kmvp.rx.RxUtils
import com.ellen.androidarchitecture.kmvp.rx.SimpleObserver
import com.ellen.androidarchitecture.kmvp.utils.AccountPasswordCheckUtils
import javax.inject.Inject

/**
 * 登录Presenter层
 */
class LoginPresenter : BasePresenter<LoginModel, LoginContract.LoginView> {

    @Inject
    constructor(mModel: LoginModel, mView: LoginContract.LoginView) : super(mModel, mView)

    fun login(account: String, password: String){
        AccountPasswordCheckUtils.check(account,password,object :AccountPasswordCheckUtils.CheckCallback{
            override fun onSuccess() {
                //检验成功发起请求
                val observable = mModel.loginByAccountPassword(account, password)
                RxUtils.start(observable,object : SimpleObserver<LoginBean>(){

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

                })
            }

            override fun onFailure(errMessage: String) {
                mView.loginFailure(errMessage)
            }
        })
    }

    override fun attachedByView() {
        super.attachedByView()
        Log.e("Ellen2020","LoginView绑定了LoginPresenter")
    }

    override fun detachedByView() {
        super.detachedByView()
        Log.e("Ellen2020","LoginView解绑了LoginPresenter")
    }
}