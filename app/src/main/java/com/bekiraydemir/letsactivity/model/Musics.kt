package com.bekiraydemir.letsactivity.model
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize

class Musics(val musicname:String,
             val singer:String,
             val image:Int,
             val category:String
) : Parcelable
