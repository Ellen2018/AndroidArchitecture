package com.ellen.androidarchitecture.kmvp.login.model

import com.ellen.androidarchitecture.kmvp.base.model.RemoteModel
import com.ellen.androidarchitecture.kmvp.login.bean.LoginBean
import com.ellen.androidarchitecture.kmvp.net.RetrofitManager
import io.reactivex.rxjava3.core.Observable
import kotlinx.coroutines.Deferred

/**
 * 负责远端的登录
 */
class LoginRemoteModel : RemoteModel {

    fun loginByAccountPasswordRxJava(account:String,password:String): Observable<LoginBean>{
        return RetrofitManager.instance.loginByRxJava(account,password)
    }

    fun loginByAccountPasswordCoroutineAsync(account:String, password:String) : Deferred<LoginBean>{
        return RetrofitManager.instance.loginByCoroutinesAsync(account, password)
    }
}