package io.androidedu.hoop.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import io.androidedu.hoop.R
import io.androidedu.hoop.adapter.ChatListAdapter
import io.androidedu.hoop.db.ChatDb
import io.androidedu.hoop.entity.ChatEntity
import kotlinx.android.synthetic.main.fragment_chats.*
import kotlin.concurrent.thread

class ChatsFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_chats, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        with(rcycChatList) {
//
//            adapter = ChatListAdapter(GenerateDummyData.getDummyChatList()) { chatModel ->
//
//                Toast.makeText(activity, "${chatModel.userName}", Toast.LENGTH_SHORT).show()
//            }
//
//            layoutManager = LinearLayoutManager(activity)
//        }

        val contactInfoDB = ChatDb.getInstance(activity!!.applicationContext)
        val contactInfoDao = contactInfoDB?.getChatDao()
        val contactInfoEntity = ChatEntity(
            profilePhoto = android.R.drawable.ic_menu_edit,
            userName = "kubra",
            userMessage = "slm",
            date = "2 sa önce"
        )

        val contactInfoEntity2 = ChatEntity(
            profilePhoto = android.R.drawable.ic_menu_day,
            userName = "ayşe",
            userMessage = "mrb",
            date = "dün"
        )

        val contactInfoEntity3 = ChatEntity(
            profilePhoto = android.R.drawable.ic_menu_agenda,
            userName = "fatma",
            userMessage = "ödev var mı",
            date = "5 gün önce"
        )



        thread(start = true) {
            contactInfoDao?.addNewItem(contactInfoEntity)
            contactInfoDao?.addNewItem(contactInfoEntity2)
            contactInfoDao?.addNewItem(contactInfoEntity3)
        }


        thread(start = true) {
            val allContactList = contactInfoDao?.getAllList()
            rcycChatList.adapter = ChatListAdapter(allContactList!!) {}
            rcycChatList.layoutManager = LinearLayoutManager(activity!!.applicationContext)


        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = ChatsFragment()
    }
}
