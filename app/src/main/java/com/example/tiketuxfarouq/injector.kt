package com.example.tiketuxfarouq

import com.example.tiketuxfarouq.activity.detail.DetailViewModel
import com.example.tiketuxfarouq.activity.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { MainViewModel(get()) }
    viewModel { DetailViewModel(get()) }
}