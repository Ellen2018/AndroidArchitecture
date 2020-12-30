package com.ellen.androidarchitecture.kmvp.login.model

import com.ellen.androidarchitecture.kmvp.base.model.LocalModel
import com.ellen.androidarchitecture.kmvp.login.bean.UserAccount
import com.ellen.androidarchitecture.kmvp.utils.MMKVUtils
import com.google.gson.Gson

/**
 * 负责记录用户登录成功之后的帐号和密码信息
 */
class LoginLocalModel : LocalModel {

    private  var mmkvUtils: MMKVUtils
    private  val g = Gson()

    init {
        mmkvUtils = MMKVUtils(USER_ACCOUNT_FILE_NAME)
    }

    /**
     * 保存帐号和密码
     */
    fun save(userAccount: UserAccount){
        mmkvUtils.save(USER_ACCOUNT_KEY,g.toJson(userAccount))

    }

    /**
     * 读取帐号
     */
    fun readUserAccount() : UserAccount?{
        val json = mmkvUtils.getValue(USER_ACCOUNT_KEY,"")
        return if(json.isEmpty()){
            null
        }else{
            g.fromJson(json,UserAccount::class.java)
        }
    }

    companion object{
        private const val USER_ACCOUNT_FILE_NAME = "user_account_file_name"
        private const val USER_ACCOUNT_KEY = "user_account_key"
    }

}