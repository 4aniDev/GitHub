package ru.chani.github.domain.models

data class OwnerModel(
    val id: Int = UNDEFINED_ID,
    val login: String
) {
    companion object {
        private const val UNDEFINED_ID = 0
    }
}
