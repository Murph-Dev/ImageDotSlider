package com.mmurphy.imagedotslider

import android.widget.ImageView

interface OnSetImageListener {
    fun setImage(imageView: ImageView, position: Int)
}
