package com.example.pertemuan13_praktikum.api

import io.reactivex.Single
import com.example.pertemuan13_praktikum.model.Photo
import retrofit2.http.GET

interface PhotosApi {

    //Digunakan untuk mengambil API dari website
    @GET("photos")

    //Digunakan untuk memuat Photo kedalam List
    fun getPhotos(): Single<List<Photo>>
}