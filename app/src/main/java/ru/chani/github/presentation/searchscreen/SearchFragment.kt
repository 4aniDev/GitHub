package ru.chani.github.presentation.searchscreen

import android.graphics.drawable.GradientDrawable.Orientation
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import ru.chani.github.databinding.FragmentSearchBinding

class SearchFragment : Fragment(), SearchView.OnQueryTextListener {

    private var _binding: FragmentSearchBinding? = null
    private val binding: FragmentSearchBinding
        get() = _binding ?: throw RuntimeException("FragmentSearchBinding == null")

    private lateinit var viewModel: SearchViewModel

    private lateinit var rvRepoAdapter: RepoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewModelFactory = SearchViewModelFactory(requireContext())
        viewModel = ViewModelProvider(this, viewModelFactory)[SearchViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSearchBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setRepoRecyclerView()

        viewModel.lisOfRepo.observe(viewLifecycleOwner) {
            rvRepoAdapter.setListOfRepositories(it)
        }
    }

    private fun setRepoRecyclerView() {
        with(binding.rv) {
            rvRepoAdapter = RepoAdapter()
            adapter = rvRepoAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
    }


    override fun onQueryTextSubmit(query: String?): Boolean {
        viewModel.getReposByLogin(query!!)
        return false
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        return true
    }

    companion object {
        @JvmStatic
        fun newInstance() = SearchFragment()
    }
}