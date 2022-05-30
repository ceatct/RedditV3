package com.example.reddit.Interface

import com.example.reddit.Item.Treds
import retrofit2.Call
import retrofit2.http.GET

// цей інтерфейс вказує що необхідно доповнити до Common, щоб отримати дані

interface RetrofitService {
    @GET("top")
    fun getTreds(): Call<MutableList<Treds>>
}