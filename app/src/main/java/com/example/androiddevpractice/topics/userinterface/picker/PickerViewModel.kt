package com.example.androiddevpractice.topics.userinterface.picker

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PickerViewModel : ViewModel() {

    val _hour = MutableLiveData(-10)
    val hour: LiveData<Int> = _hour

    val _minute = MutableLiveData(-10)
    val minute: LiveData<Int> = _minute

    val _day = MutableLiveData(-28)
    val day: LiveData<Int> = _day

    val _month = MutableLiveData(-12)
    val month: LiveData<Int> = _month

    val _year = MutableLiveData(-2020)
    val year: LiveData<Int> = _year

}