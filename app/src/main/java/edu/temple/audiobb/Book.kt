package edu.temple.audiobb

import android.os.Parcelable
import android.os.Parcel
import android.os.Parcelable.Creator

class Book : Parcelable {

    var id: Int
    var title: String?
    var author: String?
    var cover: String?
    var length: Int

    constructor(id: Int, title: String?, author: String?, coverUrl: String?, duration:Int) {

        this.id = id
        this.title = title
        this.author = author
        this.cover = coverUrl
        this.length = duration

    }

    protected constructor(`in`: Parcel) {

        id = `in`.readInt()
        title = `in`.readString()
        author = `in`.readString()
        cover = `in`.readString()
        length = `in`.readInt()

    }

    override fun describeContents(): Int {

        return 0

    }

    override fun writeToParcel(parcel: Parcel, i: Int) {

        parcel.writeInt(id)
        parcel.writeString(title)
        parcel.writeString(author)
        parcel.writeString(cover)
        parcel.writeInt(length)

    }

    override fun toString(): String {

        return "Book ID: "+this.id + " Title: "+this.title + " Author: "+this.author

    }

    companion object {

        @JvmField
        val CREATOR: Creator<Book?> = object : Creator<Book?> {

            override fun createFromParcel(`in`: Parcel): Book? {

                return Book(`in`)
            }

            override fun newArray(size: Int): Array<Book?> {

                return arrayOfNulls(size)
            }

        }
    }
}