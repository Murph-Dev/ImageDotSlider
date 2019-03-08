package com.mmurphy.imagedotslidersample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.viewpager.widget.ViewPager
import kotlinx.android.synthetic.main.activity_main.*

/****** 1.) Extend ViewPager.OnPageChangeListener so we can listen for scrolls and clicks ******/
class MainActivity : AppCompatActivity(), ViewPager.OnPageChangeListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /****** 2.) Set the listener for the image slider ******/
        image_slider.addOnPageChangeListener(this)
    }

    /****** 3.) Override the required functions ******/
    // Listener for Scrolling State Changes
    override fun onPageScrollStateChanged(state: Int) {
        Log.d("OnPageScrollStateChange", "$state")
    }

    // Listener for Page Scrolling
    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
        Log.d("OnPageScrolled", "$position")
    }

    // Listener for Page Clicks
    override fun onPageSelected(position: Int) {
        Log.d("OnPageSelected", "$position")
    }
}
