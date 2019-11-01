package com.stepasha.makeupagain.model



data class MakeupItem (
    val id: Int,
    val brand: String,
    val name: String,
    val price: String,
    val image_link: String,
    val rating: Double,
    val api_featured_image: String
)