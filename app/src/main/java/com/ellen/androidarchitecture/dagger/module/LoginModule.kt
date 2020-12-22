package com.ellen.androidarchitecture.dagger.module

import com.ellen.androidarchitecture.kmvp.login.LoginModel
import com.ellen.androidarchitecture.kmvp.login.LoginPresenter
import dagger.Module
import dagger.Provides

@Module
class LoginModule {

    @Provides
    fun getLoginPresenter() : LoginPresenter{
        return LoginPresenter()
    }

    @Provides
    fun getLoginModel() : LoginModel{
        return LoginModel()
    }
}