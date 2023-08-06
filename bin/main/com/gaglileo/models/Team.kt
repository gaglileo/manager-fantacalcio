package com.gaglileo.models

data class Team(
    val id: String,
    val name: String,
    val players: ArrayList<Player>,
    val coach: Coach
)