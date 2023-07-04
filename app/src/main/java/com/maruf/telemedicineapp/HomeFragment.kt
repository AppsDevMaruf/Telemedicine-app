package com.maruf.telemedicineapp

import android.os.Bundle
import android.os.StrictMode
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.core.view.get
import androidx.viewpager2.widget.ViewPager2
import androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
import com.maruf.telemedicineapp.adapter.SliderAdapter
import com.maruf.telemedicineapp.base.BaseFragment
import com.maruf.telemedicineapp.data.local.SliderModel
import com.maruf.telemedicineapp.databinding.FragmentHomeBinding

class HomeFragment : BaseFragment<FragmentHomeBinding>() {
    private val sliderAdapter = SliderAdapter()
    override fun getFragmentView(): Int {
        return R.layout.fragment_home
    }

    override fun configUi() {
        val item = listOf(
            SliderModel(
                id=1,
                title = "Welcome To Dhaka",
                slideImg = "https://images.macrumors.com/t/3SwpDI7nrMQeeIro9X7SbILE4_I=/1600x0/article-new/2021/03/Facebook-Feature.jpg"
            ),
            SliderModel(
                id=2,
                title = "Welcome To Cumilla",
                slideImg = "https://images.unsplash.com/photo-1688362379203-9cdf13041d41?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=2370&q=80"
            ),
            SliderModel(
                id=3,
                title = "Welcome To Sylet",
                slideImg = "https://images.unsplash.com/photo-1674574124649-778f9afc0e9c?ixlib=rb-4.0.3&ixid=M3wxMjA3fDF8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=2370&q=80"
            ),
            SliderModel(
                id=4,
                title = "Welcome To Sydney",
                slideImg = "https://images.unsplash.com/photo-1674574124649-778f9afc0e9c?ixlib=rb-4.0.3&ixid=M3wxMjA3fDF8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=2370&q=80"
            )
        )
        sliderAdapter.submitList(item)
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


    private fun setupIndicators() {
        val indicators = arrayOfNulls<ImageView>(sliderAdapter.itemCount)
        val layoutParams: LinearLayout.LayoutParams =
            LinearLayout.LayoutParams(WRAP_CONTENT,WRAP_CONTENT)
        layoutParams.setMargins(8,0,8,0)
        for (i in indicators.indices){
            indicators[i] = ImageView(requireActivity())
            indicators[i].apply {
                this?.setImageDrawable(
                    ContextCompat.getDrawable(requireActivity(),R.drawable.indicator_inactive)
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
                imageView.setImageDrawable(ContextCompat.getDrawable(requireActivity(),R.drawable.indicator_active))
            }else{
                imageView.setImageDrawable(ContextCompat.getDrawable(requireActivity(),R.drawable.indicator_inactive))
            }
        }


    }

}