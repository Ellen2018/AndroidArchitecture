package com.ellen.java.jmvp.base.life;

import android.util.Log;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

public class MvpLifeCycle implements LifecycleObserver {

    private Callback callback;

    public MvpLifeCycle(Callback callback){
        this.callback = callback;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void onCreate(){
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void onPause(){

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void onStart(){
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void onResume(){
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void onStop(){
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroy(){
        callback.onDestroy();
    }

    public interface Callback{
        void onDestroy();
    }
}
