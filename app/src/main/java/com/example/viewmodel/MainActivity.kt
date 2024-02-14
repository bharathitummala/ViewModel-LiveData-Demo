package com.example.viewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
//var count = 0
    private lateinit var  viewModel: MainActivityViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProvider(this)[MainActivityViewModel::class.java]
        val countTextView = findViewById<TextView>(R.id.tvCount)
        val countBtn = findViewById<Button>(R.id.btnCount)
       // countTextView.text = viewModel.count.toString()
        viewModel.count.observe(this, Observer {
            countTextView.text =it.toString()
        })
        countBtn.setOnClickListener{
            viewModel.upDateCount()
           // countTextView.text = viewModel.count.toString()

        }
    }
}