package com.rafasaugo.projectsofie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.gson.Gson
import com.rafasaugo.projectsofie.http.HttpHelper
import com.rafasaugo.projectsofie.model.Dev
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_tarefas2.*
import org.jetbrains.anko.doAsync
import kotlin.system.exitProcess

class TarefasActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tarefas2)

        val buttonSave = findViewById<Button>(R.id.btn_save)
        val editTextEmail = findViewById<EditText>(R.id.edit_text_email)
        val editTextTarefa = findViewById<EditText>(R.id.edit_text_tarefa)
        val editTextDescription = findViewById<EditText>(R.id.edit_text_description)

        buttonSave.setOnClickListener{
            //criar objeto
            val tarefa = Dev()
            tarefa.email = editTextEmail.text.toString()
            tarefa.title = editTextTarefa.text.toString()
            tarefa.description = editTextDescription.text.toString()

            //covert tarefa para formato json
            val gson = Gson()
            val tarefaJson = gson.toJson(tarefa)

            btn_save.setOnClickListener{

                Toast.makeText(this, "Enviado com sucesso" + btn_save.tag,Toast.LENGTH_LONG).show()
                closeContextMenu()
            }



            doAsync {
                val http = HttpHelper()
                http.post(tarefaJson)
            }

        }

    }
}
