package com.assignment.shaadi.data

import androidx.paging.PageKeyedDataSource
import com.assignment.shaadi.data.database.InvitationDao
import com.assignment.shaadi.data.database.models.Invitation
import com.assignment.shaadi.data.network.APIService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * Created by Chetan on 28/09/20.
 */
const val LIST_SIZE = 10

class InvitationDataSource(
    private val service: APIService,
    private val invitationDao: InvitationDao
) : PageKeyedDataSource<Int, Invitation>() {

    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, Invitation>
    ) {
        CoroutineScope(Dispatchers.IO).launch {

            val invitations = invitationDao.getPaged(LIST_SIZE, 0 * LIST_SIZE)

            if (invitations.isEmpty()) {
                val data = service.getInvitations()

                val response = data.execute()
                val responseBody = response.body()

                responseBody?.let {
                    invitationDao.insertAll(responseBody.results)
                    callback.onResult(responseBody.results, null, 1)
                }
            } else {

                callback.onResult(invitations, null, 1)
            }
        }
    }

    private fun checkIfExistsAndFetch(
        currentPage: Int,
        callback: LoadCallback<Int, Invitation>
    ) {
        CoroutineScope(Dispatchers.IO).launch {

            val invitations = invitationDao.getPaged(LIST_SIZE, currentPage * LIST_SIZE)

            if (invitations.isEmpty()) {
                val data = service.getInvitations()

                val response = data.execute()
                val responseBody = response.body()

                responseBody?.let {
                    invitationDao.insertAll(responseBody.results)
                    callback.onResult(responseBody.results, currentPage + 1)
                }

            } else {

                callback.onResult(invitations, currentPage + 1)
            }
        }
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, Invitation>) {
        checkIfExistsAndFetch(params.key, callback)
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, Invitation>) {

    }

}