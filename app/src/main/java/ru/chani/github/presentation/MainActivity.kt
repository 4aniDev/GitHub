package ru.chani.github.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import ru.chani.github.R
import ru.chani.github.data.RepositoryImpl
import ru.chani.github.data.source.remote.api.RetrofitInstance
import ru.chani.github.domain.models.OwnerModel
import ru.chani.github.domain.usecases.GetListOfRepoByOwnerUseCase

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //  for testing
        val repository = RepositoryImpl()
        val getListOfRepoByOwnerUseCase = GetListOfRepoByOwnerUseCase(repository = repository)

        GlobalScope.launch(Dispatchers.IO) {
            val owner = OwnerModel(login = "4aniDev")
            val list = getListOfRepoByOwnerUseCase(owner)
            list.forEach {
                Log.i("TAG_TEST", it.toString())
            }
        }

    }
}