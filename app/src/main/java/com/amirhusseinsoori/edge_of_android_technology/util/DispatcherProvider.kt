package com.amirhusseinsoori.edge_of_android_technology.util

import kotlinx.coroutines.CoroutineDispatcher

import kotlinx.coroutines.Dispatchers

interface DispatcherProvider {

    fun main(): CoroutineDispatcher = Dispatchers.Main

    fun default(): CoroutineDispatcher = Dispatchers.Default

    fun io(): CoroutineDispatcher = Dispatchers.IO

    fun unconfined(): CoroutineDispatcher = Dispatchers.Unconfined

}

class DispatcherProviderImpl : DispatcherProvider