package com.rafasaugo.projectsofie

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.OrientationHelper
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.ParsedRequestListener
import com.rafasaugo.projectsofie.model.Data
import com.rafasaugo.projectsofie.model.Reqres
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val dataList: MutableList<Data> = mutableListOf()
    private lateinit var myAdapter: MyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnAdd = findViewById<Button>(R.id.btn_add)

        btnAdd.setOnClickListener {
            val telaCadastro = Intent (this, TarefasActivity::class.java)
            startActivity(telaCadastro)
        }

        //SETUP ADAPTER
        myAdapter = MyAdapter(dataList)

        //SETUP RECYCLEVIEW
        my_recycler_view.layoutManager = LinearLayoutManager (this)
        my_recycler_view.addItemDecoration(DividerItemDecoration (this, OrientationHelper.VERTICAL))
        my_recycler_view.adapter = myAdapter


        AndroidNetworking.initialize(this)

        AndroidNetworking.get("https://9g1borgfz0.execute-api.sa-east-1.amazonaws.com/beta/task")
            .build()
            .getAsObject(Reqres::class.java, object : ParsedRequestListener<Reqres> {
                override fun onResponse(response: Reqres) {
                    dataList.addAll(response.data)
                    myAdapter.notifyDataSetChanged()

                }

                override fun onError(anError: ANError?) {
                }
            })
    }
}
