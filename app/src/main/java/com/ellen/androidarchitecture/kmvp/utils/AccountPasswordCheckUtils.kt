package com.ellen.androidarchitecture.kmvp.utils

import android.text.TextUtils

class AccountPasswordCheckUtils {

    companion object{

        /**
         * 检测帐号的合法性
         */
        private fun checkAccount(account:String,checkCallback: CheckCallback) =
                when {
                    TextUtils.isEmpty(account) -> {
                        checkCallback.onFailure("帐号不能为空!")
                    }
                    account.length < 8 -> {
                        checkCallback.onFailure("帐号长度不能小于8")
                    }
                    else -> {
                        checkCallback.onSuccess()
                    }
                }

        /**
         * 检测密码的合法性
         */
        private fun checkPassword(password:String,checkCallback: CheckCallback) =
                when {
                    TextUtils.isEmpty(password) -> {
                        checkCallback.onFailure("密码不能为空!")
                    }
                    password.length < 8 -> {
                        checkCallback.onFailure("密码长度不能小于8")
                    }
                    else -> {
                        checkCallback.onSuccess()
                    }
                }

        /**
         * 检测的应用方法
         */
        fun check(account: String,password: String,checkCallback: CheckCallback){
            checkAccount(account,object : CheckCallback{
                override fun onSuccess() {
                   checkPassword(password,object : CheckCallback{
                       override fun onSuccess() {
                          checkCallback.onSuccess()
                       }

                       override fun onFailure(errMessage: String) {
                           checkCallback.onFailure(errMessage)
                       }
                   })
                }

                override fun onFailure(errMessage: String) {
                    checkCallback.onFailure(errMessage)
                }

            })
        }
    }

    interface CheckCallback{
        fun onSuccess()
        fun onFailure(errMessage:String)
    }
}