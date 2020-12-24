package com.ellen.androidarchitecture.kmvp.login

import okhttp3.*
import java.io.IOException
import javax.inject.Inject

/**
 * 登录Model层
 */
class LoginModel @Inject constructor():  LoginContract.LoginModel {

    //https://www.wanandroid.com/user/login
    override fun loginByAccountPassword(account: String, password: String, callback: Callback):String {
        val okHttpClient = OkHttpClient()

        val formBody = FormBody
            .Builder()
            .add("username", account)
            .add("password", password)
            .build()

        val request = Request.Builder()
            .post(formBody)
            .url("https://www.wanandroid.com/user/login")
            .build()

        val call = okHttpClient.newCall(request)

        call.enqueue(object : okhttp3.Callback{
            override fun onFailure(call: Call, e: IOException) {
                e.message?.let { callback.onFailure(it) }
            }

            override fun onResponse(call: Call, response: Response) {
                response.body()?.string()?.let { callback.onSuccess(it) }
            }
        })
       return "test"
    }

    interface Callback{
        fun onSuccess(json: String)
        fun onFailure(errMessage:String)
    }
}


