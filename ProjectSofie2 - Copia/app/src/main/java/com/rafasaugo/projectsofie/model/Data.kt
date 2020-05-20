package com.rafasaugo.projectsofie.model


import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("description")
    val description: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("_id")
    val id: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("when")
    val whenX: String
)