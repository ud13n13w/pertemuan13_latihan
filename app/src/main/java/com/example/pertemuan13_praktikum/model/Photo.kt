package com.example.pertemuan13_praktikum.model

import com.google.gson.annotations.SerializedName

data class Photo(

    //SerializedName digunakan untuk mengambil sesuai dengan data Gson apa yang ada pada API
    @SerializedName("id")
    val id: Int?,
    @SerializedName("albumId")
    val albumId: Int?,
    @SerializedName("title")
    val title: String?,
    @SerializedName("thumbnailUrl")
    val thumbnail: String?,
    @SerializedName("url")
    val url: String?
)