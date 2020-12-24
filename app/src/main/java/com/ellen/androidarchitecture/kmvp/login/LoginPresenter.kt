package com.ellen.androidarchitecture.kmvp.login

import android.text.TextUtils
import android.widget.TextView
import com.ellen.androidarchitecture.kmvp.base.BasePresenter
import com.ellen.androidarchitecture.kmvp.login.bean.LoginBean
import com.google.gson.Gson
import javax.inject.Inject

/**
 * 登录Presenter层
 */
class LoginPresenter : BasePresenter<LoginModel, LoginContract.LoginView> {

    @Inject
    constructor(mModel:LoginModel,mView:LoginContract.LoginView) : super(mModel,mView)

    fun login(account:String,password:String){
        if(TextUtils.isEmpty(account) || TextUtils.isEmpty(password)){
            mView.loginFailure("帐号或者密码不能为空!")
            return
        }
        mModel.loginByAccountPassword(account,password,object  : LoginModel.Callback{

            override fun onSuccess(json: String) {
                val g = Gson()
                val loginBean = g.fromJson(json,LoginBean::class.java)
                if(loginBean.data == null){
                    mView.loginFailure(loginBean.errorMsg)
                }else {
                    mView.loginSuccess(loginBean)
                }
            }

            override fun onFailure(errMessage: String) {
                mView.loginFailure(errMessage)
            }
        })
    }
}