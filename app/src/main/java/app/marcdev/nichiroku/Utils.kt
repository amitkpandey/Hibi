package app.marcdev.nichiroku

import android.text.format.DateFormat
import java.util.*

fun formatDateForDisplay(calendar: Calendar): String {
  val datePattern = DateFormat.getBestDateTimePattern(Locale.getDefault(), "EEEdMMMMyyyy")
  val formattedDate = DateFormat.format(datePattern, calendar)
  return formattedDate.toString()
}

fun formatDateForDisplay(day: Int, month: Int, year: Int): String {
  val calendar = Calendar.getInstance()
  calendar.set(Calendar.DAY_OF_MONTH, day)
  calendar.set(Calendar.MONTH, month)
  calendar.set(Calendar.YEAR, year)
  return formatDateForDisplay(calendar)
}

fun formatTimeForDisplay(calendar: Calendar): String {
  val timePattern = DateFormat.getBestDateTimePattern(Locale.getDefault(), "HHmm")
  val formattedTime = DateFormat.format(timePattern, calendar)
  return formattedTime.toString()
}

fun formatTimeForDisplay(hour: Int, minute: Int): String {
  val calendar = Calendar.getInstance()
  calendar.set(Calendar.HOUR_OF_DAY, hour)
  calendar.set(Calendar.MINUTE, minute)
  return formatTimeForDisplay(calendar)
}