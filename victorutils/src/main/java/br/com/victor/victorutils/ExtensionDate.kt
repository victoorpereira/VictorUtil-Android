package br.com.victor.victorutils

import java.text.SimpleDateFormat
import java.util.*

enum class UtilsDateFormats(val dateFormat: String) {
    ddMMyyyy("dd/MM/yyyy"),
    HHmmss("HH:mm:ss"),
    HHmm("HH:mm"),
    ddMMyyyyHHmmss("dd/MM/yyyy HH:mm:ss"),
    dddeMMMdeyyyy("dd 'de' MMM 'de' yyyy"),
    dddeMMMdeyyyyasHHmm("dd 'de' MMM 'de' yyyy 'às' HH:mm"),
    ddMMyyyyasHHmm("dd/MM/yyyy 'às' HH:mm")
}

fun ISOFORMAT(date:String, dateFormat: UtilsDateFormats) : String {

    try {
        val toISO = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssX")
        val isoDate = toISO.parse(date)
        val formatTo = SimpleDateFormat(dateFormat.dateFormat, Locale.getDefault())

        return formatTo.format(isoDate)
    } catch (e: Exception) {
        return e.toString()
    }
}

fun ISOFORMAT(date:String, dateFormat: String): String {
    try {
        val toISO = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssX")
        val isoDate = toISO.parse(date)
        val formatTo = SimpleDateFormat(dateFormat, Locale.getDefault())

        return formatTo.format(isoDate)
    } catch (e: Exception) {
        return e.toString()
    }
}

fun ISOFORMATtoDATE(date:String): Date? {
    try {
        val toISO = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssX", Locale.getDefault())
        val isoDate = toISO.parse(date)

        return isoDate
    } catch (e: Exception) {
        return null
    }
}