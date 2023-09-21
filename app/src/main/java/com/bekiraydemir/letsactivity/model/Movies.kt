package com.bekiraydemir.letsactivity.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize

data class Movies(
    val moviename:String,
    val releasedate:String,
    val image: Int,
    val category:String
) : Parcelable