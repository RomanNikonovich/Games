package com.example.model.entity

import com.google.gson.annotations.SerializedName

class GamesList(@SerializedName("top") val list_games: List<Game>)