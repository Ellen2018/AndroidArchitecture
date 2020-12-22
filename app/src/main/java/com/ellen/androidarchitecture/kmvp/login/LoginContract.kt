package com.ellen.androidarchitecture.kmvp.login

import com.ellen.androidarchitecture.kmvp.base.BaseModel
import com.ellen.androidarchitecture.kmvp.base.BaseView

/**
 * MVP的协议层
 */
interface LoginContract {

    interface LoginModel:BaseModel{
        /**
         * 帐号密码登录
         */
        fun loginByAccountPassword(account:String,password:String):String
    }

    interface LoginView:BaseView{

        /**
         * 登录成功
         */
        fun loginSuccess()

        /**
         * 登录失败
         */
        fun loginFailure(errMessage:String)
    }
}