package br.com.victor.victorutils

import android.opengl.Visibility
import android.support.constraint.ConstraintLayout
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.daimajia.androidanimations.library.Techniques
import com.daimajia.androidanimations.library.YoYo

fun ConstraintLayout.slideAnimation(){
    try {
        val cl = this
        YoYo.with(Techniques.SlideInLeft)
                .duration(700)
                .onStart {
                    cl.visibility = View.VISIBLE
                }
                .playOn(cl)
    } catch (e: Exception) {
    }
}

fun TextView.slideAnimation(){
    try {
        val txtView = this
        YoYo.with(Techniques.SlideInLeft)
                .duration(700)
                .onStart {
                    txtView.visibility = View.VISIBLE
                }
                .playOn(txtView)
    } catch (e: Exception) {
    }
}

fun EditText.slideAnimation(){
    try {
        val edtTxt = this
        YoYo.with(Techniques.SlideInLeft)
                .duration(700)
                .onStart {
                    edtTxt.visibility = View.VISIBLE
                }
                .playOn(edtTxt)
    } catch (e: Exception) {
    }
}

fun Button.slideAnimation(){
    try {
        val btn = this
        YoYo.with(Techniques.SlideInLeft)
                .duration(700)
                .onStart {
                    btn.visibility = View.VISIBLE
                }
                .playOn(btn)
    } catch (e: Exception) {
    }
}

fun ConstraintLayout.landingAnimation(){
    try {
        val cl = this
        YoYo.with(Techniques.Landing)
                .duration(700)
                .onStart {
                    cl.visibility = View.VISIBLE
                }
                .playOn(cl)
    } catch (e: Exception) {
    }
}

fun TextView.landingAnimation(){
    try {
        val txtView = this
        YoYo.with(Techniques.Landing)
                .duration(700)
                .onStart {
                    txtView.visibility = View.VISIBLE
                }
                .playOn(txtView)
    } catch (e: Exception) {

    }
}

fun EditText.landingAnimation(){
    try {
        val edtTxt = this
        YoYo.with(Techniques.Landing)
                .duration(700)
                .onStart {
                    edtTxt.visibility = View.VISIBLE
                }
                .playOn(edtTxt)
    } catch (e: Exception) {
    }
}

fun Button.landingAnimation(){
    try {
        val btn = this
        YoYo.with(Techniques.Landing)
                .duration(700)
                .onStart {
                    btn.visibility = View.VISIBLE
                }
                .playOn(btn)
    } catch (e: Exception) {
    }
}

fun ConstraintLayout.fadeInAnimation(){
    try {
        val cl = this
        YoYo.with(Techniques.FadeIn)
                .duration(700)
                .onStart {
                    cl.visibility = View.VISIBLE
                }
                .playOn(cl)
    } catch (e: Exception) {
    }
}

fun TextView.fadeInAnimation(){
    try {
        val txtView = this
        YoYo.with(Techniques.FadeIn)
                .duration(700)
                .onStart {
                    txtView.visibility = View.VISIBLE
                }
                .playOn(txtView)
    } catch (e: Exception) {

    }
}

fun EditText.fadeInAnimation(){
    try {
        val edtTxt = this
        YoYo.with(Techniques.FadeIn)
                .duration(700)
                .onStart {
                    edtTxt.visibility = View.VISIBLE
                }
                .playOn(edtTxt)
    } catch (e: Exception) {
    }
}

fun Button.fadeInAnimation(){
    try {
        val btn = this
        YoYo.with(Techniques.FadeIn)
                .duration(700)
                .onStart {
                    btn.visibility = View.VISIBLE
                }
                .playOn(btn)
    } catch (e: Exception) {
    }
}

fun ConstraintLayout.fadeOutAnimation(visibility: Int){
    try {
        val cl = this
        YoYo.with(Techniques.FadeOut)
                .duration(400)
                .onEnd {
                    cl.visibility = visibility
                }
                .playOn(cl)
    } catch (e: Exception) {
    }
}

fun TextView.fadeOutAnimation(visibility: Int){
    try {
        val txtView = this
        YoYo.with(Techniques.FadeOut)
                .duration(400)
                .onEnd {
                    txtView.visibility = visibility
                }
                .playOn(txtView)
    } catch (e: Exception) {
    }
}

fun EditText.fadeOutAnimation(visibility: Int){
    try {
        val edtTxt = this
        YoYo.with(Techniques.FadeOut)
                .duration(400)
                .onEnd {
                    edtTxt.visibility = visibility
                }
                .playOn(edtTxt)
    } catch (e: Exception) {
    }
}

fun Button.fadeOutAnimation(visibility: Int){
    try {
        val btn = this
        YoYo.with(Techniques.FadeOut)
                .duration(400)
                .onEnd {
                    btn.visibility = visibility
                }
                .playOn(btn)
    } catch (e: Exception) {
    }
}