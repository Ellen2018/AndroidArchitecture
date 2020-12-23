package com.ellen.androidarchitecture.kmvp.login

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.ellen.androidarchitecture.di.module.*
import com.ellen.androidarchitecture.kmvp.base.BaseActivity

/**
 * 登录View层
 */
class LoginActivity : BaseActivity<LoginPresenter>(),LoginContract.LoginView {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //利用Dagger2完成mPresenter的注入
        LoginActivity_MembersInjector.create(
            LoginModule_ProvideLoginPresenterFactory.create(LoginModule(this),
                LoginModule_ProvideLoginModelFactory.create(LoginModule(this)),
                LoginModule_ProvideLoginViewFactory.create(LoginModule(this))
            )).injectMembers(this)
    }

    override fun onResume() {
        super.onResume()
        Log.e("Ellen2020","有没有生产Presenter:${mPresenter.hashCode()}")
        Log.e("Ellen2020","有没有生产View:${mPresenter.mView.hashCode()}")
        Log.e("Ellen2020","有没有生产Model:${mPresenter.mModel.hashCode()}")
    }

    override fun loginSuccess() {
        Toast.makeText(this,"登录成功!",Toast.LENGTH_SHORT).show()
    }

    override fun loginFailure(errMessage: String) {
       Toast.makeText(this,errMessage,Toast.LENGTH_SHORT).show()
    }

}