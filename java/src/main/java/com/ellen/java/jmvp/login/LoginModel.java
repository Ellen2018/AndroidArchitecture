package com.ellen.java.jmvp.login;

public class LoginModel implements LoginContract.LoginModel {

    @Override
    public String login(String account, String password) {
        return "test";
    }

}
