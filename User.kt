package com.example.libraryapp.model

data class User(
    val id: String,
    val name: String,
    val borrowedBooks: MutableList<String> = mutableListOf()
)