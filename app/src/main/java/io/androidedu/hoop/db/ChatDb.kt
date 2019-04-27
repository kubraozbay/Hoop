package io.androidedu.hoop.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import io.androidedu.hoop.dao.ChatDao
import io.androidedu.hoop.entity.ChatEntity

@Database(entities = [ChatEntity::class], version = 1)
abstract class ChatDb : RoomDatabase() {

    abstract fun getChatDao(): ChatDao

    companion object {
        private var INSTANCE: ChatDb? = null

        fun getInstance(context: Context): ChatDb? {
            if (INSTANCE == null) {
                synchronized(ChatDb::class) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        ChatDb::class.java, "hoop_database"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                }
            }
            return INSTANCE
        }
    }
}