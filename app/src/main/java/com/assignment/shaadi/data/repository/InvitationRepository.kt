package com.assignment.shaadi.data.repository

import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.assignment.shaadi.data.InvitationDataSourceFactory
import com.assignment.shaadi.data.database.InvitationDao
import com.assignment.shaadi.data.database.models.Invitation
import com.assignment.shaadi.data.network.APIService

/**
 * Created by Chetan on 26/09/20.
 */
class InvitationRepository(
    private val service: APIService,
    private val invitationDao: InvitationDao
) {

    fun fetchPicturesFromServer(): LiveData<PagedList<Invitation>> {

        val invitationDataSourceFactory =
            InvitationDataSourceFactory(service, invitationDao)

        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(true)
            .setInitialLoadSizeHint(10)
            .setPageSize(10)
            .setPrefetchDistance(5)
            .build()

        return LivePagedListBuilder(invitationDataSourceFactory, config)
            .build()
    }

}

