package com.turtlecoin.turtlewallet

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.github.omadahealth.lollipin.lib.managers.AppLock
import com.github.omadahealth.lollipin.lib.managers.AppLockActivity
import com.github.omadahealth.lollipin.lib.managers.LockManager



class LockActivity : AppLockActivity() {


    override fun getContentView(): Int {
        return R.layout.activity_lock
    }

    override fun getPinLength(): Int {
        return 6
    }

    override fun onPinFailure(attempts: Int) {
        Toast.makeText(this, "wrong pin", Toast.LENGTH_LONG).show()
    }

    override fun showForgotDialog() {
    }

    override fun onPinSuccess(attempts: Int) {
    }

}
