package com.versilis.sprintproject.data.local.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Makeup(
    @SerializedName("name")
    val name: String,
    @SerializedName("price")
    val price: Float,
    @SerializedName("image_link")
    val imageUri: String,
    @SerializedName("rating")
    val rating: Float
) : Serializable