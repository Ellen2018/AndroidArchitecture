package com.ellen.androidarchitecture.kmvp.net

import com.ellen.androidarchitecture.kmvp.login.bean.LoginBean
import io.reactivex.rxjava3.core.Observable
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitManager private constructor(){

    private var retrofit:Retrofit
    private var apiService:Api

    companion object {
        //通过@JvmStatic注解，使得在Java中调用instance直接是像调用静态函数一样，
        //类似KLazilyDCLSingleton.getInstance(),如果不加注解，在Java中必须这样调用: KLazilyDCLSingleton.Companion.getInstance().
        @JvmStatic
        //使用lazy属性代理，并指定LazyThreadSafetyMode为SYNCHRONIZED模式保证线程安全
        val instance: RetrofitManager by lazy(LazyThreadSafetyMode.SYNCHRONIZED) { RetrofitManager() }

        //域名
        const val BASE_URL = "https://www.wanandroid.com"
        //登录
        const val LOGIN_URL = "/user/login"
    }

    fun login(account:String,password:String):Observable<LoginBean>{
        return apiService.login(LOGIN_URL,account,password)
    }

    init {
        retrofit =
            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(
                    OkHttpClient
                        .Builder()
                        .build()
                )
                .addConverterFactory(GsonConverterFactory.create()) //支持Json
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create()) // 支持RxJava
                .build()
        apiService = retrofit.create(Api::class.java)
    }

}