package com.assignment.shaadi.ui

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.assignment.shaadi.data.network.APIStatus
import com.assignment.shaadi.data.repository.InvitationRepository
import kotlinx.coroutines.Dispatchers

/**
 * Created by Chetan on 26/09/20.
 */
class MainViewModel(
    private val app: Application,
    private val repository: InvitationRepository
) : ViewModel() {
    fun getInvitations() = liveData(Dispatchers.IO) {
        emit(APIStatus.loading(apiResponse = null))
        try {
            emit(APIStatus.success(apiResponse = repository.getInvitations()))
        } catch (e: Exception) {
            emit(APIStatus.failure(apiResponse = null))
        }
    }
}