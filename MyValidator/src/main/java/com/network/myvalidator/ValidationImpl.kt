package com.network.myvalidator

interface ValidationImpl {
    fun clear()
    fun check():Boolean
    fun setPattern(reg:String?)
    fun setErrorInfo(errorInfo:String?)
}