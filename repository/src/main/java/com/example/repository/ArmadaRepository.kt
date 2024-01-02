package com.example.repository

import com.example.repository.repository.remote.Resource
import com.example.repository.repository.remote.service.ApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class ArmadaRepository(
    private val service: ApiService,
) {
    fun getScheduleArmada() = flow {
        emit(Resource.Loading)
        try {
            val response = service.getScheduleArmada().tiketux?.result
            emit(Resource.Success(response))
        } catch (e: Exception) {
            emit(Resource.Error(e.message))
        }
    }.flowOn(Dispatchers.IO)

    fun getDepartureArmada() = flow {
        emit(Resource.Loading)
        try {
            val response = service.getScheduleDepartureArmada().tiketux?.result
            emit(Resource.Success(response))
        } catch (e: Exception) {
            emit(Resource.Error(e.message))
        }
    }.flowOn(Dispatchers.IO)

    fun getDestinationArmada() = flow {
        emit(Resource.Loading)
        try {
            val response = service.getScheduleDestinationArmada().tiketuxDestination?.result
            emit(Resource.Success(response))
        } catch (e: Exception) {
            emit(Resource.Error(e.message))
        }
    }.flowOn(Dispatchers.IO)
}