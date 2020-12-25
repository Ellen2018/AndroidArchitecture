package com.ellen.java.jmvp.login;

public class LoginModel implements LoginContract.LoginModel {

    @Override
    public String login(String account, String password) {
        return "test";
    }

    @Override
    public void attachPresenter(LoginPresenter mPresenter) {

    }

    @Override
    public void detachPresenter(LoginPresenter mPresenter) {

    }
}
