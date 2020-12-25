package com.ellen.java.jmvp.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import javax.inject.Inject;

public abstract class BaseMvpActivity<P extends BasePresenter> extends AppCompatActivity {

    @Inject
    protected P mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initMvp();

        //调用MVP的生命周期函数attach
        mPresenter.attachView();
        mPresenter.mView.attachPresenter(mPresenter);
        mPresenter.mModel.attachPresenter(mPresenter);

        mPresenter.attachLifeCycle(getLifecycle());
    }

    protected abstract void initMvp();
}
