package com.assignment.shaadi.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.assignment.shaadi.data.database.models.Invitation
import com.assignment.shaadi.databinding.ListItemInvitationBinding

/**
 * Created by Chetan on 28/09/20.
 */
class InvitationPagedListAdapter(val listener: InvitationListener) :
    PagedListAdapter<Invitation, InvitationPagedListAdapter.InvitationViewHolder>(
        InvitationDiffCallback()
    ) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InvitationViewHolder {
        return InvitationViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: InvitationViewHolder, position: Int) {
        holder.bind(getItem(position), position, listener)
    }

    class InvitationViewHolder(private val binding: ListItemInvitationBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(
            invitation: Invitation?,
            position: Int,
            listener: InvitationListener
        ) {
            binding.invitation = invitation
            binding.position = position
            binding.listener = listener
        }

        companion object {
            fun from(parent: ViewGroup): InvitationViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ListItemInvitationBinding.inflate(layoutInflater, parent, false)
                return InvitationViewHolder(binding)
            }
        }
    }
}


class InvitationDiffCallback : DiffUtil.ItemCallback<Invitation>() {
    override fun areItemsTheSame(oldItem: Invitation, newItem: Invitation): Boolean {
        return oldItem.id.value == newItem.id.value
    }

    override fun areContentsTheSame(oldItem: Invitation, newItem: Invitation): Boolean {
        return oldItem == newItem
    }
}

class InvitationListener(val clickListener: (invitation: Invitation, position: Int, accept: Boolean) -> Unit) {
    fun onClick(invitation: Invitation, position: Int, accept: Boolean) =
        clickListener(invitation, position, accept)
}