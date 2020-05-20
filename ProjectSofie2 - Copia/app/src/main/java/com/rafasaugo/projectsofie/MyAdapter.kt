package com.rafasaugo.projectsofie

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.rafasaugo.projectsofie.model.Data
import kotlinx.android.synthetic.main.list_item.view.*

class MyAdapter (private val dataList: MutableList<Data>) : RecyclerView.Adapter<MyHouder>() {

    private lateinit var context: Context
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHouder {
       context = parent.context
        return  MyHouder(LayoutInflater.from(context).inflate(R.layout.list_item, parent, false))
    }

    override fun getItemCount(): Int = dataList.size

    override fun onBindViewHolder(holder: MyHouder, position: Int) {
        val data = dataList[position]

        val tarefaNameTextView = holder.itemView.tarefa_full_name
        val emailNameTextView = holder.itemView.email_full

        val tarefaName = "${data.title}"
        tarefaNameTextView.text = tarefaName

        val email = "${data.email}"
        emailNameTextView.text = email


        holder.itemView.setOnClickListener {
            Toast.makeText(context, tarefaName, Toast.LENGTH_SHORT).show()
            Toast.makeText(context, email, Toast.LENGTH_SHORT).show()
        }
    }
}