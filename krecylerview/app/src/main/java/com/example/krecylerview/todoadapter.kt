package com.example.krecylerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.itemtodo.view.*

class todoadapter(
        var todos: List<todo>
): RecyclerView.Adapter<todoadapter.todoviewholder>() {
    inner class todoviewholder(itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): todoviewholder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.itemtodo,parent,false)
        return todoviewholder(view)


    }

    override fun onBindViewHolder(holder: todoviewholder, position: Int) {
        holder.itemView.apply {
            tvtitle.text=todos[position].title
            cbdone.isChecked=todos[position].ischecked

        }
    }

    override fun getItemCount(): Int {
        return todos.size

    }
}