package com.ellen.androidarchitecture.di.module

import com.ellen.androidarchitecture.kmvp.login.LoginContract
import com.ellen.androidarchitecture.kmvp.login.LoginModel
import com.ellen.androidarchitecture.kmvp.login.LoginPresenter
import dagger.Module
import dagger.Provides

@Module
class LoginModule(private var view: LoginContract.LoginView) {

    @Provides
    fun provideLoginPresenter(loginModel: LoginModel,loginView: LoginContract.LoginView) : LoginPresenter{
        return LoginPresenter(loginModel,loginView)
    }

    @Provides
    fun provideLoginModel() : LoginModel{
        return LoginModel()
    }

    @Provides
    fun provideLoginView():LoginContract.LoginView{
        return view
    }
}