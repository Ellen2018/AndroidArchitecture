package com.ellen.androidarchitecture.kmvp.login

import android.util.Log
import com.ellen.androidarchitecture.kmvp.base.BasePresenter
import com.ellen.androidarchitecture.kmvp.login.bean.LoginBean
import com.ellen.androidarchitecture.kmvp.net.RetrofitManager
import com.ellen.androidarchitecture.kmvp.rx.RxUtils
import com.ellen.androidarchitecture.kmvp.rx.SimpleObserver
import com.ellen.androidarchitecture.kmvp.utils.AccountPasswordCheckUtils
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

/**
 * 登录Presenter层
 */
class LoginPresenter : BasePresenter<LoginModel, LoginContract.LoginView> {

    @Inject
    constructor(mModel: LoginModel, mView: LoginContract.LoginView) : super(mModel, mView)

    /**
     * 使用 RxJava 请求网络
     */
    fun loginByRxJava(account: String, password: String) {
        AccountPasswordCheckUtils.check(
            account,
            password,
            object : AccountPasswordCheckUtils.CheckCallback {
                override fun onSuccess() {
                    //检验成功发起请求
                    val observable = mModel.loginByAccountPasswordRxJava(account, password)
                    RxUtils.start(observable, object : SimpleObserver<LoginBean>() {

                        override fun onNext(t: LoginBean) {
                            if (t.data == null) {
                                mView.loginFailure(t.errorMsg)
                            } else {
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

    /**
     * 使用协程请求网络
     */
    fun loginByCoroutine(account: String, password: String) {

        AccountPasswordCheckUtils.check(account,password,object : AccountPasswordCheckUtils.CheckCallback{
            override fun onSuccess() {
                //使用协程发起网络请求
                var data: LoginBean? = null
                GlobalScope.launch(Dispatchers.Main) {
                    withContext(Dispatchers.IO) {
                        data = RetrofitManager.instance.loginByCoroutines(account, password).await()
                    }
                    if(data != null) {
                        val netData = data as LoginBean
                        if(netData.data == null){
                            mView.loginFailure(netData.errorMsg)
                        }else{
                            mView.loginSuccess(netData)
                        }
                    }else{
                        mView.loginFailure("登录超时异常!")
                    }

                }
            }

            override fun onFailure(errMessage: String) {
                mView.loginFailure(errMessage)
            }

        })

    }

    override fun attachedByView() {
        super.attachedByView()
        Log.e("Ellen2020", "LoginView绑定了LoginPresenter")
    }

    override fun detachedByView() {
        super.detachedByView()
        Log.e("Ellen2020", "LoginView解绑了LoginPresenter")
    }
}