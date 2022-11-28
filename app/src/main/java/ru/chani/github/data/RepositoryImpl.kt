package ru.chani.github.data

import ru.chani.github.data.source.remote.Mapper
import ru.chani.github.data.source.remote.api.RetrofitInstance
import ru.chani.github.domain.Repository
import ru.chani.github.domain.models.OwnerModel
import ru.chani.github.domain.models.RepoModel

class RepositoryImpl : Repository {
    override suspend fun getListOfRepoByOwner(ownerModel: OwnerModel): List<RepoModel> {
        return Mapper.arrayOfRepositoryToListOfRepoModel(
            RetrofitInstance.api.getListOfRepositoriesByUserName(ownerModel.login)
        )
    }

}