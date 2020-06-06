package com.adiconsulting.data.entity

data class ListTopHeadlineResponse (var source: NewsSource,
                                    var author: String = "",
                                    var title: String = "",
                                    var description: String = "",
                                    var url: String = "",
                                    var urlToImage: String? = null,
                                    var publishedAt: String = "",
                                    var content: String = "")