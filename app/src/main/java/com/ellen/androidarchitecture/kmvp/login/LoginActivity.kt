package com.ellen.androidarchitecture.kmvp.login

import android.os.Bundle
import android.text.Editable
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.ellen.androidarchitecture.R
import com.ellen.androidarchitecture.kmvp.di.module.*
import com.ellen.androidarchitecture.kmvp.base.BaseMvpActivity
import com.ellen.androidarchitecture.kmvp.di.component.DaggerLoginComponent
import com.ellen.androidarchitecture.kmvp.login.bean.LoginBean
import com.ellen.androidarchitecture.kmvp.login.bean.UserAccount
import com.google.gson.Gson

/**
 * 登录View层
 */
class LoginActivity : BaseMvpActivity<LoginPresenter>(),LoginContract.LoginView {

    private lateinit var etAccount:EditText
    private lateinit var etPassword:EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        etAccount = findViewById(R.id.et_account)
        etPassword = findViewById(R.id.et_password)
        //读取帐号
        mPresenter.readAccount()
        findViewById<Button>(R.id.bt_login).setOnClickListener {
            val account = etAccount.text.toString()
            val password = etPassword.text.toString()
            mPresenter.loginByCoroutine(account,password)
        }
    }

    override fun loginSuccess(jsonBean:LoginBean) {
        Toast.makeText(this,"《${jsonBean.data?.nickname}》登录成功",Toast.LENGTH_SHORT).show()
    }

    override fun loginFailure(errMessage: String) {
        Toast.makeText(this,"登录失败:${errMessage}",Toast.LENGTH_SHORT).show()
    }

    override fun initUserAccount(userAccount: UserAccount?) {
        if(userAccount != null) {
            //设置记录的帐号
            etAccount.text = Editable.Factory.getInstance().newEditable(userAccount.account)

            //设置记录的密码
            etPassword.text = Editable.Factory.getInstance().newEditable(userAccount.password)
        }
    }

    override fun initMVP() {
        //简化Dagger2的代码
        DaggerLoginComponent
            .builder()
            .loginModule(LoginModule(this))
            .build()
            .injectLoginActivity(this)
    }

    override fun attachedByPresenter() {
        Log.e("Ellen2020","LoginPresenter绑定了LoginView")
    }

    override fun detachedByPresenter() {
        Log.e("Ellen2020","LoginPresenter解绑了LoginView")
    }
}