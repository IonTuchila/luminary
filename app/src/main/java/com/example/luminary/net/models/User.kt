package com.example.luminary.net.models

import android.os.Parcel
import android.os.Parcelable

class User(
    var name: Name?,
    var picture: Picture?
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readParcelable(Name::class.java.classLoader),
        parcel.readParcelable(Picture::class.java.classLoader)
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeParcelable(name, flags)
        parcel.writeParcelable(picture, flags)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<User> {
        override fun createFromParcel(parcel: Parcel): User {
            return User(parcel)
        }

        override fun newArray(size: Int): Array<User?> {
            return arrayOfNulls(size)
        }
    }
}