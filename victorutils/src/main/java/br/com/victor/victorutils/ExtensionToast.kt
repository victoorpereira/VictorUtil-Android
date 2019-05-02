package br.com.victor.victorutils

import android.content.Context
import android.util.Log
import android.widget.Toast

private var TAG: String = "ExtensionToast"

fun Context.toast(message: CharSequence) {
    try {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    } catch (e: Exception) {
        Log.e(TAG, "toast String $e")
    }
}

fun Context.toast(message: Int) {
    try {
        Toast.makeText(this, message.toString(), Toast.LENGTH_SHORT).show()
    } catch (e: Exception) {
        Log.e(TAG, "toast Int $e")
    }
}

fun Context.longToast(message: CharSequence) {
    try {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    } catch (e: Exception) {
        Log.e(TAG, "longToast String $e")
    }
}

fun Context.longToast(message: Int) {
    try {
        Toast.makeText(this, message.toString(), Toast.LENGTH_LONG).show()
    } catch (e: Exception) {
        Log.e(TAG, "longToast Int $e")
    }
}