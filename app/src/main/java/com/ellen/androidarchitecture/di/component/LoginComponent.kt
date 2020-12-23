package com.ellen.androidarchitecture.di.component

import com.ellen.androidarchitecture.di.module.LoginModule
import com.ellen.androidarchitecture.kmvp.login.LoginActivity
import com.ellen.androidarchitecture.kmvp.login.LoginPresenter
import dagger.Component

@Component(modules = [LoginModule::class])
interface LoginComponent {
    fun injectLoginActivity(loginActivity: LoginActivity)
}