package com.example.kotlin_example

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputBinding
import android.widget.Button
import android.widget.Toast
import com.example.kotlin_example.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

        // создание binding, имя расширения binding в зависимости от названия класса
   lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //активация binding
        //записать в файле build.gradle(:app)
        //    buildFeatures{
        //        viewBinding true
        //    }
        // setContentView(R.layout.activity_main) удалить при создании binding, заменяется на setContentView(binding.root)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        // вдутие (замещение, т.к. replace) фрагмента в контейнер container_main ( при открытии проекта)
        supportFragmentManager.beginTransaction()
            .replace(R.id.container_main, FragmentOne.newInstance()).commit()
//замещение фрагмента по нажатию кнопки button2
        binding.button2.setOnClickListener{
            supportFragmentManager.beginTransaction().replace(R.id.container_main, FragmentTwo.newInstance()).commit()
            Toast.makeText(this,"Two",Toast.LENGTH_SHORT).show()
        }
        binding.button1.setOnClickListener{
            supportFragmentManager.beginTransaction().replace(R.id.container_main, FragmentOne.newInstance()).commit()
        }
    }

}