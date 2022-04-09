package com.anyone.type.web.exception

class InvalidTokenException(
   override val message: String
): RuntimeException() {
}