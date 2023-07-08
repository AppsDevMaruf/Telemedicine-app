package com.maruf.telemedicineapp.ui

import androidx.navigation.fragment.findNavController
import com.maruf.telemedicineapp.R
import com.maruf.telemedicineapp.adapter.ProductAdapter
import com.maruf.telemedicineapp.base.BaseFragment
import com.maruf.telemedicineapp.databinding.FragmentProductBinding
import com.maruf.telemedicineapp.utils.Utils
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductFragment : BaseFragment<FragmentProductBinding>() {
    private val productAdapter = ProductAdapter()
    override fun getFragmentView(): Int {
        return R.layout.fragment_product
    }

    override fun configUi() {
        productAdapter.submitList(Utils.productItems)
        binding.productRecyclerView.adapter = productAdapter
    }

    override fun setupNavigation() {
        binding.backButton.setOnClickListener {
            findNavController().popBackStack()
        }
        binding.homeIcon.setOnClickListener {
            findNavController().popBackStack()
        }

    }
}