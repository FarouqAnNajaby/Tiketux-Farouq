package com.example.tiketuxfarouq.activity.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.repository.ArmadaRepository

class DetailViewModel (
        private val armadaRepository: ArmadaRepository,
) : ViewModel(){

        fun getDestination() = armadaRepository.getDestinationArmada().asLiveData()
        fun getDeparture() = armadaRepository.getDepartureArmada().asLiveData()
}