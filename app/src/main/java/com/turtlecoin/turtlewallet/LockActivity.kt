package com.turtlecoin.turtlewallet

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
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
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showForgotDialog() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onPinSuccess(attempts: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
