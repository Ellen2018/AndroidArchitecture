package com.ellen.java.jmvp.login;

import android.util.Log;

public class LoginModel extends LoginContract.LoginModel {

    @Override
    public String login(String account, String password) {
        return "test";
    }

    @Override
    protected void attachedByPresenter() {
        super.attachedByPresenter();
        Log.e("Ellen2020","Presenter绑定了Model");
    }

    @Override
    protected void detachedByPresenter() {
        super.detachedByPresenter();
        Log.e("Ellen2020","Presenter解绑了Model");
    }
}
