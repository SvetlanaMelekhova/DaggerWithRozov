package com.svetlana.learn.daggerwithrozov

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.coroutineScope
import androidx.lifecycle.repeatOnLifecycle
import com.svetlana.learn.daggerwithrozov.data.News
import com.svetlana.learn.daggerwithrozov.databinding.FragmentNewsDetailsBinding
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

class NewsDetailsFragment : Fragment(R.layout.fragment_news_details) {

    private lateinit var viewBinding: FragmentNewsDetailsBinding
    private val newsId: String by stringArgs(ARG_NEWS_ID)
    private val viewModel: NewsDetailsViewModel by viewModels() {
        factory.create(newsId)
    }

    // Lazy и Provider не работаю с зависимостями, которые используют Assisted Inject
    @Inject
    lateinit var factory: NewsDetailsViewModelFactory.Factory

    override fun onAttach(context: Context) {
        context.appComponent.inject(this)
        super.onAttach(context)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinding = FragmentNewsDetailsBinding.bind(view)
        viewLifecycleOwner.lifecycle.coroutineScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.news.collect{
                    updateUi(it)
                }
            }
        }
    }

    private fun updateUi(news: News) {
        if (view == null) return
        with(viewBinding) {
            title.text = news.title
            body.text = news.body
        }
    }

    companion object {

        private const val ARG_NEWS_ID = "news_id"

        fun makeArgs(newsId: String): Bundle {
            return Bundle(1).apply {
                putString(ARG_NEWS_ID, newsId)
            }
        }
    }
}