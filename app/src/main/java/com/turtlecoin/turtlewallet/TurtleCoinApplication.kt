package com.turtlecoin.turtlewallet

import android.app.Application
import com.github.omadahealth.lollipin.lib.managers.LockManager


class TurtleCoinApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        val lockManager = LockManager.getInstance()
        lockManager.enableAppLock(this, LockActivity::class.java)
        lockManager.appLock.timeout = 1000;
    }
}