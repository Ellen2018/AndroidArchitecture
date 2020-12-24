package com.ellen.java.jmvp.di.module;

import com.ellen.java.jmvp.login.LoginContract;
import com.ellen.java.jmvp.login.LoginModel;
import com.ellen.java.jmvp.login.LoginPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class LoginModule {

    private LoginContract.LoginView view;

    public LoginModule(LoginContract.LoginView view){
        this.view = view;
    }

    @Provides
    LoginPresenter provideLoginPresenter(LoginModel loginModel, LoginContract.LoginView loginView){
        return new LoginPresenter(loginModel,loginView);
    }

    @Provides
    LoginModel provideLoginModel(){
        return new LoginModel();
    }

    @Provides
    LoginContract.LoginView provideLoginView(){
        return view;
    }

}
