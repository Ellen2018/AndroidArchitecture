package com.ellen.androidarchitecture.kmvp.login

import com.ellen.androidarchitecture.kmvp.base.BaseModel
import com.ellen.androidarchitecture.kmvp.base.BaseView
import com.ellen.androidarchitecture.kmvp.login.bean.LoginBean
import io.reactivex.rxjava3.core.Observable

/**
 * MVP的协议层
 */
interface LoginContract {

    interface LoginModel:BaseModel{
        /**
         * 帐号密码登录
         */
        fun loginByAccountPassword(account:String,password:String): Observable<LoginBean>
    }

    interface LoginView:BaseView{

        /**
         * 登录成功
         */
        fun loginSuccess(jsonBean:LoginBean)

        /**
         * 登录失败
         */
        fun loginFailure(errMessage:String)
    }
}