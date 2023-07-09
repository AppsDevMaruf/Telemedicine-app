package com.maruf.telemedicineapp.ui

import android.text.Editable
import android.text.TextWatcher
import android.view.WindowManager
import android.widget.EditText
import android.widget.LinearLayout
import androidx.fragment.app.viewModels
import androidx.lifecycle.LiveData
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.maruf.telemedicineapp.R
import com.maruf.telemedicineapp.adapter.LoaderAdapter
import com.maruf.telemedicineapp.adapter.ProductAdapter
import com.maruf.telemedicineapp.base.BaseFragment
import com.maruf.telemedicineapp.data.local.Product
import com.maruf.telemedicineapp.databinding.FragmentProductBinding
import com.maruf.telemedicineapp.db.ProductDatabase
import com.maruf.telemedicineapp.utils.Utils
import com.maruf.telemedicineapp.utils.hideSoftKeyboard
import com.maruf.telemedicineapp.utils.onTextChanged
import com.maruf.telemedicineapp.viewmodel.ProductViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import java.nio.file.Files.size
import javax.inject.Inject


@AndroidEntryPoint
class ProductFragment : BaseFragment<FragmentProductBinding>() {
    private var searchTitle: String? = ""
    private var searchSubTitle: String? = ""
    var createdDate: String? = ""
    var isInStock: String? = ""

    @Inject
    lateinit var productAdapter: ProductAdapter
    private val viewModel by viewModels<ProductViewModel>()

    private var type: String = ""
    private var hasData = false

    override fun getFragmentView(): Int {
        return R.layout.fragment_product
    }

    override fun configUi() {
        viewModel.insertAllProductVM(Utils.productItems)
        binding.productRecyclerView.adapter = productAdapter.withLoadStateFooter(LoaderAdapter())
        lifecycleScope.launch {
            viewModel.productData.collectLatest {
                productAdapter.submitData(it)
            }
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

                        lifecycleScope.launch {
                            viewModel.searchProductsVM(
                                it.trim(),
                                "",
                                "",
                                ""
                            ).collectLatest { pagingData ->
                                productAdapter.submitData(pagingData)
                            }
                        }


                    }

                    "Search by productSubtitle" -> {
                        lifecycleScope.launch {
                            viewModel.searchProductsVM(
                                "",
                                it.trim(),
                                "",
                                isInStock
                            ).collectLatest { pagingData ->
                                productAdapter.submitData(pagingData)
                            }
                        }
                    }

                    "Search by createdDate" -> {
                        lifecycleScope.launch {
                            viewModel.searchProductsVM(
                                "",
                                "",
                                it.trim(),
                                ""
                            ).collectLatest { pagingData ->
                                productAdapter.submitData(pagingData)
                            }
                        }
                    }

                    "Search by stock" -> {
                        lifecycleScope.launch {
                            viewModel.searchProductsVM(
                                "",
                                "",
                                "",
                                it.trim()
                            ).collectLatest { pagingData ->
                                productAdapter.submitData(pagingData)
                            }
                        }
                    }
                }

            } else {

                lifecycleScope.launch {
                    viewModel.searchProductsVM(
                        "",
                        "",
                        "",
                        ""
                    ).collectLatest { pagingData ->
                        productAdapter.submitData(pagingData)
                    }
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
        bottomSheetDialog.findViewById<LinearLayout>(R.id.productSubtitle)!!
            .setOnClickListener {

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
            lifecycleScope.launch {
                viewModel.searchProductsVM(
                    "",
                    "",
                    "",
                    "1"
                ).collectLatest { pagingData ->
                    productAdapter.submitData(pagingData)
                }
            }
            bottomSheetDialog.dismiss()
        }
        bottomSheetDialog.show()
    }
}
