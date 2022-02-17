package com.example.myapplication

data class MyUrl(val data:Result,val status:Status){
    data class Result(val imgurl:String)
    data class Status(val code:Int)
}
