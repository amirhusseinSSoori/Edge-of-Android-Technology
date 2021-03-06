package com.amirhusseinsoori.edge_of_android_technology.di

import com.amirhusseinsoori.edge_of_android_technology.repository.MovieRepository
import com.amirhusseinsoori.edge_of_android_technology.repository.MovieRepositoryImp
import com.amirhusseinsoori.edge_of_android_technology.util.DispatcherProvider
import com.amirhusseinsoori.edge_of_android_technology.util.DispatcherProviderImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object RepositoryModule {

    @Provides
    @Singleton
    fun provideMovieRepository(
        movieRepositoryImp: MovieRepositoryImp
    ): MovieRepository = movieRepositoryImp



    @Provides
    fun provideDispatcherProvider(): DispatcherProvider = DispatcherProviderImpl()
}