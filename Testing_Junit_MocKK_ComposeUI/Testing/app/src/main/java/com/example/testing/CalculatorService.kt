package com.example.testing

class CalculatorService(private val calculator: Calculator) {

    fun sumAndDouble(a: Int, b: Int): Int {
        val sum = calculator.add(a, b)
        return sum * 2
    }
}
