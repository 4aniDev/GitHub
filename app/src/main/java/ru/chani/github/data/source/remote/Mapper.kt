package ru.chani.github.data.source.remote

import ru.chani.github.data.source.remote.models.ArrayOfRepositories
import ru.chani.github.data.source.remote.models.Owner
import ru.chani.github.data.source.remote.models.RepositoryItem
import ru.chani.github.domain.models.OwnerModel
import ru.chani.github.domain.models.RepoModel

object Mapper {

    private fun ownerToOwnerModel(owner: Owner) = OwnerModel(id = owner.id, login = owner.login)

    private fun repositoryItemToRepoModel(repo: RepositoryItem) = RepoModel(
        id = repo.id,
        name = repo.name,
        archiveUrl = repo.archive_url,
        htmlUrl = repo.html_url,
        owner = ownerToOwnerModel(repo.owner)
    )

    fun arrayOfRepositoryToListOfRepoModel(arrayOfRepositories: ArrayOfRepositories): List<RepoModel> {
        val listOfRepoModel = mutableListOf<RepoModel>()

        arrayOfRepositories.forEach { repositoryItem ->
            listOfRepoModel.add(repositoryItemToRepoModel(repositoryItem))
        }

        return listOfRepoModel
    }
}