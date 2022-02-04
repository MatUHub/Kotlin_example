package com.example.kotlin_example

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin_example.databinding.PlantItemBinding

//Adapter заполняет каточки с данными в RecyclerView
//PlantHolder наполняет каждую карточку данными
class PlantAdapter : RecyclerView.Adapter<PlantAdapter.PlantHolder>() {

    private val plantList = ArrayList<Plant>()

    //если объект создан, он не пересоздается, а заного используется
    //функция по соданию View (ндувает шаблон)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlantHolder {
        // вдувается View с макетом plant_item в RecycleView
        val view = LayoutInflater.from(parent.context).inflate(R.layout.plant_item, parent, false)
        return PlantHolder(view)
    }

    //заполнение созданного элемента View (выполняется после onCreateViewHolder)
    override fun onBindViewHolder(holder: PlantHolder, position: Int) {
        holder.bind(plantList[position])
    }

    //данная функция определяет кол-во раз сколько нужно вызвать функцию onCreateViewHolder (getItemCount передает данные в переменную position)
    override fun getItemCount(): Int {
        return plantList.size
    }

    //содержит ссылки на заполняемые View
    class PlantHolder(item: View) : RecyclerView.ViewHolder(item) {

        private val binding = PlantItemBinding.bind(item)

        // добавили = with(binding) что бы не писать binding в каждой строчке
        fun bind(plant: Plant) = with(binding) {
            imView.setImageResource(plant.imageId)
            titleTV.text = plant.title
        }
    }

    //добавление объектов Plant в список
    fun addPlant(plant: Plant) {
        plantList.add(plant)
        //контролирует изменение данных, при изменении происходит обновление
        notifyDataSetChanged()
    }
}