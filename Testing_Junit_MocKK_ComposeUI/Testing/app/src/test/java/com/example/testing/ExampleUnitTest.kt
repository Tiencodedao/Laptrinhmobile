package com.example.testing

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    // Test cơ bản
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }
    // Test kiểm tra logic riêng
    @Test
    fun multiply_isCorrect() {
        val result = 3 * 3
        assertEquals(9, result)
    }
}

