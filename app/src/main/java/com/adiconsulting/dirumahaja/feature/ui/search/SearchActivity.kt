package com.adiconsulting.dirumahaja.feature.ui.search

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.adiconsulting.dirumahaja.R
import com.adiconsulting.dirumahaja.base.ViewModelProviderFactory
import com.adiconsulting.dirumahaja.feature.entity.Data
import com.adiconsulting.dirumahaja.feature.ui.adapter.NewsRepoAdapter
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_homepage.*
import kotlinx.android.synthetic.main.content_section_news.*
import kotlinx.android.synthetic.main.toolbar_search.*
import javax.inject.Inject

class SearchActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var viewModel: SearchViewModel
    @Inject
    lateinit var viewModelFactory: ViewModelProviderFactory

    private var adapter = NewsRepoAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_news)
        initDataViewModel()
        initComponent()
    }

    private fun initComponent() {
        newsRecycleView.layoutManager = LinearLayoutManager(this)
        newsRecycleView.adapter = adapter
        newsRecycleView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        adapter.updateList(viewModel.getEmptyListForShimmer())
        swipeRefresh.setOnRefreshListener {
            refresh()
        }
        backButton.setOnClickListener(View.OnClickListener { onBackPressed() })

        searchNews.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {}

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                loadData()
            }

        })
    }

    private fun loadData() {
        if (searchNews.text.toString().length >= 5){
            viewModel.getListNews(true)
        }
    }

    private fun initDataViewModel() {
        viewModel.getListNews(false)
        viewModel.getData().observe(this, Observer {
            when (it) {
                is Data.ERROR -> {
                    var error = it.error
                    swipeRefresh.isRefreshing = false
                }
                is Data.SUCCESS -> {
                    swipeRefresh.isRefreshing = false
                    it.data?.let { list -> adapter.updateList(list) }
                }
            }
        })
    }

    private fun refresh() {
        viewModel.getListNews(true)
        adapter.updateList(viewModel.getEmptyListForShimmer())
    }
}