package com.dscoding.auth.domain

interface PatternValidator {
    fun matches(value: String): Boolean
}