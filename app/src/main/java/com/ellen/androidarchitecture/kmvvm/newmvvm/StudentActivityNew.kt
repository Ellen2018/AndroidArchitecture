package com.ellen.androidarchitecture.kmvvm.newmvvm

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.ellen.androidarchitecture.R
import com.ellen.androidarchitecture.databinding.ActivityNewStudentMvvmBinding
import com.ellen.androidarchitecture.kmvvm.newmvvm.viewmodel.NewStudentViewModel

/**
 * 新的Jet-pack模式的MV-VM架构
 */
class StudentActivityNew : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = DataBindingUtil.setContentView<ActivityNewStudentMvvmBinding>(this, R.layout.activity_new_student_mvvm)
        val viewModelProvider = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())
        val newStudentViewModel = viewModelProvider.get(NewStudentViewModel::class.java)

        //获取LiveData进行变化监听
        newStudentViewModel.getUserInfo().observe(this, {
            binding.student = it
        })

        binding.etName.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable?) {
                newStudentViewModel.mutableLiveData.value = binding.student
            }
        })
    }

}