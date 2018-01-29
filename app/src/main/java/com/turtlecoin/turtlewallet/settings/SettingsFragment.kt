package com.turtlecoin.turtlewallet.settings

import android.content.SharedPreferences
import android.os.Bundle
import android.support.v7.app.AppCompatDelegate
import android.support.v7.preference.PreferenceFragmentCompat
import android.util.Log
import com.turtlecoin.turtlewallet.DashboardActivity
import com.turtlecoin.turtlewallet.R
import android.content.Intent
import android.support.v7.preference.Preference
import android.view.View
import com.github.omadahealth.lollipin.lib.managers.AppLock
import com.turtlecoin.turtlewallet.LockActivity


class SettingsFragment : PreferenceFragmentCompat(), SharedPreferences.OnSharedPreferenceChangeListener {

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.settings, rootKey)

    }

    override fun onResume() {
        super.onResume()
        preferenceScreen.sharedPreferences
                .registerOnSharedPreferenceChangeListener(this)
    }

    override fun onSharedPreferenceChanged(sharedPreferences: SharedPreferences, key: String) {
        val darkModeKey = getString(R.string.darkmode_setting)
        when (key) {
            darkModeKey -> setDarkMode(sharedPreferences.getBoolean(darkModeKey, false))
            else -> Log.d("Settings", "unknown key $key")
        }

    }

    private fun setDarkMode(darkMode: Boolean) {
        val nightMode = if (darkMode) AppCompatDelegate.MODE_NIGHT_YES else AppCompatDelegate.MODE_NIGHT_NO
        AppCompatDelegate.setDefaultNightMode(nightMode)
        startActivity(DashboardActivity.createSettingsIntent(activity))
        activity.overridePendingTransition(R.anim.abc_fade_in, R.anim.abc_fade_out)
        activity.finish()
    }

    override fun onPause() {
        super.onPause()
        preferenceScreen.sharedPreferences
                .unregisterOnSharedPreferenceChangeListener(this)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val userButton = findPreference(getString(R.string.reset_pin)) as Preference
        userButton.onPreferenceClickListener = Preference.OnPreferenceClickListener {
            val intent = Intent(activity, LockActivity::class.java)
            intent.putExtra(AppLock.EXTRA_TYPE, AppLock.CHANGE_PIN)
            startActivity(intent)
            true
        }
    }

}