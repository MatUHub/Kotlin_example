package com.example.kotlin_example

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputBinding
import android.widget.EditText
import com.example.kotlin_example.databinding.ActivityMainBinding
import java.sql.DatabaseMetaData

class MainActivity : AppCompatActivity() {

   private lateinit var binding: ActivityMainBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }
}