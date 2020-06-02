@file:Suppress("DEPRECATION")

package com.codex.test.base.data

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import com.codex.test.BuildConfig
import com.securepreferences.SecurePreferences

@Suppress("DEPRECATION")
open class PreferenceManager (
    context: Context,
    preferenceName : String
){
    private val securePreferences: SecurePreferences = SecurePreferences(
        context,
        BuildConfig.keyPreference,
        preferenceName
    )

    private val sharedPreferences: SharedPreferences =
        PreferenceManager.getDefaultSharedPreferences(context)

    /*
    write all setter below
     */

    fun setLocalTitle(title: String?) {
        securePreferences.edit().putString(BuildConfig.titleFavKey, title).apply()
    }

    /*
   write all getter below
    */

    fun getLocalTitle(): String {
        return securePreferences.getString(BuildConfig.titleFavKey, "") ?: ""
    }
}