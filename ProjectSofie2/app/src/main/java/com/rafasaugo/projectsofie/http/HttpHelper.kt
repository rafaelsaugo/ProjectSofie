package com.rafasaugo.projectsofie.http

import com.androidnetworking.common.RequestBuilder
import okhttp3.MediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody

class HttpHelper {

    fun post (json: String) : String {

        //URL SERVER
        val URL = "https://9g1borgfz0.execute-api.sa-east-1.amazonaws.com/beta/task"

        // Cabeçalho
        val headerHttp = MediaType.parse("application/json; charset=utf-8")

        // Client
        val client = OkHttpClient()

        //Body
        val body = RequestBody.create(headerHttp, json)

        // Requisição POST
        var request = Request.Builder().url(URL).post(body).build()

        //Utilizar o client para fazer a requisição e ter uma resposta
        val response = client.newCall(request).execute()

        return response.body().toString()


    }
}

