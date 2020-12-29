package com.ellen.androidarchitecture.kmvvm.oldmvvm.viewmodel

import androidx.databinding.ObservableField
import com.ellen.androidarchitecture.kmvvm.bean.Student

class StudentViewModel {

    var studentObservable = ObservableField<Student>()

    fun getStudentInfo(): Student {
        val student = Student("Ellen2020","20201314")
        studentObservable.set(student)
        return student
    }

}