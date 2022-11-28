package ru.chani.github.domain

import ru.chani.github.domain.models.OwnerModel
import ru.chani.github.domain.models.RepoModel

interface Repository {

    suspend fun getListOfRepoByOwner(ownerModel: OwnerModel): List<RepoModel>

}