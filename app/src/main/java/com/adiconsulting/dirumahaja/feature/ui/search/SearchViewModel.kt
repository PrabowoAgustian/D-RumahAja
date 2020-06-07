package com.adiconsulting.dirumahaja.feature.ui.search

import androidx.lifecycle.MutableLiveData
import com.adiconsulting.dirumahaja.base.BaseViewModel
import com.adiconsulting.dirumahaja.feature.entity.Data
import com.adiconsulting.dirumahaja.feature.entity.ListTopHeadlineNews
import com.adiconsulting.dirumahaja.feature.maper.DomainToPresentationMapper
import com.adiconsulting.domain.usecase.TopHeadlineNewsRepoUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class SearchViewModel@Inject constructor(private var useCase : TopHeadlineNewsRepoUseCase) : BaseViewModel(){
    private val mapper  = DomainToPresentationMapper()
    private var dataList = MutableLiveData<Data<List<ListTopHeadlineNews>>>()

    fun getListNews(foreRefresh: Boolean) {
        if(dataList.value != null && !foreRefresh) {
            dataList.postValue(dataList.value)
        }else {
            launch {
                val deviceInfo = useCase.getListTopHeadlineNewsRepos()
                deviceInfo.consumeEach { response ->
                    val mappedResponse = mapper.mapTo(response)
                    withContext(Dispatchers.Main) {
                        dataList.postValue(mappedResponse)
                    }
                }
            }
        }
    }

    fun getData() =dataList

    fun getEmptyListForShimmer():List<ListTopHeadlineNews?>{
        val arrayList = ArrayList<ListTopHeadlineNews?>(10)
        for (i in 0..10){
            arrayList.add(null)
        }
        return arrayList
    }
}