package com.example.androiddevpractice.topics.userinterface.picker

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PickerViewModel : ViewModel() {

    val _hour = MutableLiveData(-10)
    val hour: LiveData<Int> = _hour

    val _minute = MutableLiveData(-10)
    val minute: LiveData<Int> = _minute

}