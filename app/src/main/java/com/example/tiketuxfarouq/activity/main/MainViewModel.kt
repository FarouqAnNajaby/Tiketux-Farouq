package com.example.tiketuxfarouq.activity.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.repository.ArmadaRepository

class MainViewModel (
        private val armadaRepository: ArmadaRepository,
) : ViewModel(){

        fun getArmada() = armadaRepository.getScheduleArmada().asLiveData()
}