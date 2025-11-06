package com.example.testing
import java.math.BigInteger

class FactorialCalculator {
        fun factorial(n: Int): BigInteger {
            require(n >= 0) { "n phải >= 0" }
            var result = BigInteger.ONE
            for (i in 1..n) {
                result = result.multiply(BigInteger.valueOf(i.toLong()))
            }
            return result
        }
    }

