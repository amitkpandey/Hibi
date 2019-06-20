package app.marcdev.hibi.internal.utils

import android.content.Context
import android.preference.PreferenceManager
import app.marcdev.hibi.R
import app.marcdev.hibi.internal.PREF_DARK_THEME

class ThemeUtilsImpl(private val context: Context) : ThemeUtils {
  override fun isLightMode(): Boolean {
    return !(PreferenceManager.getDefaultSharedPreferences(context.applicationContext).getBoolean(PREF_DARK_THEME, true))
  }

  override fun getAccentColor(): Int {
    return if(isLightMode())
      context.resources.getColor(R.color.lightThemeColorAccent, null)
    else
      context.resources.getColor(R.color.darkThemeColorAccent, null)
  }
}