package com.daltinicchameleon.androidarchitecture.model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.google.gson.annotations.SerializedName

/**
 * Created by pedrookawa on 22/01/2018.
 */

@Entity
class NearEarthObject {

    @PrimaryKey
    @SerializedName("neo_reference_id")
    var referenceId: String = ""

    var name: String = ""

    @SerializedName("nasa_jpl_url")
    var url: String = ""

    @ColumnInfo(name = "absolute_magnitude")
    @SerializedName("absolute_magnitude_h")
    var absoluteMagnitude: Float = 0.0f

    @ColumnInfo(name = "is_hazardous")
    @SerializedName("is_potentially_hazardous_asteroid")
    var isHazardous: Boolean = false

    @ColumnInfo(name = "date")
    var date: String = ""

    class Diameter {

        @SerializedName("kilometers")
        var kilometers: Measure? = null

        @SerializedName("meters")
        var meters: Measure? = null

        @SerializedName("miles")
        var miles: Measure? = null

        @SerializedName("feet")
        var feet: Measure? = null

    }

    class Measure {

        @SerializedName("estimated_diameter_min")
        var min: Double = 0.0

        @SerializedName("estimated_diameter_max")
        var max: Double = 0.0
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as NearEarthObject

        if (referenceId != other.referenceId) return false

        return true
    }

    override fun hashCode(): Int {
        return referenceId.hashCode()
    }


}