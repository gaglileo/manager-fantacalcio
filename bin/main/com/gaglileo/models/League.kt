package com.gaglileo.models

data class League(
    val coaches: ArrayList<Coach>,
    val teams: ArrayList<Team>,
    val players: ArrayList<Player>
)

val playersInLeague = arrayListOf(
    Player("001", "Francesco Totti", 30, 30, "Roma"),
    Player("002", "Javier Zanetti", 15, 15, "Inter"),
    Player("003", "Alessandro Del Piero", 28, 28, "Juventus"),
    Player("004", "Paolo Maldini", 20, 20, "Milan"),
)

val leagueStorage: League = League(
    arrayListOf(),
    arrayListOf(),
    playersInLeague
)
