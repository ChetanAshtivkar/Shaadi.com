package com.assignment.shaadi.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.assignment.shaadi.data.database.models.Invitation
import com.assignment.shaadi.databinding.ListItemInvitationBinding
import java.util.*

/**
 * Created by Chetan on 27/09/20.
 */
//class InvitationListAdapter(
//    private val invitationList: ArrayList<Invitation>,
//    private val listener: InvitationListener
//) :
//    RecyclerView.Adapter<InvitationViewHolder>() {
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InvitationViewHolder {
//        return InvitationViewHolder.from(parent)
//    }
//
//    override fun getItemCount(): Int {
//        return invitationList.size
//    }
//
//    override fun onBindViewHolder(holder: InvitationViewHolder, position: Int) {
//        holder.bind(invitationList[position], position, listener)
//    }
//}
//
//class InvitationViewHolder(private val binding: ListItemInvitationBinding) :
//    RecyclerView.ViewHolder(binding.root) {
//    fun bind(
//        invitation: Invitation,
//        position: Int,
//        listener: InvitationListener
//    ) {
//        binding.invitation = invitation
//        binding.position = position
//        binding.listener = listener
//    }
//
//    companion object {
//        fun from(parent: ViewGroup): InvitationViewHolder {
//            val layoutInflater = LayoutInflater.from(parent.context)
//            val binding = ListItemInvitationBinding.inflate(layoutInflater, parent, false)
//            return InvitationViewHolder(binding)
//        }
//    }
//}
//
//
//class InvitationListener(val clickListener: (invitation: Invitation, position: Int, accept: Boolean) -> Unit) {
//    fun onClick(invitation: Invitation, position: Int, accept: Boolean) =
//        clickListener(invitation, position, accept)
//}