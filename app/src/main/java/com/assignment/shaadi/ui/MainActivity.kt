package com.assignment.shaadi.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.assignment.shaadi.R
import com.assignment.shaadi.adapters.InvitationListAdapter
import com.assignment.shaadi.adapters.InvitationListener
import com.assignment.shaadi.data.database.models.Invitation
import com.assignment.shaadi.data.network.RetrofitFactory
import com.assignment.shaadi.data.network.Status
import com.assignment.shaadi.data.repository.InvitationRepository
import com.assignment.shaadi.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    private lateinit var adapter: InvitationListAdapter
    private val invitationList = ArrayList<Invitation>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setSupportActionBar(binding.toolbar)

        viewModel = ViewModelProvider(
            this,
            MainViewModelFactory(
                app = application, repository = InvitationRepository(
                    RetrofitFactory.makeRetrofitService()
                )
            )
        ).get(MainViewModel::class.java)

        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        setRecyclerViewAdapter()
        getData()
    }

    private fun setRecyclerViewAdapter() {
        adapter = InvitationListAdapter(
            invitationList,
            InvitationListener() { invitation, position, accept ->
                Log.d("Click", invitation.name.first + " " + position + " " + accept)
            })
        binding.invitationList.adapter = adapter
    }

    private fun getData() {

        viewModel.getInvitations().observe(this, Observer {
            it.let { response ->
                when (response.status) {
                    Status.LOADING -> {
                        binding.progressBar.show()
                    }

                    Status.SUCCESS -> {
                        binding.progressBar.hide()
                        invitationList.clear()
                        response.apiResponse?.results?.let { list -> invitationList.addAll(list) }
                        adapter.notifyDataSetChanged()
                    }

                    Status.FAILURE -> {
                        binding.progressBar.hide()
                        val snackBar: Snackbar = Snackbar
                            .make(binding.root, getString(R.string.error), Snackbar.LENGTH_LONG)
                            .setAction(
                                getString(R.string.try_again)
                            ) {
                                getData()
                            }
                        snackBar.show()
                    }
                }
            }
        })
    }
}