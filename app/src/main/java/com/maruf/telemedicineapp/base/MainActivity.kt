package com.maruf.telemedicineapp.base

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.maruf.telemedicineapp.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}