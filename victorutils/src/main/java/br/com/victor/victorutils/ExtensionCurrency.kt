package br.com.victor.victorutils

fun Double.toCurrency():String{
    try {
        val value = this.toFloat()
        return "R$ ${String.format("%.2f", value)}"
    } catch (e: Exception) {
        return ""
    }
}

fun Float.toCurrency():String{
    try {
        val value = this.toFloat()
        return "R$ ${String.format("%.2f", value)}"
    } catch (e: Exception) {
        return ""
    }
}

fun Int.toCurrency():String{
    try {
        val value = this.toFloat()
        return "R$ ${String.format("%.2f", value)}"
    } catch (e: Exception) {
        return ""
    }
}