package ru.chani.github.presentation.searchscreen

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import ru.chani.github.data.RepositoryImpl
import ru.chani.github.domain.models.OwnerModel
import ru.chani.github.domain.models.RepoModel
import ru.chani.github.domain.usecases.GetListOfRepoByOwnerUseCase

class SearchViewModel(context: Context): ViewModel() {
    private val repository = RepositoryImpl()
    private val getListOfRepoByOwnerUseCase = GetListOfRepoByOwnerUseCase(repository)

    private val _listOfRepo = MutableLiveData<List<RepoModel>>()
    val lisOfRepo: LiveData<List<RepoModel>>
        get() = _listOfRepo


    fun getReposByLogin(login: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val owner = OwnerModel(login = login)
            val list = getListOfRepoByOwnerUseCase(owner)
            _listOfRepo.postValue(list)
        }
    }
}