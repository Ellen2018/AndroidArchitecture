package com.ellen.androidarchitecture.kmvvm.newmvvm.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ellen.androidarchitecture.kmvvm.bean.Student

/**
 * ViewModel+LiveData相结合
 */
class NewStudentViewModel : ViewModel() {

    var mutableLiveData = MutableLiveData<Student>()

    fun getUserInfo(): LiveData<Student> {
        val student = Student("Ellen2020","20201314")
        mutableLiveData.value = student
        return mutableLiveData
    }

}