package com.ramosoft.artgallerycenter.repository

import com.ramosoft.artgallerycenter.networking.RetrofitService

class MainRepository constructor(private val retrofitService: RetrofitService) {

    suspend fun getAllMovies() = retrofitService.getAllMovies()

}