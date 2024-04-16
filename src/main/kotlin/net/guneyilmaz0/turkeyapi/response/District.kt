package net.guneyilmaz0.turkeyapi.response

import com.google.gson.Gson

data class District(val id: Int, val name: String, val population: Int, val area: Int) {
    override fun toString(): String = Gson().toJson(this)
}
