package com.ellen.java.jmvp.login;

import com.ellen.java.jmvp.base.BaseModel;
import com.ellen.java.jmvp.base.BaseView;

public interface LoginContract {

    interface LoginModel extends BaseModel<LoginPresenter>{
        String login(String account,String password);
    }

    interface LoginView extends BaseView<LoginPresenter>{
        void loginSuccess();
        void loginFailure(String errMessage);
    }
}
