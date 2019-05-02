package io.androidedu.hoop.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import io.androidedu.hoop.entity.ChatEntity

//recylerview layoutmanager en öenmli 2.fark
//listview hepsini bir anda yazar, recylerview sadece ekranda gözükeni +1 -1 alarak yazdırır.

//viewpager daha yüklü viewlwer için kullanılır.recylerview daha  küçük veriler için.

class ChatListAdapter(
    var chatList: List<ChatEntity>?=null,
    val onItemClickListener: (chatEntity: ChatEntity) -> Unit,
    val onLongClickListener: (chatEntity: ChatEntity) -> Unit
) : RecyclerView.Adapter<ChatListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
            : ChatListViewHolder = ChatListViewHolder(parent)

    override fun getItemCount(): Int {
        chatList?.let {
            return it.size
        }
        return 0
    }

    override fun onBindViewHolder(holder: ChatListViewHolder, position: Int) {

        chatList?.let {
            holder.bind(it[position],onItemClickListener,onLongClickListener)
        }
    }


    fun setNewItem(chatList: List<ChatEntity>){
        this.chatList=chatList
        notifyDataSetChanged()
    }
}