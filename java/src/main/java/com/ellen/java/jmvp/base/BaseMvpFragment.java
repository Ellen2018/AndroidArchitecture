package com.ellen.java.jmvp.base;

import androidx.fragment.app.Fragment;

import javax.inject.Inject;

public class BaseMvpFragment<P extends BasePresenter> extends Fragment {

    @Inject
    protected P mPresenter;

}
