package com.example.kotlin_example

import android.app.Activity
import android.content.Context
import android.widget.Toast
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

//имплементируем интерфейс LifecycleObserver для того что бы MyData могла подписаться на жизненный цикл активити (MainActivity в данном случае)
class MyData : LifecycleObserver {

    //аннотация для активации действия при определенном событии жизненного цикла
    //функция полученя данных
    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun getData() {
        print("get Data")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    //функция отправления данных
    fun setData() {
        print("set Data")
    }

}