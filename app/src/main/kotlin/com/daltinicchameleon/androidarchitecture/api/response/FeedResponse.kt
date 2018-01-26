package com.daltinicchameleon.androidarchitecture.api.response

import com.daltinicchameleon.androidarchitecture.model.NearEarthObject
import com.google.gson.annotations.SerializedName

/**
 * Created by pedrookawa on 22/01/2018.
 */

class FeedResponse {

    @SerializedName("element_count")
    var count: Int = 0
    @SerializedName("near_earth_objects")
    var nearEarthObjects: HashMap<String, List<NearEarthObject>>? = null

}