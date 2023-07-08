package com.maruf.telemedicineapp.ui

import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.core.view.get
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
import com.maruf.telemedicineapp.R
import com.maruf.telemedicineapp.adapter.SliderAdapter
import com.maruf.telemedicineapp.base.BaseFragment
import com.maruf.telemedicineapp.databinding.FragmentHomeBinding
import com.maruf.telemedicineapp.utils.Utils
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>() {
    private val sliderAdapter = SliderAdapter()
    override fun getFragmentView(): Int {
        return R.layout.fragment_home
    }

    override fun configUi() {

        sliderAdapter.submitList(Utils.sliderItems)
        setupIndicators()
        setCurrentIndicator(0)
        binding.sliderContainer.registerOnPageChangeCallback(object : OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                setCurrentIndicator(position)
            }

        })
        binding.sliderContainer.adapter = sliderAdapter

    }

    override fun setupNavigation() {
        binding.contentProductBrief.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_productFragment)
        }
    }


    private fun setupIndicators() {
        val indicators = arrayOfNulls<ImageView>(sliderAdapter.itemCount)
        val layoutParams: LinearLayout.LayoutParams =
            LinearLayout.LayoutParams(WRAP_CONTENT,WRAP_CONTENT)
        layoutParams.setMargins(8,0,8,0)
        for (i in indicators.indices){
            indicators[i] = ImageView(requireActivity())
            indicators[i].apply {
                this?.setImageDrawable(
                    ContextCompat.getDrawable(requireActivity(), R.drawable.indicator_inactive)
                )
                this?.layoutParams = layoutParams
            }
            binding.indicatorsContainer.addView(indicators[i])
        }


    }

    private fun setCurrentIndicator(index:Int) {
        val  childCount = binding.indicatorsContainer.childCount
        for (i in 0 until childCount){
            val imageView = binding.indicatorsContainer[i] as ImageView
            if (i == index) {
                imageView.setImageDrawable(ContextCompat.getDrawable(requireActivity(),
                    R.drawable.indicator_active
                ))
            }else{
                imageView.setImageDrawable(ContextCompat.getDrawable(requireActivity(),
                    R.drawable.indicator_inactive
                ))
            }
        }

    }

}