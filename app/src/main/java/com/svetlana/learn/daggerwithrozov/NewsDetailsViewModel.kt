@file:Suppress("UNUSED_VARIABLE", "unused", "UNUSED_PARAMETER", "MemberVisibilityCanBePrivate")
package com.svetlana.learn.daggerwithrozov

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.svetlana.learn.daggerwithrozov.data.News
import com.svetlana.learn.daggerwithrozov.data.NewsRepository
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.shareIn

class NewsDetailsViewModel (
    private val newsId: String,
    private val newsRepository: NewsRepository
) : ViewModel() {

    val news: SharedFlow<News> =
        flow<News> { newsRepository.getNews(newsId) }
            .shareIn(viewModelScope, SharingStarted.Lazily, replay = 1)
}
