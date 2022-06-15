package com.divyansh.newsapp.data.local

import androidx.room.TypeConverter
import com.divyansh.newsapp.data.model.Source

class Converters {
    @TypeConverter
    fun fromSource(name: String?): Source? {
        return name?.let { Source(it) }
    }

    @TypeConverter
    fun sourceToString(source: Source?): String {
        return source?.name.toString()
    }
}