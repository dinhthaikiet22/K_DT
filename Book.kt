package com.example.libraryapp.model

data class Book(
    val id: String,
    val title: String,
    val author: String,
    var isAvailable: Boolean = true
)

