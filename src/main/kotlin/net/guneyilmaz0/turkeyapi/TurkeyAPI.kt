package net.guneyilmaz0.turkeyapi

import com.google.gson.Gson
import net.guneyilmaz0.turkeyapi.response.District
import net.guneyilmaz0.turkeyapi.response.Province
import net.guneyilmaz0.turkeyapi.response.Response
import net.guneyilmaz0.turkeyapi.response.ResponseCode
import org.jetbrains.annotations.NotNull
import java.io.IOException
import java.net.HttpURLConnection
import java.net.URI
import java.util.*

@Suppress("unused")
class TurkeyAPI {
    companion object {
        @JvmStatic
        fun getDistrictByName(@NotNull provinceName: String, @NotNull districtName: String): District {
            val province = getProvinceByName(provinceName)
            val finalDistrictName = districtName.lowercase(Locale.getDefault())
            return province.districts.stream().filter { district: District ->
                district.name.lowercase(
                    Locale.getDefault()
                ) == finalDistrictName
            }.findFirst().orElse(null)
        }

        @Throws(IOException::class)
        @JvmStatic
        fun getProvinceByName(@NotNull name: String): Province {
            val url = URI("https://turkiyeapi.dev/api/v1/provinces?name=" + name.lowercase()).toURL()
            val connection = (url.openConnection() as HttpURLConnection).apply {
                requestMethod = "GET"
            }
            val responseCode = connection.responseCode
            if (responseCode != 200) throw RuntimeException(ResponseCode.getByCode(responseCode).message)

            val responseBody = connection.inputStream.bufferedReader().use { it.readText() }

            val response = Gson().fromJson(responseBody, Response::class.java)
            return response.data[0]
        }
    }
    fun x(){
        val province = getProvinceByName("Antalya")
        val district = getDistrictByName("Antalya", "Muratpaşa")
        print(province.id)
        print(district.id)
    }
}
