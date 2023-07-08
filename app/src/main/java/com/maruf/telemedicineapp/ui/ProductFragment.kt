package com.maruf.telemedicineapp.ui

import android.view.WindowManager
import android.widget.LinearLayout
import androidx.navigation.fragment.findNavController
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.maruf.telemedicineapp.R
import com.maruf.telemedicineapp.adapter.ProductAdapter
import com.maruf.telemedicineapp.base.BaseFragment
import com.maruf.telemedicineapp.databinding.FragmentProductBinding
import com.maruf.telemedicineapp.utils.Utils
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ProductFragment : BaseFragment<FragmentProductBinding>() {

    @Inject
    lateinit var  productAdapter: ProductAdapter


    private var type: String = ""
    private var hasData = false
    override fun getFragmentView(): Int {
        return R.layout.fragment_product
    }

    override fun configUi() {
        productAdapter?.submitList(Utils.productItems)
        binding.productRecyclerView.adapter = productAdapter
    }

    override fun setupNavigation() {
        binding.backButton.setOnClickListener {
            findNavController().popBackStack()
        }
        binding.homeIcon.setOnClickListener {
            findNavController().popBackStack()
        }
        binding.filterBtn.setOnClickListener {
            showBottomSheetFilterType()
        }

    }

    private fun showBottomSheetFilterType() {
        val bottomSheetDialog = BottomSheetDialog(requireContext())
        bottomSheetDialog.setContentView(R.layout.item_by_search)
        bottomSheetDialog.behavior.maxHeight = 2000 // set max height when expanded in PIXEL
        bottomSheetDialog.window!!.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE)
        bottomSheetDialog.findViewById<LinearLayout>(R.id.productTitle)!!.setOnClickListener {
            type = it.tag.toString()
            hasData = false
            bottomSheetDialog.dismiss()
        }
        bottomSheetDialog.findViewById<LinearLayout>(R.id.productSubtitle)!!.setOnClickListener {

            type = it.tag.toString()
            hasData = false
            bottomSheetDialog.dismiss()
        }
        bottomSheetDialog.findViewById<LinearLayout>(R.id.createdDate)!!.setOnClickListener {
            type = it.tag.toString()
            hasData = false
            bottomSheetDialog.dismiss()
        }
        bottomSheetDialog.findViewById<LinearLayout>(R.id.stock)!!.setOnClickListener {
            type = it.tag.toString()
            hasData = false
            bottomSheetDialog.dismiss()
        }
        bottomSheetDialog.show()
    }
}