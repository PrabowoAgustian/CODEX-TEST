package com.codex.test.feature.splashscreen

import android.os.Bundle
import android.os.Handler
import android.view.Window
import android.view.WindowManager
import com.codex.test.R
import com.codex.test.base.view.activity.BaseActivity
import com.codex.test.feature.story.TopStoryActivity

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
        return R.layout.activity_splashscreen
    }

    override fun onResume() {
        super.onResume()
        goToHomeActivity()
    }

    private fun goToHomeActivity() {
        Handler().postDelayed({
            showActivityAndFinishAllActivity(this, TopStoryActivity::class.java)
            finish()
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
        }, 5000)
    }

}