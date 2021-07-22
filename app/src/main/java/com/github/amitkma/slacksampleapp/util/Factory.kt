package com.github.amitkma.slacksampleapp.util

interface Factory<T> {

    fun create(): T
}