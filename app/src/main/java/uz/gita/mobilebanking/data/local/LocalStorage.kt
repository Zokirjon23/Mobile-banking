package uz.gita.mobilebanking.data.local

import android.content.Context
import android.content.SharedPreferences
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocalStorage @Inject constructor(
    @ApplicationContext private val context: Context
) {
    private val pref: SharedPreferences =
        context.getSharedPreferences("LocaleStorage", Context.MODE_PRIVATE)

    fun clearData() {
        pref.edit().clear().apply()
    }

    var token: String?
        get() {
            return pref.getString("token", null)
        }
        set(value) {
            pref.edit().putString("token", value).apply()
        }
}