package com.adiconsulting.dirumahaja.feature.ui.main

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import butterknife.OnClick
import com.adiconsulting.dirumahaja.R
import com.adiconsulting.dirumahaja.base.ViewModelProviderFactory
import com.adiconsulting.dirumahaja.feature.entity.Data
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_homepage.*
import kotlinx.android.synthetic.main.content_section_news.*
import javax.inject.Inject

class HomeActivity : DaggerAppCompatActivity() {
    @Inject
    lateinit var viewModel: HomeViewModel
    @Inject
    lateinit var viewModelFactory: ViewModelProviderFactory

    private var adapter = TopHeadlineNewsRepoAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homepage)
        initComponent()
        initDataViewModel()
    }

    private fun initComponent() {
        newsRecycleView.layoutManager = LinearLayoutManager(this)
        newsRecycleView.adapter = adapter
        newsRecycleView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        adapter.updateList(viewModel.getEmptyListForShimmer())
        swipeRefresh.setOnRefreshListener {
            refresh()
        }
    }

    private fun initDataViewModel() {
        viewModel.getListTopHeadline(false)
        viewModel.getData().observe(this, Observer {
            when (it) {
                is Data.ERROR -> {
                    var error = it.error
                    swipeRefresh.isRefreshing = false
                }
                is Data.SUCCESS -> {
                    swipeRefresh.isRefreshing = false
                    it.data?.let { list -> adapter?.updateList(list) }
                }
            }
        })
    }

    private fun refresh() {
        viewModel.getListTopHeadline(true)
        adapter.updateList(viewModel.getEmptyListForShimmer())
    }

    @OnClick(R.id.searchNews)
    fun searchClicked(){
    }
}