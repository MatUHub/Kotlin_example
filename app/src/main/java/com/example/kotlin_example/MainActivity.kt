package com.example.kotlin_example

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    lateinit var textViewTimer: TextView

    lateinit var mViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Toast.makeText(this, " Activity created", Toast.LENGTH_SHORT).show()

        textViewTimer = findViewById(R.id.textViewTimer)

        //для работы ViewModelProvider необходимо прописать в build.gradle(app) следующие строки

        //implementation "androidx.lifecycle:lifecycle-extensions:2.2.0"
        //implementation "androidx.lifecycle:lifecycle-viewmodel-ktx:2.2.0"

// привязываем ViewModel к жизненому циклу MainActivity, ViewModel создается при промощи ViewModelProvider
        // при пересоздании MainActivity (например при повороте экрана) ViewModel не пересоздается
        mViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
    }

    override fun onStart() {
        super.onStart()
        //подписываем на изменения textViewTimer при изменении liveData
        mViewModel.liveData.observe(this, Observer {
            textViewTimer.text = it
        })

    }



}