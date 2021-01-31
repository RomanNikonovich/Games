package com.example.model.entity

import com.google.gson.annotations.SerializedName

class GameName(
    @SerializedName("name") val gameName: String,
    @SerializedName("logo") val logoUrl: Logo
)