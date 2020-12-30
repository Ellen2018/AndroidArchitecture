package com.ellen.androidarchitecture.kmvp.login.model

import android.util.Log
import com.ellen.androidarchitecture.kmvp.login.LoginContract
import com.ellen.androidarchitecture.kmvp.login.bean.LoginBean
import com.ellen.androidarchitecture.kmvp.login.bean.UserAccount
import com.ellen.androidarchitecture.kmvp.net.RetrofitManager
import io.reactivex.rxjava3.core.Observable
import kotlinx.coroutines.Deferred
import javax.inject.Inject

/**
 * 登录Model层
 */
class LoginModel @Inject constructor():  LoginContract.LoginModel() {

    override fun loginByAccountPasswordRxJava(account: String, password: String): Observable<LoginBean> {
        return rModel.loginByAccountPasswordRxJava(account, password)
    }

    override fun loginByAccountPasswordCoroutineAsync(
        account: String,
        password: String
    ): Deferred<LoginBean> {
        return rModel.loginByAccountPasswordCoroutineAsync(account, password)
    }

    override fun save(userAccount: UserAccount) {
        lModel.save(userAccount)
    }

    override fun read(): UserAccount? {
        return lModel.readUserAccount()
    }

    override fun initModel() {
        //初始化远程Model
        rModel = LoginRemoteModel()
        //初始化本地Model
        lModel = LoginLocalModel()
    }

    override fun attachedByPresenter() {
        super.attachedByPresenter()
        Log.e("Ellen2020","LoginPresenter绑定了LoginModel")
    }

    override fun detachedByPresenter() {
        super.detachedByPresenter()
        Log.e("Ellen2020","LoginPresenter解绑了LoginModel")
    }
}


