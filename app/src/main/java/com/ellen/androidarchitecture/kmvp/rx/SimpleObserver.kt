package com.ellen.androidarchitecture.kmvp.rx

import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable

/**
 * 简化Observer代码
 */
abstract class SimpleObserver<T> : Observer<T> {

    override fun onSubscribe(d: Disposable?) {
    }

    override fun onComplete() {
    }

}