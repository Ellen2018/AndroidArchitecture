package com.ellen.androidarchitecture.kmvc.mvc2

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.ellen.androidarchitecture.R

/**
 * 仅作为MVC中的View层
 * 它持有Controller层的引用
 */
class Mvc2Activity : AppCompatActivity() {

    private val mvc2Controller = Mvc2Controller()

    lateinit var tvName:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mvc)

        tvName = findViewById(R.id.tv_name)
        tvName.text = mvc2Controller.student.name

        tvName.setOnClickListener {
            mvc2Controller.student.name = "Ellen2020"
        }

    }

}