package com.adiconsulting.dirumahaja.feature.ui.splash

import android.os.Bundle
import android.os.Handler
import android.view.Window
import android.view.WindowManager
import com.adiconsulting.dirumahaja.MainActivity
import com.adiconsulting.dirumahaja.R
import com.adiconsulting.dirumahaja.base.BaseActivity
import com.adiconsulting.dirumahaja.feature.ui.main.HomeActivity

class AfterSplashScreenActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        super.onCreate(savedInstanceState)
    }

    override fun layoutRes(): Int {
        return R.layout.activity_splash_screen
    }

    override fun onResume() {
        super.onResume()
        goToHomeActivity()
    }

    private fun goToHomeActivity() {
        Handler().postDelayed({
            showActivityAndFinishAllActivity(this, HomeActivity::class.java)
            finish()
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
        }, 5000)
    }

}