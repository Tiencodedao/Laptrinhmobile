package com.example.testing

import org.junit.jupiter.api.Assertions.*

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.math.BigInteger

class FactorialCalculatorTest {

    private lateinit var calculator: FactorialCalculator

    @BeforeEach
    fun setup() {
        calculator = FactorialCalculator()
    }

    @Test
    fun factorial_ofZero_returnsOne() {
        val result = calculator.factorial(0)
        assertEquals(BigInteger.ONE, result)
    }

    @Test
    fun factorial_ofFive_returns120() {
        val result = calculator.factorial(5)
        assertEquals(BigInteger.valueOf(120), result)
    }

    @Test
    fun factorial_negativeNumber_throwsException() {
        val exception = assertThrows(IllegalArgumentException::class.java) {
            calculator.factorial(-3)
        }
        assertEquals("n phải >= 0", exception.message)
    }

    @Test
    fun factorial_ofLargeNumber_worksCorrectly() {
        val result = calculator.factorial(20)
        val expected = BigInteger("2432902008176640000")
        assertEquals(expected, result)
    }
}