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
import ru.chani.github.presentation.searchscreen.SearchFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, SearchFragment.newInstance())
            .commit()
    }
}