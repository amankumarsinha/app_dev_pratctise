package com.example.krecylerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var todoList= mutableListOf(
                todo("follow android",false),
                todo("aman android",true),
        todo("kumar android",false),
        todo("sinha android",true),
        todo("rahul android",false),
        todo("ankit android",true),
        todo("abhi android",false),
        todo("nitish android",true)

        )

        val adapter =todoadapter(todoList)
        rvTools.adapter=adapter
        rvTools.layoutManager = LinearLayoutManager(this)

        button.setOnClickListener {
            val title =edTodo.text.toString()
            val todo1 =todo(title,false)
            todoList.add(todo1)
            adapter.notifyItemInserted(todoList.size-1)
        }
    }
}