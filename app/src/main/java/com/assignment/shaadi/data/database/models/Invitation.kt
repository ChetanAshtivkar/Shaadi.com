package com.assignment.shaadi.data.database.models

import com.google.gson.annotations.SerializedName

data class Invitation(

    @SerializedName("name") val name: Name,
    @SerializedName("location") val location: Location,
//    @SerializedName("email") val email: String,
    @SerializedName("dob") val dob: Dob,
//    @SerializedName("phone") val phone: String,
//    @SerializedName("cell") val cell: String,
    @SerializedName("picture") val picture: Picture
//    @SerializedName("nat") val nat: String
)