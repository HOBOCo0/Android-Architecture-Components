package com.example.jetpackarcitecturecomponetspractice.databinding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide


// this is an extension function in Image view and by using the binding adapters we are this function
// as attribute in Image View and setting the image directly without downloading the image
@BindingAdapter("imageFromUrlll")
fun ImageView.ImageFromUrl(url:String){
    Glide.with(this.context).load(url).into(this)
}