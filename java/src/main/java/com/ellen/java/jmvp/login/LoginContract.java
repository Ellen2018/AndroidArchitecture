package com.ellen.java.jmvp.login;

import com.ellen.java.jmvp.base.BaseModel;
import com.ellen.java.jmvp.base.BaseView;

public interface LoginContract {

    abstract class LoginModel extends BaseModel{
        abstract String login(String account,String password);
    }

    interface LoginView extends BaseView{
        abstract void loginSuccess();
        abstract void loginFailure(String errMessage);
    }
}
