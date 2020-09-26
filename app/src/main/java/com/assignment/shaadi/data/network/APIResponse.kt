package com.assignment.shaadi.data.network

import com.assignment.shaadi.data.database.models.Invitation
import com.google.gson.annotations.SerializedName

/**
 * Created by Chetan on 26/09/20.
 */
data class APIResponse(
    @SerializedName("results") val results: List<Invitation>
)