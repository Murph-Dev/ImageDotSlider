package com.mmurphy.imagedotslider

import android.view.View

interface OnItemClickListener {
    fun onPagerItemClick(view: View, position: Int)
}