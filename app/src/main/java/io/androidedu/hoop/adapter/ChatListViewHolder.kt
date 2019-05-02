package io.androidedu.hoop.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import io.androidedu.hoop.R
import io.androidedu.hoop.entity.ChatEntity


class ChatListViewHolder(parent: ViewGroup)

    : RecyclerView.ViewHolder(
    LayoutInflater.from(parent.context).inflate(
        R.layout.adapter_item_chat_list,
        parent,
        false
    )
) {


    private val imgProfile: ImageView = itemView.findViewById(R.id.imgvChatProfile)
    private val txtUserName: TextView = itemView.findViewById(R.id.txtChatUserName)
    private val txtUserMessage: TextView = itemView.findViewById(R.id.txtChatUserMessage)
    private val txtDate: TextView = itemView.findViewById(R.id.txtChatDate)

    fun bind(
        chatEntity: ChatEntity, onItemClickListener: (chatEntity: ChatEntity) -> Unit,
        onLongClickListener: (chatEntity: ChatEntity) -> Unit
    ) {

        imgProfile.setBackgroundResource(chatEntity.profilePhoto)
        txtUserName.text = chatEntity.userName
        txtUserMessage.text = chatEntity.userMessage
        txtDate.text = chatEntity.date

        itemView.setOnClickListener {

            onItemClickListener(chatEntity)
        }

        itemView.setOnLongClickListener {
            onLongClickListener(chatEntity)
            true
        }

    }


}