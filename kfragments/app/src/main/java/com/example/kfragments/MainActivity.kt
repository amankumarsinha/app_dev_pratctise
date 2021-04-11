package com.example.kfragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val firstFragment = FirstFragment()
        val secondFragment = SecondFragment()

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flfragment,firstFragment)
            commit()
        }

         fragment1.setOnClickListener {
             supportFragmentManager.beginTransaction().apply {
                 replace(R.id.flfragment,firstFragment)
                 addToBackStack(null)
                 commit()
             }
         }

        fragment2.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.flfragment,secondFragment)
                addToBackStack(null)
                commit()
            }
        }
    }
}