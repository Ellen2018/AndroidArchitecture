package com.ellen.androidarchitecture.kmvp.utils

import com.tencent.mmkv.MMKV


class MMKVUtils(name: String) {
    private var mmkv: MMKV

    fun save(key: String, value: Any) {
        if (value is String) {
            mmkv.encode(key, value as String?)
        } else if (value is Int) {
            mmkv.encode(key, (value as Int?)!!)
        } else if (value is Boolean) {
            mmkv.encode(key, (value as Boolean?)!!)
        } else if (value is Float) {
            mmkv.encode(key, (value as Float?)!!)
        } else if (value is Long) {
            mmkv.encode(key, (value as Long?)!!)
        } else {
            mmkv.encode(key, value as String?)
        }
    }

    fun <T> getValue(key: String, defaultValue: T): T {
        var value: Any?
        if (defaultValue is String) {
            value = mmkv.decodeString(key)
            if (value == null) value = defaultValue
        } else if (defaultValue is Int) {
            value = mmkv.getInt(key, (defaultValue as Int))
        } else if (defaultValue is Boolean) {
            value = mmkv.getBoolean(key, (defaultValue as Boolean))
        } else if (defaultValue is Float) {
            value = mmkv.getFloat(key, (defaultValue as Float))
        } else if (defaultValue is Long) {
            value = mmkv.getLong(key, (defaultValue as Long))
        } else {
            value = mmkv.getString(key, defaultValue as String)
        }
        return value as T
    }

    fun deleteKey(key: String?) {
        mmkv.removeValueForKey(key)
    }

    fun safeSave(encryptionString: String, key: String, value: Any) {
        save(encryptionString + key, value)
    }

    fun <T> safeGetValue(encryptionString: String, key: String, defaultValue: T): T {
        return getValue(encryptionString + key, defaultValue)
    }

    init {
        mmkv = MMKV.mmkvWithID(name)!!
    }
}