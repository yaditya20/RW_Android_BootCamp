package com.adityayadav.moviemaniac.model

import android.os.Parcel
import android.os.Parcelable

data class MovieDAO(
    val id: Int,
    val title: String,
    val releaseDate: String,
    val summary: String,
    val poster: Int,
    val director: String,
    val ratings: Int
) : Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readInt(),
        parcel.readString()!!,
        parcel.readInt()
    )

    companion object CREATOR : Parcelable.Creator<MovieDAO> {
        override fun createFromParcel(source: Parcel): MovieDAO =
            MovieDAO(source)

        override fun newArray(size: Int): Array<MovieDAO?> = arrayOfNulls(size)
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeInt(id)
        dest.writeString(title)
        dest.writeString(releaseDate)
        dest.writeString(summary)
        dest.writeInt(poster)
        dest.writeString(director)
        dest.writeInt(ratings)
    }

    override fun describeContents(): Int = 0
}