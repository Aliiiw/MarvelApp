package com.example.mymarvelapp.utils

import java.math.BigInteger
import java.security.MessageDigest

fun getHash(timeStamp: String, privateKey: String, publicKey: String): String {
    val hashString = timeStamp + privateKey + publicKey
    val md = MessageDigest.getInstance("MD5")

    return BigInteger(1, md.digest(hashString.toByteArray()))
        .toString(16)
        .padStart(32, '0')
}