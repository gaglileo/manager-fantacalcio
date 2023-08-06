package com.gaglileo.models

import kotlinx.serialization.Serializable

@Serializable
data class Coach(
    val id: String,
    val firstName: String,
    val lastName: String,
    val email: String
)

val coachesStorage = mutableListOf(
    Coach("1", "Leo", "Gagliardi", "lg@mail.com"),
    Coach("2", "Marco", "Greco", "mg@mail.com"),
)
