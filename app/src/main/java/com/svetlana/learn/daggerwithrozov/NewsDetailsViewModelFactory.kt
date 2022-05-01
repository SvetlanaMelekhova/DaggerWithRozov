@file:Suppress("UNUSED_VARIABLE", "unused", "UNUSED_PARAMETER", "MemberVisibilityCanBePrivate")
package com.svetlana.learn.daggerwithrozov

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.svetlana.learn.daggerwithrozov.data.NewsRepository
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject

class NewsDetailsViewModelFactory @AssistedInject constructor(
    @Assisted("newsId")
    private val newsId: String,
    private val newsRepository: NewsRepository,
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        require(modelClass == NewsDetailsViewModel::class)
        return NewsDetailsViewModel(newsId, newsRepository) as T
    }

    @AssistedFactory
    interface Factory {
        fun create(@Assisted("newsId") newsId: String): NewsDetailsViewModelFactory
    }
}
