package com.ellen.java.jmvp.login;

import android.util.Log;

import com.ellen.java.jmvp.base.BaseMvpActivity;
import com.ellen.java.jmvp.base.BasePresenter;
import com.ellen.java.jmvp.di.component.DaggerLoginComponent;
import com.ellen.java.jmvp.di.module.LoginModule;

public class LoginActivity extends BaseMvpActivity<LoginPresenter> implements LoginContract.LoginView {

    @Override
    public void loginSuccess() {

    }

    @Override
    public void loginFailure(String errMessage) {

    }

    @Override
    protected void initMvp() {
        //利用Dagger2依赖注入初始化MVP
        DaggerLoginComponent.builder()
                .loginModule(new LoginModule(this))
                .build()
                .injectLoginActivity(this);
    }

    @Override
    public void attachedByPresenter() {
       Log.e("Ellen2020","Presenter绑定了View");
    }

    @Override
    public void detachedByPresenter() {
        Log.e("Ellen2020","Presenter解绑了View");
    }
}
