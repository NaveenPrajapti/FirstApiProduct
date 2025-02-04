package com.example.apiadapter

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler
import com.example.apiadapter.Interface.ApiInterface
import com.example.apiadapter.adapter.ProductAdapter
import com.example.apiadapter.api.MyData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class MainActivity : AppCompatActivity() {
    lateinit var recyclerview: RecyclerView
    lateinit var productAdapter: ProductAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        recyclerview=findViewById(R.id.recyclerView)


       val  retrofitBuilder=Retrofit.Builder()
           .baseUrl("https://dummyjson.com/")
           .addConverterFactory(GsonConverterFactory.create())
           .build()
           .create(ApiInterface::class.java)

        val retrofitData=retrofitBuilder.getProductData()

        retrofitData.enqueue(object : Callback<MyData?> {
            override fun onResponse(call: Call<MyData?>, response: Response<MyData?>) {

             var responseBody=response.body()
                val producList =responseBody?.products!!
                productAdapter=ProductAdapter(this@MainActivity,producList)

                recyclerview.adapter=productAdapter
                recyclerview.layoutManager=LinearLayoutManager(this@MainActivity)

            }

            override fun onFailure(call: Call<MyData?>, t: Throwable) {
                Log.d("MyActivity","Fail your Api"+t.message)
            }
        })


    }
}