package com.acob.booking.mqttqos1.data

import io.reactivex.Observable

/**
 * Created by wugang00 on 13/12/2017.
 */
interface LocalStorage {
    fun writeMessage(key:String, value: String)
    fun readMessage(key:String): String
}