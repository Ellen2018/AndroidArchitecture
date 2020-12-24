package com.ellen.java.jmvp.di.component;

import com.ellen.java.jmvp.di.module.LoginModule;
import com.ellen.java.jmvp.login.LoginActivity;

import dagger.Component;

@Component(modules = {LoginModule.class})
public interface LoginComponent {
    void injectLoginActivity(LoginActivity loginActivity);
}
