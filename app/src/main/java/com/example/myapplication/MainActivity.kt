package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val appService=network.retrofit.create(ImageService::class.java)
        mw1024btn.setOnClickListener {
            showImage(appService,"mw1024")
        }
        mw690btn.setOnClickListener {
            showImage(appService,"mw690")
        }
        bmiddleBtn.setOnClickListener {
            showImage(appService,"bmiddle")
        }
        smallBtn.setOnClickListener {
            showImage(appService,"small")
        }
        thumbnail.setOnClickListener {
            showImage(appService,"thumbnail")
        }
        thumb180.setOnClickListener {
            showImage(appService,"thumb180")
        }
        squareBtn.setOnClickListener {
            showImage(appService,"square")
        }
    }
    fun showImage(appService:ImageService,str:String){
        appService.getImage(str).enqueue(object :Callback<MyUrl>{
            override fun onFailure(call: Call<MyUrl>, t: Throwable) {
                t.printStackTrace()
            }

            override fun onResponse(call: Call<MyUrl>, response: Response<MyUrl>) {
                val body=response.body()
                if (body!=null){
                    Glide.with(this@MainActivity).load(body.data.imgurl).into(image)

                }
            }
        })
    }
}