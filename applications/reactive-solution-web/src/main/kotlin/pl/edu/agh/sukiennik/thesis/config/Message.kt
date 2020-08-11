package pl.edu.agh.sukiennik.thesis.config

data class Message(val id: String, val payload: String, val delay: Long, val size: Long = 1)
