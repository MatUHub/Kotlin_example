package com.example.kotlin_example

import android.app.Application
import android.os.CountDownTimer
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

// для получения контекста используется имплементация AndroidViewModel
// нежелательно использовать context(application) в ViewModel
class MainViewModel(application: Application): AndroidViewModel(application) {

    val liveData = MutableLiveData<String>()

//блок кода запускается при создании экземпляра класса
    init {
        startTimer()
    Toast.makeText(getApplication(),"VM Created",Toast.LENGTH_SHORT).show()
    }

    fun startTimer(){
        //создали счетчик от 20 до 1
        object : CountDownTimer(20000, 1000) {
            override fun onTick(p0: Long) {
               liveData.value = (p0 / 1000).toString()
            }
            override fun onFinish() {
                Toast.makeText(getApplication(), " Finish ", Toast.LENGTH_SHORT).show()
            }
        }.start()
    }
//функция onCleared вызывается при закрытии приложения
    override fun onCleared() {
        super.onCleared()
        Toast.makeText(getApplication(),"VM Cleared",Toast.LENGTH_SHORT).show()
    }
}