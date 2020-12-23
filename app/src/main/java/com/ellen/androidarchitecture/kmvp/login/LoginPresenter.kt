package com.ellen.androidarchitecture.kmvp.login

import android.util.Log
import com.ellen.androidarchitecture.kmvp.base.BasePresenter
import javax.inject.Inject

/**
 * 登录Presenter层
 */
class LoginPresenter : BasePresenter<LoginModel, LoginContract.LoginView> {

    @Inject
    constructor(mModel:LoginModel,mView:LoginContract.LoginView) : super(mModel,mView)

    fun login(account:String,password:String){
        var json = mModel.loginByAccountPassword(account,password)
        if(json.isEmpty()){
            mView.loginFailure("请求失败!")
        }else{
            mView.loginSuccess()
        }
    }
}