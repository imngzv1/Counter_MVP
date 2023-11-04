package com.example.counter.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.counter.databinding.ActivityMainBinding
import com.example.counter.view.CounterView

class MainActivity : AppCompatActivity(), CounterView {
    lateinit var binding: ActivityMainBinding
    var presenter = Presenter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initClickers()
        presenter.attachView(this)
    }

    private fun initClickers() {
        binding.incrementBtn.setOnClickListener {
            presenter.increment()
            presenter.attachView(this)
        }
    }

    override fun updateActualCount(count: Int) {
        binding.countTv.text = count.toString()
    }
    override fun showToast() {
        Toast.makeText(applicationContext, "Поздравляем!", Toast.LENGTH_SHORT).show()
    }

    override fun changeColor() {
        binding.countTv.setTextColor(ContextCompat.getColor(this, android.R.color.holo_green_dark))
    }
}