package com.ellen.java.jmvp.base;

import androidx.lifecycle.Lifecycle;

import com.ellen.java.jmvp.base.life.MvpLifeCycle;

public class BasePresenter<M extends BaseModel,V extends BaseView> {

    public M mModel;
    public V mView;

    public BasePresenter(M mModel,V mView){
        this.mModel = mModel;
        this.mView = mView;
    }

    private Lifecycle lifecycle;
    private MvpLifeCycle mvpLifeCycle;

    /**
     * 绑定生命监听的组件LifeCycle,让P层拥有生命周期的感应
     * @param lifecycle
     */
    void  attachLifeCycle(Lifecycle lifecycle){
        this.lifecycle = lifecycle;
        mvpLifeCycle = new MvpLifeCycle(new MvpLifeCycle.Callback() {
            @Override
            public void onDestroy() {
                 detach();
                 BasePresenter.this.lifecycle.removeObserver(mvpLifeCycle);
            }
        });
        this.lifecycle.addObserver(mvpLifeCycle);
    }

    protected void detach(){}
    protected void attach(){}
}
