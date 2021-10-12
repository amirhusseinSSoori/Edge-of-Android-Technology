package com.amirhusseinsoori.edge_of_android_technology.di

import android.content.Context
import androidx.room.Room
import com.amirhusseinsoori.edge_of_android_technology.data.local.AppDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object RoomModule {

    @Singleton
    @Provides
    fun provideDataBase(@ApplicationContext context: Context): AppDataBase = Room.databaseBuilder(
        context,
        AppDataBase::class.java, "appDataBase"
    ).build()

}