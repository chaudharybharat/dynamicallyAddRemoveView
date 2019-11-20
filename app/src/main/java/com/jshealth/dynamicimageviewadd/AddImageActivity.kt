package com.jshealth.dynamicimageviewadd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_add_image.*

class AddImageActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_image)
        btn_remove.setOnClickListener {
            var count=rl_imgs.childCount
            if(count>0){
                rl_imgs.removeViewAt(count-1)
            }
        }
       btn_add.setOnClickListener {
           var count=rl_imgs.childCount
           Log.e("test","count=>"+count)
           if(count>5){
               Toast.makeText(this,"Item not avaliable",Toast.LENGTH_LONG).show()
               return@setOnClickListener
           }
           val iv = ImageView(this)
           when(count){
               0->{
                   iv.setImageDrawable(resources.getDrawable(R.drawable.image1))

               }
               1->{
                   iv.setImageDrawable(resources.getDrawable(R.drawable.image2))
               }
               2->{
                   iv.setImageDrawable(resources.getDrawable(R.drawable.image4))

               }
               3->{
                   iv.setImageDrawable(resources.getDrawable(R.drawable.image3))

               }
               4->{
                   iv.setImageDrawable(resources.getDrawable(R.drawable.image5))

               }
               else ->{
                   iv.setImageDrawable(resources.getDrawable(R.drawable.image1))

               }
           }
           // Create layout parameters for ImageView
           var relativeLayout=RelativeLayout(this)
           val primary_layout = RelativeLayout(this)
           val layoutParam = RelativeLayout.LayoutParams(
               RelativeLayout.LayoutParams.MATCH_PARENT,
               RelativeLayout.LayoutParams.MATCH_PARENT
           )
           iv.layoutParams=layoutParam
          // relativeLayout.addView(iv)
           rl_imgs.addView(iv,count)
       }
    }
}
