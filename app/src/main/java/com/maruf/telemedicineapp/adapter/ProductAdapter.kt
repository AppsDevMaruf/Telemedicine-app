package com.maruf.telemedicineapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import coil.load
import com.maruf.telemedicineapp.data.local.Product
import com.maruf.telemedicineapp.databinding.ItemProductBinding
import javax.inject.Inject

class ProductAdapter @Inject constructor() : ListAdapter<Product, ProductAdapter.ProductViewHolder>(Comparator) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val layOutBinding =
            ItemProductBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductViewHolder(layOutBinding)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        getItem(position)?.let {
            holder.binding.productName.text = it.productTitle
            holder.binding.productGenerics.text = it.productSubtitle
            holder.binding.productDate.text = it.createdDate
            holder.binding.productImg.load(it.productImage)

        }

    }
    inner class ProductViewHolder(val binding: ItemProductBinding) : ViewHolder(binding.root) {
    }

    companion object {
        private val Comparator =
            object : DiffUtil.ItemCallback<Product>() {
                override fun areItemsTheSame(
                    oldItem: Product,
                    newItem: Product
                ): Boolean {
                    return oldItem.id == newItem.id
                }

                override fun areContentsTheSame(
                    oldItem: Product,
                    newItem: Product
                ): Boolean {
                    return oldItem == newItem
                }

            }

    }
}