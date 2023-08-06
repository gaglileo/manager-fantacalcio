package com.gaglileo.models

import kotlinx.serialization.Serializable

@Serializable
data class Player(
    val id: String,
    val name: String,
    val value: Int,
    val initialValue: Int,
    val team: String,
)