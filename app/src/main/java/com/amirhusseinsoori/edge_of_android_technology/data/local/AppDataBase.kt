package com.amirhusseinsoori.edge_of_android_technology.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.amirhusseinsoori.edge_of_android_technology.data.local.converter.IntsConverter
import com.amirhusseinsoori.edge_of_android_technology.data.local.converter.StringConverter

import com.amirhusseinsoori.edge_of_android_technology.model.local.MoviesEntity

@Database(entities = [MoviesEntity::class], version = 1)
@TypeConverters(IntsConverter::class, StringConverter::class)
abstract class AppDataBase : RoomDatabase() {
    abstract fun userDao(): MovieDao
}