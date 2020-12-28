package com.ellen.androidarchitecture.kmvp.net

import com.ellen.androidarchitecture.kmvp.login.bean.LoginBean
import io.reactivex.rxjava3.core.Observable
import kotlinx.coroutines.Deferred
import retrofit2.http.POST
import retrofit2.http.Query
import retrofit2.http.Url

/**
 * 网络请求的API
 */
interface Api {

    /**
     * 基于RxJava实现方式
     */
    @POST
    fun loginByRxJava(@Url path:String, @Query("username") account: String, @Query("password") password:String):Observable<LoginBean>

    /**
     * 基于协程实现
     */
    @POST
    fun loginByCoroutineAsync(@Url path:String, @Query("username") account: String, @Query("password") password:String): Deferred<LoginBean>


}