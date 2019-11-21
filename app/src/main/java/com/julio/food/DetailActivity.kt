package com.julio.food

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        actionBar?.setDisplayHomeAsUpEnabled(true)

        title = "Detail"
        Picasso.get().load(intent.getStringExtra("PHOTO")).into(iv_image)
        tv_name.text = intent.getStringExtra("NAME")
        tv_detail.text = intent.getStringExtra("DETAIL")
    }
}
