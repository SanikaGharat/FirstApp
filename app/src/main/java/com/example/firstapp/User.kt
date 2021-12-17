package com.example.firstapp

data class User(var name:String?= "", var email:String?= ""){

    fun toMap(): Map<String,Any?>{
        return mapOf(
            "name" to name,
            "email" to email
        )
    }

}
