package com.ellen.java.jmvp.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import javax.inject.Inject;

public abstract class BaseMvpFragment<P extends BasePresenter> extends Fragment {

    @Inject
    protected P mPresenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        initMvp();

        //调用MVP的生命周期函数attach
        mPresenter.attachView();
        mPresenter.mView.attachPresenter(mPresenter);
        mPresenter.mModel.attachPresenter(mPresenter);

        mPresenter.attachLifeCycle(getLifecycle());
        return super.onCreateView(inflater, container, savedInstanceState);
    }

   protected abstract void initMvp();
}
