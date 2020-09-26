package com.assignment.shaadi.data.repository

import com.assignment.shaadi.data.network.APIService

/**
 * Created by Chetan on 26/09/20.
 */
class InvitationRepository(private val service: APIService) {
    suspend fun getInvitations() = service.getInvitations()
}

