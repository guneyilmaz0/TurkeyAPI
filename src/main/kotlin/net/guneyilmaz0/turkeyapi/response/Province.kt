package net.guneyilmaz0.turkeyapi.response

import com.google.gson.Gson

data class Province(
     val id: Int,
     val name: String?,
     val population: Int,
     val area: Int,
     val altitude: Int,
     val areaCode: List<Int>,
     val isMetropolitan: Boolean,
     val nuts: Nuts,
     val coordinates: Map<String, Double>,
     val maps: Map<String, String>,
     val region: Map<String, String>,
     val districts: List<District>,
) {
    override fun toString(): String = Gson().toJson(this)
}
