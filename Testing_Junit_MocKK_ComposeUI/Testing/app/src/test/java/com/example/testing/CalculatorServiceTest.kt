package com.example.testing

import org.junit.Assert.*
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.Assert.assertEquals
import org.junit.Test

class CalculatorServiceTest {

        private val mockCalculator = mockk<Calculator>()
        private val service = CalculatorService(mockCalculator)

        @Test
        fun `sumAndDouble should return double of addition`() {
            every { mockCalculator.add(2, 3) } returns 5

            val result = service.sumAndDouble(2, 3)

            assertEquals(10, result)
            verify { mockCalculator.add(2, 3) }
        }
    }

