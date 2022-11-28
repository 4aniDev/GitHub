package ru.chani.github.domain.models

data class RepoModel(
    val id: Int,
    val name: String,
    val archiveUrl: String,
    val htmlUrl: String,
    val owner: OwnerModel
)
