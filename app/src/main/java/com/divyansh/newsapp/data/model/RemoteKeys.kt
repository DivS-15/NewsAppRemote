package com.divyansh.newsapp.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "remote_keys")
data class RemoteKeys(
    @PrimaryKey
    @ColumnInfo
    val urlAsId: String,
    @ColumnInfo
    val prevKey: Int?,
    @ColumnInfo
    val nextKey: Int?
)
