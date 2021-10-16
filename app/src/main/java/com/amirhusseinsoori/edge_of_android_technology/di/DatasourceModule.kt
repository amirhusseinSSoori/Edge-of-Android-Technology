package com.amirhusseinsoori.edge_of_android_technology.di

import com.amirhusseinsoori.edge_of_android_technology.data.source.movie.local.MovieLocalDatasource
import com.amirhusseinsoori.edge_of_android_technology.data.source.movie.local.MovieLocalDatasourceImp
import com.amirhusseinsoori.edge_of_android_technology.data.source.movie.remote.MovieRemoteDatasource
import com.amirhusseinsoori.edge_of_android_technology.data.source.movie.remote.MovieRemoteDatasourceImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
class DatasourceModule {

    @Provides
    @Singleton
    fun provideMovieLocalDatasource(
        movieLocalDatasourceImp: MovieLocalDatasourceImp
    ): MovieLocalDatasource = movieLocalDatasourceImp

    @Provides
    @Singleton
    fun provideMovieRemoteDatasource(
        movieRemoteDatasourceImp: MovieRemoteDatasourceImp
    ): MovieRemoteDatasource = movieRemoteDatasourceImp
}