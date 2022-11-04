package com.example.junit

object FibonacciUtils {

    fun fibonacci(n: Int): Int {

        if (n == 0 || n == 1) {
            return n
        }

        var first = 0
        var second = 1
        var third = 1
        for (i in 2..n) {
            third = first + second
            first = second
            second = third
        }
        return third
    }
}