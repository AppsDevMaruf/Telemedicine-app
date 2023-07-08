package com.maruf.telemedicineapp.db

import androidx.room.*
import com.maruf.telemedicineapp.data.local.Product

@Dao
interface ProductDao {
    @Query("SELECT * FROM product_table ORDER BY id ASC LIMIT :limit OFFSET :offset")
    suspend fun getProductList(limit: Int, offset: Int): List<Product>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(product: Product): Long

    @Update
    suspend fun updateProduct(product: Product)
}