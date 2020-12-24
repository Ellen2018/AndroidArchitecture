package com.ellen.androidarchitecture.kmvp.login

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import com.ellen.androidarchitecture.R
import com.ellen.androidarchitecture.kmvp.di.module.*
import com.ellen.androidarchitecture.kmvp.base.BaseActivity
import com.ellen.androidarchitecture.kmvp.di.component.DaggerLoginComponent
import com.ellen.java.jmvp.login.LoginActivity

/**
 * 登录View层
 */
class LoginActivity : BaseActivity<LoginPresenter>(),LoginContract.LoginView {

    override fun onResume() {
        super.onResume()
        Log.e("Ellen2020","有没有生产Presenter:${mPresenter.hashCode()}")
        Log.e("Ellen2020","有没有生产View:${mPresenter.mView.hashCode()}")
        Log.e("Ellen2020","有没有生产Model:${mPresenter.mModel.hashCode()}")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        findViewById<Button>(R.id.bt_login).setOnClickListener {
            var intent = Intent(this@LoginActivity,LoginActivity::class.java)
            startActivity(intent)
        }
    }

    override fun loginSuccess() {
        Toast.makeText(this,"登录成功!",Toast.LENGTH_SHORT).show()
    }

    override fun loginFailure(errMessage: String) {
       Toast.makeText(this,errMessage,Toast.LENGTH_SHORT).show()
    }

    override fun initMVP() {
        //简化Dagger2的代码
        DaggerLoginComponent
            .builder()
            .loginModule(LoginModule(this))
            .build()
            .injectLoginActivity(this)
    }

}