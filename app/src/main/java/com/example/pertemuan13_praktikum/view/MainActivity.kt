package com.example.pertemuan13_praktikum.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pertemuan13_praktikum.R
import kotlinx.android.synthetic.main.activity_main.*
import com.example.pertemuan13_praktikum.viewmodel.ListViewModel

class MainActivity : AppCompatActivity() {

    //Inisiasi ViewModel
    lateinit var viewModel: ListViewModel

    //Inisiasi Adapter
    private val photoListAdapter = PhotoListAdapter(arrayListOf())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Setting Viewmodel
        viewModel = ViewModelProviders.of(this).get(ListViewModel::class.java)
        viewModel.fetchData()

        //Setting Adapter
        rv_list.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = photoListAdapter
        }
        observeViewModel()
    }

    //Digunakan untuk memasukkan data dari viewmodel kedalam adapter agar tampil pada Layout UI
    fun observeViewModel() {
        viewModel.photos.observe(this, Observer { photos ->
            photos?.let {
                photoListAdapter.updatePhotos(it)
            }
        })
    }
}