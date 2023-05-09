package com.example.grzegorzbrzeczysczykiewicz

import com.squareup.moshi.Json

class ApiResponse {
    @Json(name = "results")
    lateinit var guesserItemsList: List<GuesserInfo>
}

class GuesserInfo {
    @Json(name = "name")
    var name: String = ""

    @Json(name = "height")
    var height: String = ""

    @Json(name = "mass")
    var mass: String = ""

    @Json(name = "hair_color")
    var hair_color: String = ""

    @Json(name = "skin_color")
    var skin_color: String = ""

    @Json(name = "eye_color")
    var eye_color: String = ""

    @Json(name = "birth_year")
    var birth_year: String = ""

    @Json(name = "gender")
    var gender: String = ""

}
