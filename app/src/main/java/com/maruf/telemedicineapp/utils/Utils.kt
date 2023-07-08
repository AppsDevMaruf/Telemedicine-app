package com.maruf.telemedicineapp.utils

import com.maruf.telemedicineapp.data.local.Product
import com.maruf.telemedicineapp.data.local.Banner

object Utils {
    //demo data for slider list
    val sliderItems = listOf(
        Banner(
            id = 1,
            title = "Welcome Our Apps",
            slideImg = "https://images.pexels.com/photos/1692693/pexels-photo-1692693.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1"
        ),
        Banner(
            id = 2,
            title = "",
            slideImg = "https://media.gettyimages.com/id/1312706413/photo/modern-hospital-building.jpg?s=1024x1024&w=gi&k=20&c=2nU8Ac2_g9NiiRTgZXfBqSRx50tR4x8R7io7X1OCUFg="
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
            productTitle = "Surgel",
            productSubtitle = "Esomeprazole Magnesium Trihydrate",
            productImage = "https://epharma.com.bd/storage/app/public/1pw6NCLPzF81RxHPgc6LKmw8O7dy9F3POUBHPi63.jpg",
            createdDate = "06 jun,2023",
            stock = true
        ),
        Product(
            id = 2,
            productTitle = "Napa",
            productSubtitle = "Paracetamol 500mg",
            productImage = "https://chaldn.com/_mpimage/napa-tablet-500mg-10-tablets?src=https%3A%2F%2Feggyolk.chaldal.com%2Fapi%2FPicture%2FRaw%3FpictureId%3D106095&q=low&v=1&m=400&webp=1",
            createdDate = "02 jun,2021",
            stock = false
        ),
        Product(
            id = 3,
            productTitle = "Biotin Plus",
            productSubtitle = "Biotin",
            productImage = "https://d35cnulyv0pa6p.cloudfront.net/products/images/2022/363716/biotin_plus_30.jpg?EZpU9iSSptgHCf4vbz97NCTpusgOKjm7=",
            createdDate = "26 jan,2022",
            stock = true
        ),
        Product(
            id = 4,
            productTitle = "Amotid 250gm",
            productSubtitle = "Amoxicillin",
            productImage = "https://www.biopharmabd.com/public/uploads/images/product_img_167807157668341.png",
            createdDate = "16 dec,2018",
            stock = true
        ),
        Product(
            id = 5,
            productTitle = "Surgel",
            productSubtitle = "Esomeprazole Magnesium Trihydrate",
            productImage = "https://epharma.com.bd/storage/app/public/1pw6NCLPzF81RxHPgc6LKmw8O7dy9F3POUBHPi63.jpg",
            createdDate = "06 jun,2023",
            stock = true
        ),
        Product(
            id = 6,
            productTitle = "Surgel",
            productSubtitle = "Esomeprazole Magnesium Trihydrate",
            productImage = "https://epharma.com.bd/storage/app/public/1pw6NCLPzF81RxHPgc6LKmw8O7dy9F3POUBHPi63.jpg",
            createdDate = "06 jun,2023",
            stock = true
        ),
        Product(
            id = 7,
            productTitle = "Surgel",
            productSubtitle = "Esomeprazole Magnesium Trihydrate",
            productImage = "https://epharma.com.bd/storage/app/public/1pw6NCLPzF81RxHPgc6LKmw8O7dy9F3POUBHPi63.jpg",
            createdDate = "06 jun,2023",
            stock = true
        ),
        Product(
            id = 8,
            productTitle = "Surgel",
            productSubtitle = "Esomeprazole Magnesium Trihydrate",
            productImage = "https://epharma.com.bd/storage/app/public/1pw6NCLPzF81RxHPgc6LKmw8O7dy9F3POUBHPi63.jpg",
            createdDate = "06 jun,2023",
            stock = true
        ),
    )
}