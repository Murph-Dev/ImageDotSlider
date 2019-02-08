package com.mmurphy.imagedotslider

import android.widget.FrameLayout
import androidx.viewpager.widget.ViewPager
import android.widget.AdapterView.OnItemClickListener
import android.content.Context
import com.google.android.material.tabs.TabLayout
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.annotation.ArrayRes
import androidx.annotation.NonNull
import androidx.annotation.Size


class ImageSliderView : FrameLayout {


    private var mViewPager: ViewPager? = null
    private var mViewPagerAdapter: ImageViewPagerAdapter? = null
    private var mOnSetImageListener: OnSetImageListener? = null
    private lateinit var mOnPageChangeListener: ViewPager.OnPageChangeListener


    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init(context, attrs)
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init(context, attrs)
    }


    private fun init(context: Context, attrs: AttributeSet?) {
        LayoutInflater.from(context).inflate(R.layout.image_slider_view, this)
        mViewPager = findViewById(R.id.view_pager) as ViewPager
        mViewPagerAdapter = ImageViewPagerAdapter(context, mOnSetImageListener)
        if (!isInEditMode)
            if (attrs != null) {
                val typedArray = context.obtainStyledAttributes(
                    attrs, R.styleable.ImageSliderView, 0,
                    0
                )
                val id = typedArray.getResourceId(R.styleable.ImageSliderView_imageResources, 0)
                if (id != 0) {
                    val typed = context.getResources().obtainTypedArray(id)
                    val drawables = IntArray(typed.length())
                    for (i in drawables.indices) {
                        drawables[i] = typed.getResourceId(i, 0)
                    }
                    typed.recycle()
                    mViewPagerAdapter!!.setImageResources(drawables)
                }
                typedArray.recycle()
            }
        mViewPager!!.adapter = mViewPagerAdapter
        val tabLayout = findViewById<TabLayout>(R.id.tabDots) as TabLayout
        tabLayout.setupWithViewPager(mViewPager, true)
    }

    fun setImageResources(@NonNull @ArrayRes @Size(min = 2) imageResources: IntArray) {
        mViewPagerAdapter!!.setImageResources(imageResources)
    }


    fun setOnShowImageListener(onShowImageListener: OnSetImageListener) {
        mOnSetImageListener = onShowImageListener
    }

    fun setOnItemClickListener(onItemClickListener: com.mmurphy.imagedotslider.OnItemClickListener) {
        mViewPagerAdapter!!.setOnPagerItemClick(onItemClickListener)
    }

    fun addOnPageChangeListener(onPageChangeListener: ViewPager.OnPageChangeListener) {
        mOnPageChangeListener = onPageChangeListener
        mViewPager!!.addOnPageChangeListener(mOnPageChangeListener)
    }

    fun removeOnPageChangeListener() {
        mViewPager!!.removeOnPageChangeListener(mOnPageChangeListener)
    }

}
