package com.adam.room.db.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.adam.room.db.base.BaseDao
import com.adam.room.db.table.PhoneData

@Dao
interface PhoneDao : BaseDao<PhoneData> {

    @Query("SELECT * FROM phone_table")
    fun getData(): List<PhoneData>

    @Transaction
    fun updateData(users: List<PhoneData>) {
        deleteAll()
        insert(users)
    }

    @Query("DELETE FROM phone_table")
    fun deleteAll()
}