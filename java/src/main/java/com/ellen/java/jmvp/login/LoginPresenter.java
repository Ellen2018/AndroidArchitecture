package com.ellen.java.jmvp.login;

import android.util.Log;

import com.ellen.java.jmvp.base.BasePresenter;

import javax.inject.Inject;

public class LoginPresenter extends BasePresenter<LoginModel, LoginContract.LoginView> {

    @Inject
    public LoginPresenter(LoginModel mModel, LoginContract.LoginView mView) {
        super(mModel, mView);
    }

    @Override
    protected void attachedByView() {
        Log.e("Ellen2020","View绑定了Presenter");
    }


    @Override
    protected void detachedByView() {
        Log.e("Ellen2020","View解绑了Presenter");
    }
}
