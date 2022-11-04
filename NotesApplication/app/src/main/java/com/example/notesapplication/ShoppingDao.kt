package com.example.notesapplication

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ShoppingDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(shoppingItem: ShoppingItem)

    @Delete
    suspend fun delete(shoppingItem: ShoppingItem)

    @Query("Select * from shopping_item order by id asc")
    fun getAllShoppingItem(): LiveData<List<ShoppingItem>>

    @Query("select sum( price * amount ) from shopping_item")
    fun getTotalPrice(): LiveData<Float>

}