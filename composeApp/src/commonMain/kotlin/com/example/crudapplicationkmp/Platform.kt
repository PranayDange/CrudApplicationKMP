package com.example.crudapplicationkmp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform