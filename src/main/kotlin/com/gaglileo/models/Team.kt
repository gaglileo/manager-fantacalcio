package com.gaglileo.models

import kotlinx.serialization.Serializable

@Serializable
data class Team(
    val id: String,
    val name: String,
    val players: ArrayList<Player>,
    var coach: Coach?
)