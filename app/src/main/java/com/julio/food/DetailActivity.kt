package com.julio.food

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        title = "Detail"
        Picasso.get().load(intent.getStringExtra("PHOTO")).into(iv_image)
        tv_name.text = intent.getStringExtra("NAME")
        tv_detail.text = intent.getStringExtra("DETAIL")
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
