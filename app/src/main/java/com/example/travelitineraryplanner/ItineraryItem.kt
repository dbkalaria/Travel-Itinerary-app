package com.example.travelitineraryplanner

import android.os.Parcel
import android.os.Parcelable

data class ItineraryItem(
    val day: String,
    val time: String,
    val activity: String,
    var done: Boolean = false
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readByte() != 0.toByte()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(day)
        parcel.writeString(time)
        parcel.writeString(activity)
        parcel.writeByte(if (done) 1 else 0)
    }

    override fun describeContents(): Int = 0

    companion object CREATOR : Parcelable.Creator<ItineraryItem> {
        override fun createFromParcel(parcel: Parcel): ItineraryItem = ItineraryItem(parcel)
        override fun newArray(size: Int): Array<ItineraryItem?> = arrayOfNulls(size)
    }
}
