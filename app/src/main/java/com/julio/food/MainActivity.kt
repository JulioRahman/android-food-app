package com.julio.food

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var list: ArrayList<Food> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var rvFood = rv_food

        list.addAll(FoodsData.listData)

        rvFood.layoutManager = GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false)
        rvFood.adapter = GridAdapter(list)
    }
}
