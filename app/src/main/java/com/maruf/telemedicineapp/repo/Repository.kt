package com.maruf.telemedicineapp.repo

import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.maruf.telemedicineapp.data.local.Product
import com.maruf.telemedicineapp.db.ProductDao
import com.maruf.telemedicineapp.paging.ProductPagingSource
import javax.inject.Inject

class Repository @Inject constructor(private val productDao: ProductDao){
    val data = Pager(
        PagingConfig(
            pageSize = 20,
            enablePlaceholders = false,
            initialLoadSize = 20
        ),
    ) {
        ProductPagingSource(productDao)
    }.flow

    suspend fun insertProductRepo(item: Product){
        productDao.insert(item)

    }
    suspend fun updateProductRepo(item: Product){
        productDao.insert(item)

    }

}