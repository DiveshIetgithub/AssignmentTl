package com.example.myassignment.roomdb

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.vo.Database

@Database(entities = [Student::class], version = 6)
abstract class DataBaseStudent(): RoomDatabase(), android.os.Parcelable, android.os.Parcelable {
    constructor(parcel:android.os.Parcel) : this() {
    }

    constructor(parcel:android.os.Parcel) : this() {
    }

    abstract  fun studentdao():StudentDao
    companion object {
        @Volatile
        var INSTECE: DataBaseStudent? = null
        fun myobjct(context:Context): DataBaseStudent {
            var intence = INSTECE
            synchronized(this) {
                if (intence == null) {
                    intence=Room.databaseBuilder(context, DataBaseStudent::class.java, "HemantDb1")
                        .build()
                    INSTECE = intence
                }

            }
            return INSTECE!!

        }
    }

    override fun writeToParcel(parcel:android.os.Parcel, flags:Int) {

    }

    override fun describeContents():Int {
        return 0
    }

    companion object CREATOR : android.os.Parcelable.Creator<DataBaseStudent> {
        override fun createFromParcel(parcel:android.os.Parcel):DataBaseStudent {
            return DataBaseStudent(parcel)
        }

        override fun newArray(size:Int):Array<DataBaseStudent?> {
            return arrayOfNulls(size)
        }
    }

    override fun writeToParcel(parcel:android.os.Parcel, flags:Int) {

    }
}
