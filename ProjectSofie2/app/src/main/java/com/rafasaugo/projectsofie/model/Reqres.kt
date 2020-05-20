package com.rafasaugo.projectsofie.model


import com.google.gson.annotations.SerializedName

data class Reqres(
    @SerializedName("data")
    val `data`: List<Data>
)