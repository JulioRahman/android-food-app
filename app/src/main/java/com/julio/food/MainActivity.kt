package com.julio.food

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var list: ArrayList<Food> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rv_food.setHasFixedSize(true)

        list.addAll(FoodsData.listData)

        rv_food.layoutManager = GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false)
        rv_food.adapter = GridAdapter(list)
    }
}
