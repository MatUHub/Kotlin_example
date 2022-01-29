package com.example.kotlin_example

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment


// Расширили класс с помощью Fragment()

class FragmentOne : Fragment() {

    // Перепреоделили метод onCreateView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // создали inflater (вдуватель) для установки макета fragment_one, container - место куда будет вдут данный фрагмент
        return inflater.inflate(R.layout.fragment_one, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    // фабричный метод
    companion object {
        @JvmStatic
        fun newInstance() = FragmentOne()
    }
}