package com.ellen.androidarchitecture.kmvp.rx

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers

class RxUtils{

    companion object{
        //简化代码
        fun <T> start(observable: Observable<T>,observer: SimpleObserver<T>){
            observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer)
        }
    }

}