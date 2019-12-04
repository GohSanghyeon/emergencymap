package com.example.emergencymap

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.viewpager.widget.PagerAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget
import kotlinx.android.synthetic.main.activity_education_list.*

class EmergencyEducationList : AppCompatActivity() {

    private var viewList : ArrayList<View> = ArrayList<View>()
    private val imagesAED = listOf(R.raw.aed1, R.raw.aed2, R.raw.aed2)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_education_list)

        imagesAED.forEach {idRawImage ->
            val nowView = layoutInflater.inflate(R.layout.activity_short_education, null)
            val imgView = nowView.findViewById<ImageView>(R.id.viewEducationImage)
            val canvas = GlideDrawableImageViewTarget(imgView)

            Glide.with(applicationContext).load(idRawImage).into(canvas)
            viewList.add(nowView)
        }

        pagerEducation.adapter = PagerEducationAdapter()
    }

    inner class PagerEducationAdapter : PagerAdapter() {
        override fun isViewFromObject(view: View, obj: Any): Boolean {
            return view == obj
        }

        override fun getCount(): Int {
            return viewList.size
        }

        override fun instantiateItem(container: ViewGroup, position: Int): Any {
            var temp = viewList[position]
            container.addView(temp)

            return viewList[position]
        }

        override fun destroyItem(container: ViewGroup, position: Int, obj: Any) {
            pagerEducation.removeView(obj as View)
        }
    }
}