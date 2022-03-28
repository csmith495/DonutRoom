package com.example.donutroomassignment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException

class DonutViewModelFactory(private val dao: DonutDao)
    :ViewModelProvider.Factory{

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(DonutViewModel::class.java))
            return DonutViewModel(dao) as T
        throw IllegalArgumentException("Unknown ViewModel")
    }
}