package com.assignment.shaadi.data

import androidx.paging.DataSource
import com.assignment.shaadi.data.database.InvitationDao
import com.assignment.shaadi.data.database.models.Invitation
import com.assignment.shaadi.data.network.APIService

/**
 * Created by Chetan on 28/09/20.
 */
class InvitationDataSourceFactory(
    private val service: APIService,
    private val invitationDao: InvitationDao
) : DataSource.Factory<Int, Invitation>() {

    override fun create(): DataSource<Int, Invitation> {
        return InvitationDataSource(service, invitationDao)
    }
}