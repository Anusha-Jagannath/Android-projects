package com.example.notesapplication

import androidx.room.Database

@Database(entities = [ShoppingItem::class], version = 1)
abstract class ShoppingDatabase {
    abstract fun shoppingDao(): ShoppingDao
}