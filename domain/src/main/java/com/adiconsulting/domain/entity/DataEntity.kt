package com.adiconsulting.domain.entity

sealed class DataEntity<RequestData>{
    class ERROR<RequestData>(var error: String,var data: RequestData? = null): DataEntity<RequestData>()

    class SUCCESS<RequestData>(var data: RequestData? = null): DataEntity<RequestData>()
}