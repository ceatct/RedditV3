package com.example.reddit.Common

import com.example.reddit.Interface.RetrofitService
import com.example.reddit.Retrofit.RetrofitClient

// У цьому об'єкті ми вказуємо основне посилання, яке буде доповнюватись для отримання json даних

object Common {
    private val BASE_URL = "https://www.reddit.com/"

    val retrofitService : RetrofitService
    get() = RetrofitClient.getClient(BASE_URL).create(RetrofitService::class.java)
}