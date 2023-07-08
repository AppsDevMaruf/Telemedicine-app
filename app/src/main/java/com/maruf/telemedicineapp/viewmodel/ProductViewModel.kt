package com.maruf.telemedicineapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.maruf.telemedicineapp.data.local.Product
import com.maruf.telemedicineapp.repo.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor(
    private val todoRepo: Repository
) : ViewModel() {
    val productData = todoRepo.data

    fun insertProductVM(product: Product) {
        viewModelScope.launch {
            todoRepo.insertProductRepo(product)
        }

    }

    fun updateProductVM(product: Product) {
        viewModelScope.launch {
            todoRepo.updateProductRepo(product)
        }
    }


}

