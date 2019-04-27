package io.androidedu.hoop.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import io.androidedu.hoop.entity.ChatEntity

//recylerview layoutmanager en öenmli 2.fark
//listview hepsini bir anda yazar, recylerview sadece ekranda gözükeni +1 -1 alarak yazdırır.

//viewpager daha yüklü viewlwer için kullanılır.recylerview daha  küçük veriler için.

class ChatListAdapter(val chatList: List<ChatEntity>,
                      val onItemClickListener: (chatEntity: ChatEntity) -> Unit) :
    RecyclerView.Adapter<ChatListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatListViewHolder = ChatListViewHolder(parent)

    override fun getItemCount(): Int = chatList.size

    override fun onBindViewHolder(holder: ChatListViewHolder, position: Int) {

        holder.bind(chatList[position], onItemClickListener)
    }
}