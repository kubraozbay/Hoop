package io.androidedu.hoop.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import io.androidedu.hoop.entity.ChatEntity

@Dao
interface ChatDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addNewItem(chatEntity: ChatEntity)

    @Delete
    fun removeItem(chatEntity: ChatEntity)

    @Update
    fun updateItem(chatEntity: ChatEntity)

    @Query("SELECT *FROM chat_table WHERE id LIKE :id")
    fun findSingleItem(id: Int): ChatEntity

    @Query("SELECT *FROM chat_table")
    fun getAllList(): LiveData<List<ChatEntity>>
}