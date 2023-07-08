package com.maruf.telemedicineapp.utils

import com.maruf.telemedicineapp.data.local.Product
import com.maruf.telemedicineapp.data.local.Banner

object Utils {
    //demo data for slider list
    val sliderItems = listOf(
        Banner(
            id = 1,
            title = "Welcome Our Apps",
            slideImg = "https://images.pexels.com/photos/263402/pexels-photo-263402.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1"
        ),
        Banner(
            id = 2,
            title = "",
            slideImg = "https://images.pexels.com/photos/1692693/pexels-photo-1692693.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1"
        ),
        Banner(
            id = 3,
            title = "",
            slideImg = "https://images.pexels.com/photos/3769151/pexels-photo-3769151.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1"
        ),
        Banner(
            id = 4,
            title = "",
            slideImg = "https://images.pexels.com/photos/3279203/pexels-photo-3279203.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1"
        )
    )

    //demo data for product list
    val productItems = listOf(
        Product(
            id = 1,
            productSubtitle = "Surgel",
            ProductTitle = "https://epharma.com.bd/storage/app/public/1pw6NCLPzF81RxHPgc6LKmw8O7dy9F3POUBHPi63.jpg",
            createdDate = "06 jun,2023",
            productImage = "Esomeprazole Magnesium Trihydrate",
            stock = true
        ),
        Product(
            id = 1,
            productSubtitle = "Napa",
            ProductTitle = "https://osudpotro.com/napa",
            createdDate = "07 jun,2022",
            productImage = "Paracetamol",
            stock = true
        ),
        Product(
            id = 1,
            productSubtitle = "Surgel",
            ProductTitle = "https://images.pexels.com/photos/263402/pexels-photo-263402.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            createdDate = "06 jun,2023",
            productImage = "Esomeprazole Magnesium Trihydrate",
            stock = true
        ),
        Product(
            id = 1,
            productSubtitle = "Surgel",
            ProductTitle = "https://images.pexels.com/photos/263402/pexels-photo-263402.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            createdDate = "06 jun,2023",
            productImage = "Esomeprazole Magnesium Trihydrate",
            stock = true
        ),
        Product(
            id = 1,
            productSubtitle = "Surgel",
            ProductTitle = "https://images.pexels.com/photos/263402/pexels-photo-263402.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            createdDate = "06 jun,2023",
            productImage = "Esomeprazole Magnesium Trihydrate",
            stock = true
        ),
    )
}