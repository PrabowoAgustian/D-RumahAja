package com.adiconsulting.dirumahaja.base

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.WindowManager
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import butterknife.ButterKnife
import com.adiconsulting.dirumahaja.R
import com.adiconsulting.dirumahaja.base.dialog.BaseDialog
import com.adiconsulting.dirumahaja.base.dialog.LoadingDialog

abstract class BaseActivity: AppCompatActivity() {

    private var inputMode: Int? = null
    lateinit var baseDialog: BaseDialog
    private lateinit var loadingDialog: LoadingDialog
    private var useNormalBackPress = false

    private fun getSoftInputMode(): Int {
        return inputMode ?: WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN
    }

    @LayoutRes
    abstract fun layoutRes(): Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.window.setSoftInputMode(getSoftInputMode())
        setContentView(layoutRes())
        ButterKnife.bind(this)
        createDialog()
    }

    private fun createDialog() {
        baseDialog = BaseDialog()
        loadingDialog = LoadingDialog()
    }

    protected fun showActivity(intent: Intent) {
        startActivity(intent)
        overridePendingTransition(R.anim.enter_from_right, R.anim.exit_to_left)
    }

    protected fun showActivityAndFinishCurrent(intent: Intent) {
        showActivity(intent)
        finish()
    }

    protected fun showActivityAndFinishAllActivity(context: Context, cls: Class<*>) {
        val intent = getIntent(context, cls)
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
        showActivityAndFinishCurrent(intent)
    }

    protected fun getIntent(context: Context, cls: Class<*>): Intent {
        return Intent(context, cls)
    }

    protected fun finishActivity() {
        finish()
        overridePendingTransition(R.anim.exit_to_right, R.anim.enter_from_left)
    }

    override fun onBackPressed() {
        if (useNormalBackPress)
            super.onBackPressed()
        else
            finishActivity()
    }
}