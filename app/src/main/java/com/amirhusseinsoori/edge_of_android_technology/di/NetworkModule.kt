package com.amirhusseinsoori.edge_of_android_technology.di

import android.content.Context
import com.amirhusseinsoori.edge_of_android_technology.BuildConfig
import com.amirhusseinsoori.edge_of_android_technology.data.romote.ApiServices
import com.readystatesoftware.chuck.ChuckInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object NetworkModule {


    @Provides
    fun provideHttpLoggingInterceptor(): Interceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    @Provides
    fun provideOkHttpClient(
        httpLoggingInterceptor: Interceptor,
        @ApplicationContext context: Context
    ): OkHttpClient = OkHttpClient.Builder().addInterceptor(
        ChuckInterceptor(context)
    ).connectTimeout(60, TimeUnit.SECONDS)
        .readTimeout(60,TimeUnit.SECONDS)
        .addInterceptor(httpLoggingInterceptor).build()

    @Singleton
    @Provides
    fun provideRetrofit(
        okHttpClient: OkHttpClient
    ): Retrofit =
        Retrofit.Builder().baseUrl(BuildConfig.BASE_URL).client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create()).build()


    @Provides
    @Singleton
    fun provideApiService(
        retrofit: Retrofit
    ): ApiServices = retrofit.create(ApiServices::class.java)
}