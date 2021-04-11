package com.example.ksharedpreferences

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sharedPref = getSharedPreferences("mypref", MODE_PRIVATE)
        val editor = sharedPref.edit()
            Button1.setOnClickListener {
                val name =name.text.toString()
                val age =age.text.toString().toInt()
                val adult= check.isChecked

                editor.apply {
                    putString("name" , name)
                    putInt("age",age)
                    putBoolean("isadult",adult)
                    apply()
                }
                Toast.makeText(this,"hello",Toast.LENGTH_SHORT).show()
            }
        Button2.setOnClickListener {
            val iname = sharedPref.getString("name", null)
            val iage =sharedPref.getInt("age",0)
            val iadult= sharedPref.getBoolean("isadult",false)

            name.setText(iname)
            age.setText(iage.toString())
            check.isChecked=iadult
        }
    }
}