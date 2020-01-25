package com.adam.room.db.table

import androidx.room.ColumnInfo
import androidx.room.Entity
import com.adam.room.db.base.BaseTable

@Entity(tableName = "phone_table")
data class PhoneData(

    @ColumnInfo(name = "user_name")
    val userName: String,

    @ColumnInfo(name = "phone_number")
    val phoneNumber: String

) : BaseTable()