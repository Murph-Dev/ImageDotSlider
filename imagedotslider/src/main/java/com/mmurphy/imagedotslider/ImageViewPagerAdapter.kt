package com.mmurphy.imagedotslider

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import androidx.annotation.ArrayRes
import androidx.annotation.NonNull
import androidx.annotation.Size


class ImageViewPagerAdapter(private val mContext: Context, @param:NonNull private val mOnSetImageListener: OnSetImageListener?) :
    ViewPagerAdapter() {

    private var mOnPagerItemClick: com.mmurphy.imagedotslider.OnItemClickListener? = null
    private var mImageResources: IntArray? = null



    override fun getCount(): Int {
        return mImageResources!!.size
    }


    init {
        mImageResources = intArrayOf()
    }

    override fun getItem(position: Int): View {
        val imageView = LayoutInflater.from(mContext).inflate(R.layout.view_pager_image, null) as ImageView
        imageView.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View) {
                if (mOnPagerItemClick != null) {
                    mOnPagerItemClick!!.onPagerItemClick(v, position)
                }
            }
        })
        if (mOnSetImageListener != null) {

            mOnSetImageListener.setImage(imageView, position)
        } else {

            imageView.setImageResource(mImageResources!![position])
        }
        return imageView
    }

    fun setImageResources(@NonNull @ArrayRes @Size(min = 2) imageResources: IntArray) {
        mImageResources = imageResources
        notifyDataSetChanged()
    }

    fun setOnPagerItemClick(@NonNull onPagerItemClickListener: com.mmurphy.imagedotslider.OnItemClickListener) {
        mOnPagerItemClick = onPagerItemClickListener
    }
}