package com.example.iceandfireapi.ui.fav

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FavViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is favorite Fragment"
    }
    private val _button = MutableLiveData<String>().apply {
        value = "Del"
    }
    val button: LiveData<String> = _button
    val text: LiveData<String> = _text
}