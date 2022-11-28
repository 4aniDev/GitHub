package ru.chani.github.domain.usecases

import ru.chani.github.domain.Repository
import ru.chani.github.domain.models.OwnerModel

class GetListOfRepoByOwnerUseCase(private val repository: Repository) {
    suspend operator fun invoke(ownerModel: OwnerModel) =
        repository.getListOfRepoByOwner(ownerModel = ownerModel)
}