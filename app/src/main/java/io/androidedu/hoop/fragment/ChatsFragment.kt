package io.androidedu.hoop.fragment

import android.graphics.Color
import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.get
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import io.androidedu.hoop.R
import io.androidedu.hoop.adapter.ChatListAdapter
import io.androidedu.hoop.db.ChatDb
import io.androidedu.hoop.entity.ChatEntity
import kotlinx.android.synthetic.main.fragment_chats.*
import kotlin.concurrent.thread


class ChatsFragment : Fragment() {

    var chatDB: ChatDb? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //val chatDB = ChatDb.getInstance(activity!!.applicationContext)
        chatDB = ChatDb.getInstance(context!!)
        val contactInfoDao = chatDB?.getChatDao()
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

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_chats, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val contactInfoDao = chatDB?.getChatDao()
        val allContactList = contactInfoDao?.getAllList()


        rcycChatList.adapter = ChatListAdapter(
            onItemClickListener =
            {
                selectItem(it)

            },
            onLongClickListener =
            {
                (view.context as AppCompatActivity).startSupportActionMode(ActionModeCallback())
                selectItem(it)

            }
        )

        rcycChatList.layoutManager = LinearLayoutManager(activity)

        allContactList?.observe(this, Observer {
            (rcycChatList.adapter as ChatListAdapter).setNewItem(it)

        })

    }

    companion object {
        @JvmStatic
        fun newInstance() = ChatsFragment()
    }

    private var multiSelect = false
    private val selectedItems = ArrayList<ChatEntity>()

    inner class ActionModeCallback : androidx.appcompat.view.ActionMode.Callback {
        override fun onActionItemClicked(mode: androidx.appcompat.view.ActionMode?, item: MenuItem?): Boolean {

            for (item in selectedItems) {
                thread(start = true) {
                    chatDB?.getChatDao()?.removeItem(item)
                }
            }
            mode!!.finish()
            return true
        }

        override fun onCreateActionMode(mode: androidx.appcompat.view.ActionMode?, menu: Menu?): Boolean {
            multiSelect = true
            menu!!.add("Delete")
            return true
        }

        override fun onPrepareActionMode(mode: androidx.appcompat.view.ActionMode?, menu: Menu?): Boolean {
            return false
        }

        override fun onDestroyActionMode(mode: androidx.appcompat.view.ActionMode?) {
            multiSelect = false
            selectedItems.clear()

        }
    }

    private fun selectItem(chatEntity: ChatEntity) {
        if (multiSelect) {
            if (selectedItems.contains(chatEntity)) {
                selectedItems.remove(chatEntity)
                // frameLayout.setBackgroundColor(Color.WHITE)


            } else {
                selectedItems.add(chatEntity)
                //  frameLayout.setBackgroundColor(Color.LTGRAY)
            }
        }
    }
}