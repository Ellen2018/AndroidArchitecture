package com.ellen.androidarchitecture.kmvc.mvc1

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.ellen.androidarchitecture.R

/**
 * 作为MVC的View层
 * 也可以作为Controller层
 *
 * 注意:也可以将控制层Controller进行剥离
 * 详情查看mvc2包下
 */
class MvcActivity : AppCompatActivity() {

    lateinit var tvName:TextView

    private val student = Student("Ellen","20201314")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mvc)
        tvName = findViewById(R.id.tv_name)

        tvName.text = student.name;

        tvName.setOnClickListener { student.name = "Ellen2020" }
    }

}