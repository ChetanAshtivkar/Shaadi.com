package com.assignment.shaadi.data.database.models

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "invitation")
data class Invitation(
    @PrimaryKey(autoGenerate = true)
    @SerializedName(value = "db_id") var db_id: Int,

    @Embedded @SerializedName("id") var id: Id,
    @Embedded @SerializedName("name") val name: Name,
    @Embedded @SerializedName("location") val location: Location,
    @Embedded @SerializedName("dob") val dob: Dob,
    @Embedded @SerializedName("picture") val picture: Picture,
    var isAccepted: Boolean? = null
)

data class Id(
    @SerializedName("value") val value: String
)