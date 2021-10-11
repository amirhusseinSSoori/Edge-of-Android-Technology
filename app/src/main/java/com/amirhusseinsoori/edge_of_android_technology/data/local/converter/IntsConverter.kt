package com.amirhusseinsoori.edge_of_android_technology.data.local.converter

import androidx.room.TypeConverter
import com.google.gson.reflect.TypeToken

import com.google.gson.Gson
import java.lang.reflect.Type


class IntsConverter {
    @TypeConverter
    fun convertIntsToString(data: List<Int>?): String? {
        data?.let {
            val gson = Gson()
            val type: Type = object : TypeToken<List<Int>?>() {}.type
            return gson.toJson(data, type)
        } ?: kotlin.run {
            return null
        }
    }

    @TypeConverter
    fun convertStringToInt(data: String?): List<Int>? {
        data?.let {
            val gson = Gson()
            val type: Type = object : TypeToken<List<Int>?>() {}.type
            return gson.fromJson<List<Int>>(data, type)
        } ?: kotlin.run {
            return null
        }

    }
}