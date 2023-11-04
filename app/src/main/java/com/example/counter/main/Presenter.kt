package com.example.counter.main

import com.example.counter.model.CounterModel
import com.example.counter.view.CounterView

class Presenter {
    var model = CounterModel()
    lateinit var view: CounterView

    fun increment() {
        val xCount = model.count
        model.increment()
        view.updateActualCount(model.count)
        if (xCount == 9) {
            view.showToast()
        }
        if (xCount == 14) {
            view.changeColor()
        }

    }

    fun attachView(view: CounterView) {
        this.view = view
    }
}