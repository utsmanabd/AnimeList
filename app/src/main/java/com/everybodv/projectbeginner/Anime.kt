package com.everybodv.projectbeginner

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Anime(
    val name: String,
    val rating: String,
    val genres: String,
    val description: String,
    val photo: String,
    val status: String,
    val episode: String
) : Parcelable