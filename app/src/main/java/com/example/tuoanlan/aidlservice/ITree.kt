package com.example.tuoanlan.aidlservice

import android.os.Parcel
import android.os.Parcelable


class ITree(var name: String? = null) : Parcelable {
    constructor(source: Parcel) : this(
            source.readString()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(name)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<ITree> = object : Parcelable.Creator<ITree> {
            override fun createFromParcel(source: Parcel): ITree = ITree(source)
            override fun newArray(size: Int): Array<ITree?> = arrayOfNulls(size)
        }
    }
}