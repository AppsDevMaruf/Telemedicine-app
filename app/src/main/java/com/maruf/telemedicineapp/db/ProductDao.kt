package com.maruf.telemedicineapp.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.maruf.telemedicineapp.data.local.Product

@Dao
interface ProductDao {
    @Query("SELECT * FROM product_table ORDER BY id ASC LIMIT :limit OFFSET :offset")
    suspend fun getProductList(limit: Int, offset: Int): List<Product>
    @Query("SELECT * FROM product_table ORDER BY id ASC ")
    fun getProductListAll(): LiveData<List<Product>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(product: Product)
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(product: List<Product>)

    @Update
    suspend fun updateProduct(product: Product)
    @Query("SELECT * FROM product_table WHERE productTitle LIKE :search")
    fun getProductListBYTitle(search: String?): LiveData<List<Product>>

    @Query("SELECT * FROM product_table WHERE productSubtitle LIKE :search")
    fun getProductListBYSubtitle(search: String?): LiveData<List<Product>>
    @Query("SELECT * FROM product_table WHERE createdDate LIKE :search")
    fun getProductListByCreatedDate(search: String?): LiveData<List<Product>>
    @Query("SELECT * FROM product_table WHERE stock = 1 LIKE :search")
    fun getProductListByStock(search: String?): LiveData<List<Product>>

}