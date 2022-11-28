package ru.chani.github.presentation.searchscreen

import androidx.recyclerview.widget.DiffUtil
import ru.chani.github.domain.models.RepoModel

class RepoDiffCallback(
    private val oldList: List<RepoModel>,
    private val newList: List<RepoModel>
) : DiffUtil.Callback() {

    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldRepository = oldList[oldItemPosition]
        val newRepository = newList[newItemPosition]
        return oldRepository.name == newRepository.name
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldAd = oldList[oldItemPosition]
        val newAd = newList[newItemPosition]
        return oldAd == newAd
    }
}