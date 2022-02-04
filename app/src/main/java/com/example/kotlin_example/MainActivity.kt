package com.example.kotlin_example

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlin_example.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private val adapter = PlantAdapter()

    //создание массива картинок
    private val imageIdList =
        listOf(R.drawable.fl1, R.drawable.fl2, R.drawable.fl3, R.drawable.fl4, R.drawable.fl5)

    private var index = 0

    override fun onCreate(savedInstanceState: Bundle?) {

        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        init()

    }

    private fun init() {
        binding.apply {
            // задание вида таблицы
            //LinearLayoutManager(this@MainActivity) - для создания вертикального списка
            rcView.layoutManager = GridLayoutManager(
                this@MainActivity,
                3
            ) // создание списка в виде таблицы, 3 - кол-во столбцов
            // присваиваем адаптер PlantAdapter() для RecyclerView
            rcView.adapter = adapter

            buttonPlant.setOnClickListener {
                if(index > 4) index = 0
                val plant = Plant(imageIdList[index], " Plant $index")
                adapter.addPlant(plant)
                index++
            }
        }
    }
}