package com.adam.room.db.base

import androidx.room.PrimaryKey


abstract class BaseTable {

    @PrimaryKey(autoGenerate = true)
    var id = 0
}