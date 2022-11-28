package ru.chani.github.presentation.searchscreen

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import ru.chani.github.databinding.CvRepoItemBinding
import ru.chani.github.domain.models.RepoModel

class RepoAdapter : RecyclerView.Adapter<RepoAdapter.CustomViewHolder>() {

    private var listOfRepositories = emptyList<RepoModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val binding = CvRepoItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )

        return CustomViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        (holder.binding as CvRepoItemBinding).tvRepoTitle.text = listOfRepositories[position].name
        println(listOfRepositories[position].name)
    }

    fun setListOfRepositories(newList: List<RepoModel>) {
        val diffCallback = RepoDiffCallback(listOfRepositories, newList)
        val diffResult = DiffUtil.calculateDiff(diffCallback)

        listOfRepositories = newList
        diffResult.dispatchUpdatesTo(this)
    }

    override fun getItemCount(): Int {
        return listOfRepositories.size
    }


    inner class CustomViewHolder(val binding: ViewBinding) : RecyclerView.ViewHolder(binding.root)

}