package com.example.kintentservice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn1.setOnClickListener {
            Intent(this,MyIntentService::class.java).also{
                startService(it)
                text1.text="service runnig"
            }
        }
        btn2.setOnClickListener {
            MyIntentService.stopService()
            text1.text= "service stopr"
        }
    }
}