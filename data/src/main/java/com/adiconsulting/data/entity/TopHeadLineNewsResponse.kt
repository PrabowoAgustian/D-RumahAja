package com.adiconsulting.data.entity

import com.adiconsulting.domain.entity.ListTopHeadlineEntity

data class TopHeadLineNewsResponse (var status : String = "",
                                    var totalResults : Int = 0,
                                    var articles : ListTopHeadlineEntity
)