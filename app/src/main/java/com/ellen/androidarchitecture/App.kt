package com.ellen.androidarchitecture

import android.app.Application
import com.tencent.mmkv.MMKV

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        //初始化MMKV
        MMKV.initialize(this)
    }

}