package com.ellen.androidarchitecture.kmvp.login

import javax.inject.Inject

/**
 * 登录Model层
 */
class LoginModel @Inject constructor():  LoginContract.LoginModel {
    override fun loginByAccountPassword(account: String, password: String):String {
       return "test"
    }
}