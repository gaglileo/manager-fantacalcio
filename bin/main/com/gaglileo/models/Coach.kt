package com.gaglileo.models

import kotlinx.serialization.Serializable

@Serializable
data class Coach(
    val id: String,
    val firstName: String,
    val lastName: String,
    val email: String
)

val coachesStorage = mutableListOf<Coach>()
