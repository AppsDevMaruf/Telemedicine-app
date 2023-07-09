package com.maruf.telemedicineapp.repo

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.maruf.telemedicineapp.data.local.Product
import com.maruf.telemedicineapp.db.ProductDao
import com.maruf.telemedicineapp.paging.ProductPagingSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class Repository @Inject constructor(private val productDao: ProductDao) {
    val data = Pager(
        PagingConfig(
            pageSize = 20,
            enablePlaceholders = false,
            initialLoadSize = 20
        ),
    ) {
        ProductPagingSource(productDao)
    }.flow

    //search by title

    fun searchByTitleRepo(searchTitle: String): Flow<PagingData<Product>> {
        return Pager(
            config = PagingConfig(pageSize = 20,  enablePlaceholders = false, initialLoadSize = 20),
            pagingSourceFactory = { productDao.searchByTitle(searchTitle) }
        ).flow
    }
    //search by product
    fun searchProductsRepo(
        searchTitle: String?,
        searchSubTitle: String?,
        createdDate: String?,
        isInStock: String?
    ): Flow<PagingData<Product>> {
        return Pager(
            config = PagingConfig(pageSize = 20,  enablePlaceholders = false, initialLoadSize = 20),
            pagingSourceFactory = {
                productDao.searchProducts(
                    searchTitle,
                    searchSubTitle,
                    createdDate,
                    isInStock
                )
            }
        ).flow
    }
    //

    suspend fun insertProductRepo(item: Product) {
        productDao.insert(item)
    }

    suspend fun insertAllProductRepo(item: List<Product>) {
        productDao.insertAll(item)
    }




    suspend fun updateProductRepo(item: Product) {
        productDao.insert(item)

    }



}