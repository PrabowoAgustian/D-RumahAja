package com.adiconsulting.dirumahaja.feature.entity

sealed class Data<RequestData>{
    class ERROR<RequestData>(var error: String,var data: RequestData? = null): Data<RequestData>()

    class SUCCESS<RequestData>(var data: RequestData? = null): Data<RequestData>()
}