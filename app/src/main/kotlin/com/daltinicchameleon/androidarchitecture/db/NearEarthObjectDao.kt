package com.daltinicchameleon.androidarchitecture.db

import android.arch.paging.DataSource
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.daltinicchameleon.androidarchitecture.model.NearEarthObject

/**
 * Created by pedrookawa on 22/01/2018.
 */

@Dao
interface NearEarthObjectDao {

    @Query("SELECT * FROM nearEarthObject")
    fun selectAll(): DataSource.Factory<Int, NearEarthObject>

    @Insert
    fun insert(nearEarthObjects: List<NearEarthObject>)

    @Insert
    fun insert(nearEarthObject: NearEarthObject)

}