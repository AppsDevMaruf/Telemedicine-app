package com.maruf.telemedicineapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import coil.load
import com.maruf.telemedicineapp.data.model.ProductModel
import com.maruf.telemedicineapp.databinding.ItemProductBinding

class ProductAdapter : ListAdapter<ProductModel, ProductAdapter.ProductViewHolder>(Comparator) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val layOutBinding =
            ItemProductBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductViewHolder(layOutBinding)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        getItem(position)?.let {
            holder.binding.productName.text = it.productName
            holder.binding.productGroup.text = it.productGroup
            holder.binding.productDate.text = it.productDate
            holder.binding.productImg.load(it.productImg)
        }

    }
    inner class ProductViewHolder(val binding: ItemProductBinding) : ViewHolder(binding.root) {
    }

    companion object {
        private val Comparator =
            object : DiffUtil.ItemCallback<ProductModel>() {
                override fun areItemsTheSame(
                    oldItem: ProductModel,
                    newItem: ProductModel
                ): Boolean {
                    return oldItem.id == newItem.id
                }

                override fun areContentsTheSame(
                    oldItem: ProductModel,
                    newItem: ProductModel
                ): Boolean {
                    return oldItem == newItem
                }

            }

    }
}