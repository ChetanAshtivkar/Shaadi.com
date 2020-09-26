package com.assignment.shaadi.data.database.models

import com.google.gson.annotations.SerializedName


data class Login(

    @SerializedName("uuid") val uuid: String,
    @SerializedName("username") val username: String,
    @SerializedName("salt") val salt: String,
    @SerializedName("md5") val md5: String,
    @SerializedName("sha1") val sha1: String,
    @SerializedName("sha256") val sha256: String
)