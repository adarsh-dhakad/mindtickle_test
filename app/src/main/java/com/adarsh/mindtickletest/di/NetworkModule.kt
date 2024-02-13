package com.adarsh.mindtickletest.di

import com.adarsh.mindtickletest.Constants
import com.adarsh.mindtickletest.Constants.BASE_URL
import com.adarsh.mindtickletest.ui.viewmodel.DashBoardViewModel
import com.adarsh.mindtickletest.network.ApiService
import com.adarsh.mindtickletest.repository.DashBoardRepo
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val appModule = module {

    val gson = GsonBuilder().setLenient().create()
    single {
        Retrofit.Builder().baseUrl(
            Constants.BASE_URL
        ).addConverterFactory(GsonConverterFactory.create(gson))
            .client(get()).build()
    }

    single {
        val okHttpClient = OkHttpClient.Builder()
        okHttpClient

    }

    single {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(get())
            .build()
    }

    single { get<Retrofit>().create(ApiService::class.java) }

    single<DashBoardRepo> { DashBoardRepo(get()) }

    viewModel { DashBoardViewModel(get()) }

}