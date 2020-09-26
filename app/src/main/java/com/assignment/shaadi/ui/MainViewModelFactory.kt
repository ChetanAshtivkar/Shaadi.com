package com.assignment.shaadi.ui

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.assignment.shaadi.data.repository.InvitationRepository

/**
 * Created by Chetan on 26/09/20.
 */

class MainViewModelFactory(private val app: Application, private val repository: InvitationRepository) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {

            @Suppress("UNCHECKED_CAST")
            return MainViewModel(app = app, repository = repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}