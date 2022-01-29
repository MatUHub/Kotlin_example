package com.example.kotlin_example

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment

import com.example.kotlin_example.databinding.FragmentTwoBinding

class FragmentTwo : Fragment() {

    // создание ссылки на переменную _binding, тип по названию класса (FragmentTwo) + Binding
   private var _binding: FragmentTwoBinding? = null

    // способ уничтожения binding при ликвидации activity (что бы не копились в фоновых процессах)
    //  в функции onDestroy() занулить _binding
    private val binding: FragmentTwoBinding
        get() {
            return _binding!!
        }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        // активация binding в проекте включая return binding.root ( расположен ниже )
        _binding = FragmentTwoBinding.inflate(inflater, container,false)

        //чтение данных из SharedPreferences
        binding.switch1.isChecked = requireActivity()
            .getSharedPreferences(Settings.SHEARED_PREFERENCE, Context.MODE_PRIVATE)
            .getBoolean(Settings.SETTING_CHOICE, Settings.setting_switch_1)

        // создаем слушатель кнопки buttonSave
        binding.buttonSave.setOnClickListener() {

            //записываем данные в переменную setting_switch_1
            Settings.setting_switch_1 = binding.switch1.isChecked

            //опеределяем файл записи данных SharedPreferences
            val sharedPref = requireActivity().getSharedPreferences(
                // наименование файла сохранения данных
                Settings.SHEARED_PREFERENCE,
                // мод для чтения файла только данного приложения
                Context.MODE_PRIVATE
            )

            //создаем эдитор
            val editor = sharedPref.edit()

            //записываем в данные в переменную setting_switch_1, по ключу SETTING_CHOICE
            editor.putBoolean(Settings.SETTING_CHOICE, Settings.setting_switch_1)

            //активируем запись
            editor.apply()

            Toast.makeText(activity, "save", Toast.LENGTH_SHORT).show()
        }
        // возвращение binding корневого
        return binding.root

    }

    //зануление binding при уничтожении activity
    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    //фабричный метод создания фрагмента
    companion object {
        @JvmStatic
        fun newInstance() = FragmentTwo()
    }
}