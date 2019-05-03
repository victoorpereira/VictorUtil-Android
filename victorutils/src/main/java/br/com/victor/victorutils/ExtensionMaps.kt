package br.com.victor.victorutils

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.widget.Toast

fun Activity.openNavigation(latitude:String, longitude:String){
    try {
        val uri = "google.navigation:q=$latitude,$longitude"
        startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(uri)).setPackage("com.google.android.apps.maps"))
    } catch (ex: Exception) {
        try {
            val uri = "geo:$latitude,$longitude"
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(uri)))
        } catch (e2: Exception) {
            Toast.makeText(this, "Não é possivel abrir o Google Maps.", Toast.LENGTH_SHORT).show()
        }
    }
}

fun Activity.openMaps(latitude:String,longitude:String){
    try {
        val uri = "geo:$latitude,$longitude"
        startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(uri)))
    } catch (e2: Exception) {
        Toast.makeText(this, "Não é possivel abrir o Waze.", Toast.LENGTH_SHORT).show()
    }
}

fun Activity.openWaze(latitude:String,longitude:String){
    try {
        val uri = "waze://?ll=$latitude,$longitude"
        startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(uri)))
    } catch (ex: Exception) {
        openMaps(latitude,longitude)
    }
}

inline fun Activity.openGoogleMaps(latitude:String,longitude:String) = openGoogleMaps(latitude,longitude,"")
fun Activity.openGoogleMaps(latitude:String,longitude:String,query:String){
    try {
        if(query.isEmpty()){
            val uri = "geo:$latitude,$longitude?z=19"
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(uri)).setPackage("com.google.android.apps.maps"))
        }else{
            val uri = "geo:$latitude,$longitude?q=" + Uri.encode(query)
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(uri)).setPackage("com.google.android.apps.maps"))
        }
    } catch (ex: Exception) {
        openMaps(latitude,longitude)
    }
}

fun Activity.openGoogleStreetView(latitude:String,longitude:String){
    try {
        val uri = "google.streetview:cbll=$latitude,$longitude"
        startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(uri)).setPackage("com.google.android.apps.maps"))
    } catch (e: Exception) {
        openMaps(latitude,longitude)
    }
}