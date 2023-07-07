package com.maruf.telemedicineapp.utils

import com.maruf.telemedicineapp.data.model.ProductModel
import com.maruf.telemedicineapp.data.model.SliderModel

object Utils {
    //demo data for slider list
    val sliderItems = listOf(
        SliderModel(
            id=1,
            title = "Welcome Our Apps",
            slideImg = "https://images.pexels.com/photos/263402/pexels-photo-263402.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1"
        ),
        SliderModel(
            id=2,
            title = "",
            slideImg = "https://images.pexels.com/photos/1692693/pexels-photo-1692693.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1"
        ),
        SliderModel(
            id=3,
            title = "",
            slideImg = "https://images.pexels.com/photos/3769151/pexels-photo-3769151.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1"
        ),
        SliderModel(
            id=4,
            title = "",
            slideImg = "https://images.pexels.com/photos/3279203/pexels-photo-3279203.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1"
        )
    )
    //demo data for product list
    val productItems = listOf(
        ProductModel(
            id=1,
            productName = "Surgel",
            productImg = "https://epharma.com.bd/storage/app/public/1pw6NCLPzF81RxHPgc6LKmw8O7dy9F3POUBHPi63.jpg",
            productDate = "06 jun,2023",
            productGroup = "Esomeprazole Magnesium Trihydrate"
        ),
        ProductModel(
            id=1,
            productName = "Napa",
            productImg = "https://osudpotro.com/napa",
            productDate = "07 jun,2022",
            productGroup = "Paracetamol"
        ),      ProductModel(
            id=1,
            productName = "Surgel",
            productImg = "https://images.pexels.com/photos/263402/pexels-photo-263402.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            productDate = "06 jun,2023",
            productGroup = "Esomeprazole Magnesium Trihydrate"
        ),      ProductModel(
            id=1,
            productName = "Surgel",
            productImg = "https://images.pexels.com/photos/263402/pexels-photo-263402.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            productDate = "06 jun,2023",
            productGroup = "Esomeprazole Magnesium Trihydrate"
        ),      ProductModel(
            id=1,
            productName = "Surgel",
            productImg = "https://images.pexels.com/photos/263402/pexels-photo-263402.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            productDate = "06 jun,2023",
            productGroup = "Esomeprazole Magnesium Trihydrate"
        ),
    )
}