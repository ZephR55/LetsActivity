package com.bekiraydemir.letsactivity.model
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize

class Books(val bookname:String,
            val author:String,
            val image: Int,
            val category:String
) :Parcelable
