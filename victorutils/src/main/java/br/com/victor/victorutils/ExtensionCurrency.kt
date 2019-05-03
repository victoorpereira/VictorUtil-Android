package br.com.victor.victorutils

fun Double.toCurrency():String{
    val value = this.toFloat()
    return "R$ ${String.format("%.2f", value)}"
}

fun Float.toCurrency():String{
    val value = this.toFloat()
    return "R$ ${String.format("%.2f", value)}"
}

fun Int.toCurrency():String{
    val value = this.toFloat()
    return "R$ ${String.format("%.2f", value)}"
}