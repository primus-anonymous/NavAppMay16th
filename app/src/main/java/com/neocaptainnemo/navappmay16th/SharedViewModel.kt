package com.neocaptainnemo.navappmay16th

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel : ViewModel() {

    private val _enteredValue = MutableLiveData("")
    val enteredValue: LiveData<String> = _enteredValue

    fun publish(text: String) {
        _enteredValue.value = text
    }
}