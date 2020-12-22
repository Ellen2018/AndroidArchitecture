package com.ellen.androidarchitecture.dagger.component

import com.ellen.androidarchitecture.kmvp.login.LoginActivity
import com.ellen.androidarchitecture.kmvp.login.LoginPresenter
import dagger.Component

@Component
interface LoginComponent {
    fun injectLoginActivity(loginActivity: LoginActivity)
    fun injectLoginPresenter(loginPresenter: LoginPresenter)
}