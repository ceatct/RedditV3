package com.example.reddit

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.reddit.Adapter.Trd_Adapter
import com.example.reddit.Common.Common
import com.example.reddit.Interface.RetrofitService
import com.example.reddit.Item.Treds
import com.example.reddit.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.Callback
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import java.io.IOException
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

class MainActivity : AppCompatActivity() {

    lateinit var mService: RetrofitService
    lateinit var layoutManager: LinearLayoutManager
    lateinit var adapter: Trd_Adapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mService = Common.retrofitService

        recyclerReddit.setHasFixedSize(true)
        layoutManager = LinearLayoutManager(this)
        recyclerReddit.layoutManager = layoutManager

        getTrds()

    }

    private fun getTrds() {
        mService.getTreds().enqueue(object : retrofit2.Callback<MutableList<Treds>>{
            override fun onResponse(
                call: Call<MutableList<Treds>>,
                response: retrofit2.Response<MutableList<Treds>>
            ) {
                adapter = Trd_Adapter(baseContext, response.body() as MutableList<Treds>)
                adapter.notifyDataSetChanged()
                recyclerReddit.adapter = adapter
            }

            override fun onFailure(call: Call<MutableList<Treds>>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }
}

