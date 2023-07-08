package com.maruf.telemedicineapp.ui

import android.text.Editable
import android.text.TextWatcher
import android.view.WindowManager
import android.widget.EditText
import android.widget.LinearLayout
import androidx.lifecycle.LiveData
import androidx.navigation.fragment.findNavController
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.maruf.telemedicineapp.R
import com.maruf.telemedicineapp.adapter.ProductAdapter
import com.maruf.telemedicineapp.base.BaseFragment
import com.maruf.telemedicineapp.data.local.Product
import com.maruf.telemedicineapp.databinding.FragmentProductBinding
import com.maruf.telemedicineapp.db.ProductDatabase
import com.maruf.telemedicineapp.utils.Utils
import com.maruf.telemedicineapp.utils.hideSoftKeyboard
import com.maruf.telemedicineapp.utils.onTextChanged
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.nio.file.Files.size
import javax.inject.Inject


@AndroidEntryPoint
class ProductFragment : BaseFragment<FragmentProductBinding>() {

    @Inject
    lateinit var productAdapter: ProductAdapter

    @Inject
    lateinit var db: ProductDatabase

    private var type: String = ""
    private var hasData = false
    lateinit var data: LiveData<List<Product>>
    override fun getFragmentView(): Int {
        return R.layout.fragment_product
    }

    override fun configUi() {

        binding.productRecyclerView.adapter = productAdapter

        CoroutineScope(Dispatchers.IO).launch {

            db.productDao().insertAll(Utils.productItems)
        }

        data = db.productDao().getProductListAll()

        data.observe(viewLifecycleOwner) {

            productAdapter.submitList(it)
        }


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
            hideSoftKeyboard()
        }
        binding.searchET.onTextChanged {
            if (!it.isNullOrBlank()) {
                when (binding.searchET.hint) {
                    "Search by productTitle", "Search here..." -> {
                        data = db.productDao().getProductListBYTitle(it.trim())
                        data.observe(viewLifecycleOwner) {
                            productAdapter.submitList(it)
                        }
                    }
                    "Search by productSubtitle" -> {
                        data = db.productDao().getProductListBYSubtitle(it.trim())
                        data.observe(viewLifecycleOwner) {
                            productAdapter.submitList(it)
                        }
                    }
                    "Search by createdDate" -> {
                        data = db.productDao().getProductListByCreatedDate(it.trim())
                        data.observe(viewLifecycleOwner) {
                            productAdapter.submitList(it)
                        }
                    }
                    "Search by stock" -> {
                        data = db.productDao().getProductListByStock("1")
                        data.observe(viewLifecycleOwner) {
                            productAdapter.submitList(it)
                        }
                    }
                }

            } else {
                data = db.productDao().getProductListAll()

                data.observe(viewLifecycleOwner) {

                    productAdapter.submitList(it)
                }
            }

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
            binding.searchET.hint = "Search by $type"
            binding.searchET.requestFocus()

            bottomSheetDialog.dismiss()
        }
        bottomSheetDialog.findViewById<LinearLayout>(R.id.productSubtitle)!!.setOnClickListener {

            type = it.tag.toString()
            hasData = false
            binding.searchET.hint = "Search by $type"
            binding.searchET.requestFocus()
            bottomSheetDialog.dismiss()
        }
        bottomSheetDialog.findViewById<LinearLayout>(R.id.createdDate)!!.setOnClickListener {
            type = it.tag.toString()
            hasData = false
            binding.searchET.hint = "Search by $type"
            binding.searchET.requestFocus()
            bottomSheetDialog.dismiss()
        }
        bottomSheetDialog.findViewById<LinearLayout>(R.id.stock)!!.setOnClickListener {
            type = it.tag.toString()
            hasData = false
            binding.searchET.hint = "Search by $type"
            binding.searchET.requestFocus()
            data = db.productDao().getProductListByStock("1")
            data.observe(viewLifecycleOwner) {
                productAdapter.submitList(it)
            }
            bottomSheetDialog.dismiss()
        }
        bottomSheetDialog.show()
    }
}