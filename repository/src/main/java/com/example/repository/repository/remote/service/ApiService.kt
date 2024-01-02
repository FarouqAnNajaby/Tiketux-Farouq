package com.example.repository.repository.remote.service

import com.example.repository.repository.remote.response.ResponseDeparture
import com.example.repository.repository.remote.response.ResponseDestination
import com.example.repository.repository.remote.response.ResponseJadwal
import retrofit2.http.*

interface ApiService {
    @GET("jadwal.json")
    suspend fun getScheduleArmada() : ResponseJadwal

    @GET("jadwal-asal.json")
    suspend fun getScheduleDepartureArmada() : ResponseDeparture

    @GET("jadwal-tujuan.json")
    suspend fun getScheduleDestinationArmada() : ResponseDestination
}