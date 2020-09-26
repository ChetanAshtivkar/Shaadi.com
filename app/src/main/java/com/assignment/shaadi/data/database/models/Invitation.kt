package com.assignment.shaadi.data.database.models

import com.google.gson.annotations.SerializedName

data class Invitation(

    @SerializedName("gender") val gender: String,
    @SerializedName("name") val name: Name,
    @SerializedName("location") val location: Location,
    @SerializedName("email") val email: String,
    @SerializedName("login") val login: Login,
    @SerializedName("dob") val dob: Dob,
    @SerializedName("registered") val registered: Registered,
    @SerializedName("phone") val phone: String,
    @SerializedName("cell") val cell: String,
    @SerializedName("id") val id: Id,
    @SerializedName("picture") val picture: Picture,
    @SerializedName("nat") val nat: String
)