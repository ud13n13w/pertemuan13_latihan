package com.example.pertemuan13_praktikum.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pertemuan13_praktikum.api.PhotosService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import com.example.pertemuan13_praktikum.model.Photo

class ListViewModel : ViewModel() {

    //Inisiasi PhotoService
    private val photosService = PhotosService()
    private val disposable = CompositeDisposable()
    val photos = MutableLiveData<List<Photo>>()

    fun fetchData() {
        disposable.add(
            photosService.getPhotos()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(
                    object : DisposableSingleObserver<List<Photo>>() {

                        override fun onSuccess(value: List<Photo>?) {
                            photos.value = value
                        }

                        override fun onError(e: Throwable?) {
                            Log.e("ERRORFETCHDATA", "error$e")
                        }
                    })
        )
    }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }
}