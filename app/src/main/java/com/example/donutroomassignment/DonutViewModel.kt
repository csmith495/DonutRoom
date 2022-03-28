package com.example.donutroomassignment

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class DonutViewModel(val dao: DonutDao) : ViewModel() {
    var newDonutName = ""
    private val donuts : LiveData<List<Donut>> = dao.getLatest()

    val donutString = Transformations.map(donuts) {
        donuts -> formatDonuts((donuts))
    }

    fun formatDonuts(donuts: List<Donut>): String {

        return donuts.fold("") {
            str, item -> str + '\n' + convertToString(item)
        }
    }

    fun convertToString(donut: Donut): String {
        var str = "Donuts Eaten Today: ${donut.donutAmount}"
        return str
    }

    fun addDonut() {
        viewModelScope.launch {
            val donut = Donut()
            donut.donutAmount = newDonutName
            dao.insert(donut)
        }
    }
}