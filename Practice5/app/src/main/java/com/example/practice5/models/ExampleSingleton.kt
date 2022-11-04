package com.example.practice5.models

object ExampleSingleton {

    val singleUser: User by lazy {
        User("anu@gmail.com","agh","some.png")
    }
}