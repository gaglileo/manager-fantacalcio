package com.gaglileo.models

import kotlinx.serialization.Serializable

@Serializable
data class League(
    val coaches: MutableList<Coach>,
    val teams: MutableList<Team>,
    val players: MutableList<Player>
)

val playersInLeague = mutableListOf(
    Player("001", "Francesco Totti", 30, 30, "Roma"),
    Player("002", "Javier Zanetti", 15, 15, "Inter"),
    Player("003", "Alessandro Del Piero", 28, 28, "Juventus"),
    Player("004", "Paolo Maldini", 20, 20, "Milan"),
)

val teamsStorage = mutableListOf(
    Team("01", "Atletico Ojala", arrayListOf(), null),
    Team("02", "Strazzuni SS", arrayListOf(), null),
)

val leagueStorage: League = League(
    coachesStorage,
    teamsStorage,
    playersInLeague
)
