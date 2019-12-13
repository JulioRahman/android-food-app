package com.julio.food.activity

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.julio.food.R
import com.julio.food.adapter.GridAdapter
import com.julio.food.model.Categories
import com.julio.food.model.Food
import com.julio.food.network.DataRepository
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private var list: ArrayList<Food> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val apiService = DataRepository.create()
        apiService.getCategory().enqueue(object : Callback<Categories> {

            override fun onResponse(call: Call<Categories>, response: Response<Categories>) {
                if (response.isSuccessful) {
                    val data = response.body()
                    if (data != null) {
                        initList(data.categories)
                    } else {
                        Toast.makeText(applicationContext, "Response body null", Toast.LENGTH_SHORT)
                            .show()
                    }
                }
            }

            override fun onFailure(call: Call<Categories>, t: Throwable) {
                Log.d("Eudeka!", "onFailure: ${t.message}")
            }
        })
    }

    fun initList(data: List<Food>) {
        rv_food.setHasFixedSize(true)
        list.addAll(data)
        rv_food.layoutManager = GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false)
        rv_food.adapter = GridAdapter(list)
    }
}
