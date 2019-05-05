package br.com.victor.victorutils

import android.support.constraint.ConstraintLayout
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.daimajia.androidanimations.library.Techniques
import com.daimajia.androidanimations.library.YoYo

//region Slide Left
fun ConstraintLayout.slideLeftAnimation(duration:Long = 700){
    try {
        val cl = this
        YoYo.with(Techniques.SlideInLeft)
                .duration(duration)
                .onStart {
                    cl.visibility = View.VISIBLE
                }
                .playOn(cl)
    } catch (e: Exception) {
    }
}

fun TextView.slideLeftAnimation(duration:Long = 700){
    try {
        val txtView = this
        YoYo.with(Techniques.SlideInLeft)
                .duration(duration)
                .onStart {
                    txtView.visibility = View.VISIBLE
                }
                .playOn(txtView)
    } catch (e: Exception) {
    }
}

fun EditText.slideLeftAnimation(duration:Long = 700){
    try {
        val edtTxt = this
        YoYo.with(Techniques.SlideInLeft)
                .duration(duration)
                .onStart {
                    edtTxt.visibility = View.VISIBLE
                }
                .playOn(edtTxt)
    } catch (e: Exception) {
    }
}

fun Button.slideLeftAnimation(duration:Long = 700){
    try {
        val btn = this
        YoYo.with(Techniques.SlideInLeft)
                .duration(duration)
                .onStart {
                    btn.visibility = View.VISIBLE
                }
                .playOn(btn)
    } catch (e: Exception) {
    }
}
//endregion

//region Slide Right
fun ConstraintLayout.slideRightAnimation(duration:Long = 700){
    try {
        val cl = this
        YoYo.with(Techniques.SlideInRight)
                .duration(duration)
                .onStart {
                    cl.visibility = View.VISIBLE
                }
                .playOn(cl)
    } catch (e: Exception) {
    }
}

fun TextView.slideRightAnimation(duration:Long = 700){
    try {
        val txtView = this
        YoYo.with(Techniques.SlideInRight)
                .duration(duration)
                .onStart {
                    txtView.visibility = View.VISIBLE
                }
                .playOn(txtView)
    } catch (e: Exception) {
    }
}

fun EditText.slideRightAnimation(duration:Long = 700){
    try {
        val edtTxt = this
        YoYo.with(Techniques.SlideInRight)
                .duration(duration)
                .onStart {
                    edtTxt.visibility = View.VISIBLE
                }
                .playOn(edtTxt)
    } catch (e: Exception) {
    }
}

fun Button.slideRightAnimation(duration:Long = 700){
    try {
        val btn = this
        YoYo.with(Techniques.SlideInRight)
                .duration(duration)
                .onStart {
                    btn.visibility = View.VISIBLE
                }
                .playOn(btn)
    } catch (e: Exception) {
    }
}
//endregion

//region Landing
fun ConstraintLayout.landingAnimation(duration:Long = 700){
    try {
        val cl = this
        YoYo.with(Techniques.Landing)
                .duration(duration)
                .onStart {
                    cl.visibility = View.VISIBLE
                }
                .playOn(cl)
    } catch (e: Exception) {
    }
}

fun TextView.landingAnimation(duration:Long = 700){
    try {
        val txtView = this
        YoYo.with(Techniques.Landing)
                .duration(duration)
                .onStart {
                    txtView.visibility = View.VISIBLE
                }
                .playOn(txtView)
    } catch (e: Exception) {

    }
}

fun EditText.landingAnimation(duration:Long = 700){
    try {
        val edtTxt = this
        YoYo.with(Techniques.Landing)
                .duration(duration)
                .onStart {
                    edtTxt.visibility = View.VISIBLE
                }
                .playOn(edtTxt)
    } catch (e: Exception) {
    }
}

fun Button.landingAnimation(duration:Long = 700){
    try {
        val btn = this
        YoYo.with(Techniques.Landing)
                .duration(duration)
                .onStart {
                    btn.visibility = View.VISIBLE
                }
                .playOn(btn)
    } catch (e: Exception) {
    }
}
//endregion

//region FadeIn
fun ConstraintLayout.fadeInAnimation(duration:Long = 700){
    try {
        val cl = this
        YoYo.with(Techniques.FadeIn)
                .duration(duration)
                .onStart {
                    cl.visibility = View.VISIBLE
                }
                .playOn(cl)
    } catch (e: Exception) {
    }
}

fun TextView.fadeInAnimation(duration:Long = 700){
    try {
        val txtView = this
        YoYo.with(Techniques.FadeIn)
                .duration(duration)
                .onStart {
                    txtView.visibility = View.VISIBLE
                }
                .playOn(txtView)
    } catch (e: Exception) {

    }
}

fun EditText.fadeInAnimation(duration:Long = 700){
    try {
        val edtTxt = this
        YoYo.with(Techniques.FadeIn)
                .duration(duration)
                .onStart {
                    edtTxt.visibility = View.VISIBLE
                }
                .playOn(edtTxt)
    } catch (e: Exception) {
    }
}

fun Button.fadeInAnimation(duration:Long = 700){
    try {
        val btn = this
        YoYo.with(Techniques.FadeIn)
                .duration(duration)
                .onStart {
                    btn.visibility = View.VISIBLE
                }
                .playOn(btn)
    } catch (e: Exception) {
    }
}
//endregion

//region FadeOut
fun ConstraintLayout.fadeOutAnimation(visibility: Int, duration:Long = 700){
    try {
        val cl = this
        YoYo.with(Techniques.FadeOut)
                .duration(duration)
                .onEnd {
                    cl.visibility = visibility
                }
                .playOn(cl)
    } catch (e: Exception) {
    }
}

fun TextView.fadeOutAnimation(visibility: Int, duration:Long = 700){
    try {
        val txtView = this
        YoYo.with(Techniques.FadeOut)
                .duration(duration)
                .onEnd {
                    txtView.visibility = visibility
                }
                .playOn(txtView)
    } catch (e: Exception) {
    }
}

fun EditText.fadeOutAnimation(visibility: Int, duration:Long = 700){
    try {
        val edtTxt = this
        YoYo.with(Techniques.FadeOut)
                .duration(duration)
                .onEnd {
                    edtTxt.visibility = visibility
                }
                .playOn(edtTxt)
    } catch (e: Exception) {
    }
}

fun Button.fadeOutAnimation(visibility: Int, duration:Long = 700){
    try {
        val btn = this
        YoYo.with(Techniques.FadeOut)
                .duration(duration)
                .onEnd {
                    btn.visibility = visibility
                }
                .playOn(btn)
    } catch (e: Exception) {
    }
}
//endregion