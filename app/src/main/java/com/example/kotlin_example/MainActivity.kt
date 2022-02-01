package com.example.kotlin_example

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private val myData = MyData()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
// подписываем объект myData на изменени жизненого цикла Activity
        lifecycle.addObserver(myData)

        // вывод названия метода откуда происходит запуск
        println(object : Any(){}.javaClass.enclosingMethod?.name)

        myToast("onCreate")
    }

    override fun onStart() {
        super.onStart()
        println(object : Any(){}.javaClass.enclosingMethod?.name)
        myToast("onStart")
    }

    override fun onResume() {
        super.onResume()
        println(object : Any(){}.javaClass.enclosingMethod?.name)
        myToast("onResume")
    }

    override fun onPause() {
        super.onPause()
        println(object : Any(){}.javaClass.enclosingMethod?.name)
        myToast("onPause")
    }

    override fun onStop() {
        super.onStop()
        println(object : Any(){}.javaClass.enclosingMethod?.name)
        myToast("onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        println(object : Any(){}.javaClass.enclosingMethod?.name)
        myToast("onDestroy")
    }

    private fun myToast (method : String){
        Toast.makeText(applicationContext, method, Toast.LENGTH_SHORT).show()
    }
}