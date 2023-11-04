package com.example.counter.view

interface CounterView {
    fun updateActualCount(count:Int)
    fun showToast()
    fun changeColor()
}