package com.example.dragonballz.data.remote.dto

data class CharacterListResponse(
    val items: List<Character>,
    val meta: Meta,
    val links: Links
)

data class Meta(
    val totalItems: Int = 0,
    val itemCount: Int = 0,
    val itemsPerPage: Int = 0,
    val totalPages: Int = 0,
    val currentPage: Int = 0
)

// Representa los enlaces de paginación
data class Links(
    val first: String = "",
    val previous: String? = "",
    val next: String? = "",
    val last: String = ""
)