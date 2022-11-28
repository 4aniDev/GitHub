package ru.chani.github.data.source.remote.api

import retrofit2.http.GET
import retrofit2.http.Path
import ru.chani.github.data.source.remote.models.ArrayOfRepositories


interface Api {

    @GET("users/{$USER_NAME}/repos")
    suspend fun getListOfRepositoriesByUserName(
        @Path(USER_NAME) userName: String
    ): ArrayOfRepositories


    companion object {
        private const val USER_NAME = "USER_NAME"
    }

}