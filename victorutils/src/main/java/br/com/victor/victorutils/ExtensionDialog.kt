package br.com.victor.victorutils

import android.app.Activity
import android.app.AlertDialog
import android.content.DialogInterface
import android.util.Log

private var TAG: String = "ExtensionDialog"

fun Activity.showDialog(title: String, message: String) {
    try {

        val builder = AlertDialog.Builder(this, R.style.AppTheme_AlertDialog)
        builder.setTitle(title).setMessage(message)
                .setPositiveButton("OK", DialogInterface.OnClickListener { dialog, id ->
                    dialog.dismiss()
                })
        builder.create().show()
    } catch (e: Exception) {
        // Ignore exceptions if any
        Log.e(TAG, e.toString(), e)
    }

}

fun Activity.showDialog(title: String, message: String, callback: (dialog: DialogInterface) -> Unit) {
    try {

        val builder = AlertDialog.Builder(this, R.style.AppTheme_AlertDialog)
        builder.setTitle(title).setMessage(message)
                .setPositiveButton("OK", DialogInterface.OnClickListener { dialog, id ->
                    if (callback != null)
                        callback(dialog)
                    else
                        dialog.dismiss()
                })
        builder.create().show()
    } catch (e: Exception) {
        // Ignore exceptions if any
        Log.e(TAG, e.toString(), e)
    }
}

//colocar tema
fun Activity.showDialog(title: String, message: String, positive: String, negative: String, callback: (positive: Boolean, negative: Boolean, dialog: DialogInterface) -> Unit) {
    try {

        val builder = AlertDialog.Builder(this, R.style.AppTheme_AlertDialog)
        builder.setTitle(title).setMessage(message)
                .setPositiveButton(positive, DialogInterface.OnClickListener { dialog, id ->
                    if (callback != null)
                        callback(true, false, dialog)
                    else
                        dialog.dismiss()
                })
                .setNegativeButton(negative, DialogInterface.OnClickListener { dialog, id ->
                    if (callback != null)
                        callback(false, true, dialog)
                    else
                        dialog.dismiss()
                })
        builder.create().show()
    } catch (e: Exception) {
        // Ignore exceptions if any
        Log.e(TAG, e.toString(), e)
    }
}

fun Activity.showDialog(message: String) = showDialog("", message)

fun Activity.showDialog(errors: List<String>) {

    try {
        var errosString = ""
        var i = 0
        while (i < errors.size){
            if(i == errors.size - 1){
                errosString += errors[i]
            }else{
                errosString += "${errors[i]}\n"
            }
            i++
        }

        showDialog("", errosString)
    } catch (e: Exception) {
        Log.e(TAG, e.toString(), e)
    }
}

fun Activity.showDialog(title: String, errors: List<String>) {

    try {
        var errosString = ""
        var i = 0
        while (i < errors.size){
            if(i == errors.size - 1){
                errosString += errors[i]
            }else{
                errosString += "${errors[i]}\n"
            }
            i++
        }

        showDialog(title, errosString)
    } catch (e: Exception) {
        Log.e(TAG, e.toString(), e)
    }
}