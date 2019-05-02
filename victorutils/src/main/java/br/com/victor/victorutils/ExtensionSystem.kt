package br.com.victor.victorutils

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import android.util.Base64
import android.util.Log
import android.view.inputmethod.InputMethodManager
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException

@SuppressLint("PackageManagerGetSignatures")
fun Context.getHash() {

    try {
        val info = this.packageManager.getPackageInfo(
                this.packageName,
                PackageManager.GET_SIGNATURES)
        for (signature in info.signatures) {
            val md = MessageDigest.getInstance("SHA")
            md.update(signature.toByteArray())
            Log.d("KeyHash:", Base64.encodeToString(md.digest(), Base64.DEFAULT))
            Log.d("KeyHash:", Base64.encodeToString(md.digest(), Base64.DEFAULT))
            Log.i("KeyHash:", Base64.encodeToString(md.digest(), Base64.DEFAULT))
        }
    } catch (e: PackageManager.NameNotFoundException) {
    } catch (e: NoSuchAlgorithmException) { }
}

fun Activity.hideKeyboard() {
    try {
        val inputManager = this.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputManager.hideSoftInputFromWindow(this.currentFocus!!.windowToken, InputMethodManager.HIDE_NOT_ALWAYS)
    } catch (e: Exception) {
        Log.e("hideKeyboard", e.toString(), e)
    }

}