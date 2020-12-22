package com.ellen.androidarchitecture.kmvp.login

import com.ellen.androidarchitecture.dagger.module.LoginModule
import com.ellen.androidarchitecture.dagger.module.LoginModule_GetLoginModelFactory
import com.ellen.androidarchitecture.kmvp.base.BasePresenter
import dagger.internal.Factory
import javax.inject.Inject

/**
 * 登录Presenter层
 */
class LoginPresenter @Inject constructor(): BasePresenter<LoginModel, LoginContract.LoginView>() {

    fun login(account:String,password:String){
        var json = mModel.loginByAccountPassword(account,password)
        if(json.isEmpty()){
            mView.loginFailure("请求失败!")
        }else{
            mView.loginSuccess()
        }
    }

    override fun attachView(mView: LoginContract.LoginView) {
       this.mView = mView

        //完成LoginModel的依赖注入
        LoginPresenter_MembersInjector
                .create(LoginModule_GetLoginModelFactory.create(LoginModule()))
                .injectMembers(this)

    }

    override fun destroy() {
    }

}