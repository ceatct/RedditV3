package com.example.reddit.Retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// за допомогою бібліотеки retrofit зветраємося до json файлу

object RetrofitClient {
    private var retrofit: Retrofit? = null

    fun getClient(baseUrl: String) : Retrofit{
        if(retrofit==null){
            retrofit = Retrofit.Builder().baseUrl(baseUrl).
                    addConverterFactory(GsonConverterFactory.create()).build()
        }
        return retrofit!!
    }
}