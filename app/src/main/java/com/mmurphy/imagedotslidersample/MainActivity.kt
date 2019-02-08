package com.mmurphy.imagedotslidersample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.viewpager.widget.ViewPager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), ViewPager.OnPageChangeListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        image_slider.addOnPageChangeListener(this)
    }

    override fun onPageScrollStateChanged(state: Int) {
        Log.d("OnPageScrollStateChange", "$state")
    }

    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
        Log.d("OnPageScrolled", "$position")
    }

    override fun onPageSelected(position: Int) {
        Log.d("OnPageSelected", "$position")
    }
}
