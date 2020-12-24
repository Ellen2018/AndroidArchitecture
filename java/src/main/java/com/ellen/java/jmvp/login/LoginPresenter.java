package com.ellen.java.jmvp.login;

import com.ellen.java.jmvp.base.BasePresenter;

import javax.inject.Inject;

public class LoginPresenter extends BasePresenter<LoginModel, LoginContract.LoginView> {

    @Inject
    public LoginPresenter(LoginModel mModel, LoginContract.LoginView mView) {
        super(mModel, mView);
    }
}
