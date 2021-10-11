package com.amirhusseinsoori.edge_of_android_technology.data.local.converter

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

class StringConverter {
    @TypeConverter
    fun convertStringsToString(data: List<String>?): String? {
        data?.let {
            val gson = Gson()
            val type: Type = object : TypeToken<List<String>?>() {}.type
            return gson.toJson(data, type)
        } ?: kotlin.run {
            return null
        }
    }

    @TypeConverter
    fun convertStringToStrings(data: String?): List<String>? {
        data?.let {
            val gson = Gson()
            val type: Type = object : TypeToken<List<Int>?>() {}.type
            return gson.fromJson<List<String>>(data, type)
        } ?: kotlin.run {
            return null
        }

    }
}