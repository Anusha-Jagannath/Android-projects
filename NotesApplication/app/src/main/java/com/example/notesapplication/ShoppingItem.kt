package com.example.notesapplication

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "shopping_item")
data class ShoppingItem(
    val imageUrl: String,
    val price: Float,
    val amount: Float,
    val name: String,
    @PrimaryKey(autoGenerate = true)
    val id: Int
)