package com.adiconsulting.dirumahaja.base.dialog

import com.adiconsulting.dirumahaja.R

class LoadingDialog : BaseFullScreenDialog() {

    override fun getLayout(): Int {
        return R.layout.dialog_loading
    }

}