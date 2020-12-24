package com.ellen.androidarchitecture.kmvp.net

import com.ellen.androidarchitecture.kmvp.login.bean.LoginBean
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.POST
import retrofit2.http.Query
import retrofit2.http.Url

/**
 * 网络请求的API
 */
interface Api {

    @POST
    fun login(@Url path:String, @Query("username") account: String, @Query("password") password:String):Observable<LoginBean>
}