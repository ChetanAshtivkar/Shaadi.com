package com.assignment.shaadi.data.database.models

import com.google.gson.annotations.SerializedName


data class Location(

//    @SerializedName("street") val street: Street,
    @SerializedName("city") val city: String,
    @SerializedName("state") val state: String,
    @SerializedName("country") val country: String
//    @SerializedName("postcode") val postcode: Int,
)