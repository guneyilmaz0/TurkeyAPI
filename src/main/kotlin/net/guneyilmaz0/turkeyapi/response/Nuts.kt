package net.guneyilmaz0.turkeyapi.response

import com.google.gson.Gson

data class Nuts(val nuts1: Nuts1, val nuts2: Nuts2, val nuts3: String) {

    class Nuts1(val code: String, val name: Map<String, String>) {
        override fun toString(): String = Gson().toJson(this)
    }

    class Nuts2(val code: String, val name: String) {
        override fun toString(): String = Gson().toJson(this)
    }
}