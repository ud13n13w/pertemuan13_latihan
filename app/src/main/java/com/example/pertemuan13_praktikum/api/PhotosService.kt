package com.example.pertemuan13_praktikum.api

import io.reactivex.Single
import com.example.pertemuan13_praktikum.model.Photo
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class PhotosService {

    //Website API yang digunakan
    private val BASE_URL = "https://jsonplaceholder.typicode.com/"
    private val api: PhotosApi

    //Setting framework Retrofit untuk membuat Instance API
    init {
        api = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(PhotosApi::class.java)
    }

    //Memuat isi dari API kedalam List photo
    fun getPhotos(): Single<List<Photo>> {
        return api.getPhotos()
    }
}