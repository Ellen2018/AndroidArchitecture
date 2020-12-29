package com.ellen.androidarchitecture.kmvvm.oldmvvm

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.ellen.androidarchitecture.R
import com.ellen.androidarchitecture.databinding.ActivityStudentMvvmBinding
import com.ellen.androidarchitecture.kmvvm.oldmvvm.viewmodel.StudentViewModel

/**
 * 传统的 MV-VM 架构搭建
 *
 * 已经淘汰掉这种方式
 */
class StudentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //初始化DataBinding组件
        val dataBinding = DataBindingUtil.setContentView<ActivityStudentMvvmBinding>(this, R.layout.activity_student_mvvm)


        //设置ViewModel
        val studentViewModel = StudentViewModel()
        studentViewModel.getStudentInfo()
        dataBinding.studentViewModel = studentViewModel

        dataBinding.etName.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable?) {
                Log.e("Ellen2020","验证双向绑定:"+ (studentViewModel.studentObservable.get()?.name))
                dataBinding.studentViewModel = studentViewModel
            }
        })
    }

}