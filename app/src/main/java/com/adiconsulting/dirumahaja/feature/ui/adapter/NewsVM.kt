package com.adiconsulting.dirumahaja.feature.ui.adapter

import android.content.res.Resources
import androidx.databinding.BaseObservable
import com.adiconsulting.dirumahaja.feature.entity.ListTopHeadlineNews

class NewsVM constructor(private var topHeadlineNewsVM: ListTopHeadlineNews?, private var res: Resources?) : BaseObservable() {
    fun getTitle(): String? {
        return topHeadlineNewsVM?.title
    }

    fun getAuthor(): String? {
        return topHeadlineNewsVM?.author
    }
}