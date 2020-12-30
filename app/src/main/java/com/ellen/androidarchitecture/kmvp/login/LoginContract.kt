package com.ellen.androidarchitecture.kmvp.login

import com.ellen.androidarchitecture.kmvp.base.model.BaseLRModel
import com.ellen.androidarchitecture.kmvp.base.BaseView
import com.ellen.androidarchitecture.kmvp.base.model.BaseModel
import com.ellen.androidarchitecture.kmvp.base.model.BaseRModel
import com.ellen.androidarchitecture.kmvp.login.bean.LoginBean
import com.ellen.androidarchitecture.kmvp.login.bean.UserAccount
import com.ellen.androidarchitecture.kmvp.login.model.LoginLocalModel
import com.ellen.androidarchitecture.kmvp.login.model.LoginRemoteModel
import io.reactivex.rxjava3.core.Observable
import kotlinx.coroutines.Deferred

/**
 * MVP的协议层
 */
interface LoginContract {

    abstract class LoginModel: BaseLRModel<LoginLocalModel,LoginRemoteModel>(){
        /**
         * 帐号密码登录
         */
        abstract fun loginByAccountPasswordRxJava(account:String,password:String): Observable<LoginBean>

        /**
         * 帐号密码登录
         */
        abstract fun loginByAccountPasswordCoroutineAsync(account:String, password:String) : Deferred<LoginBean>

        /**
         * 保存帐号与密码
         */
        abstract fun save(userAccount: UserAccount)

        /**
         * 读取帐号和密码
         */
        abstract fun read():UserAccount?
    }

    interface LoginView:BaseView{

        /**
         * 登录成功
         */
        fun loginSuccess(jsonBean:LoginBean)

        /**
         * 登录失败
         */
        fun loginFailure(errMessage:String)

        /**
         * 初始化帐号和密码
         */
        fun initUserAccount(userAccount: UserAccount?)
    }
}