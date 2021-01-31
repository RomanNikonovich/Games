package com.example.model.entity

import com.google.gson.annotations.SerializedName

class Game(
    @SerializedName("viewers") val viewers: Int,
    @SerializedName("channels") val channels: Int,
    @SerializedName("game") val gameName: GameName
)
