package com.daltinicchameleon.androidarchitecture.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.daltinicchameleon.androidarchitecture.model.NearEarthObject

/**
 * Created by pedrookawa on 22/01/2018.
 */

@Database(entities = arrayOf(NearEarthObject::class), version = 1)
abstract class AppDatabase: RoomDatabase() {

    abstract fun nearEarthObjectDao(): NearEarthObjectDao

}