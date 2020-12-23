package com.ellen.androidarchitecture.kmvp.di.component

import com.ellen.androidarchitecture.kmvp.di.module.LoginModule
import com.ellen.androidarchitecture.kmvp.login.LoginActivity
import dagger.Component

@Component(modules = [LoginModule::class])
interface LoginComponent {
    fun injectLoginActivity(loginActivity: LoginActivity)
}