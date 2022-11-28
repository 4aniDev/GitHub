package ru.chani.github.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import androidx.appcompat.widget.SearchView
import androidx.appcompat.widget.SearchView.OnQueryTextListener
import ru.chani.github.R
import ru.chani.github.databinding.ActivityMainBinding
import ru.chani.github.presentation.searchscreen.SearchFragment

class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val binding: ActivityMainBinding
        get() = _binding ?: throw RuntimeException("ActivityMainBinding == null")

    private lateinit var currentOnQueryTextListener: OnQueryTextListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val fragment = SearchFragment.newInstance()
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
        currentOnQueryTextListener = fragment
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu, menu)
        super.onCreateOptionsMenu(menu)

        val search = menu?.findItem(R.id.search)
        val searchView = search?.actionView as SearchView
        searchView.queryHint = "Enter user name"
        searchView.setOnQueryTextListener(currentOnQueryTextListener)


        return true
    }
}