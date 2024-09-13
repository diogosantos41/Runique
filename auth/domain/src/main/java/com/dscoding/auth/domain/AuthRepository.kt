package com.dscoding.auth.domain

import com.dscoding.core.domain.util.DataError
import com.dscoding.core.domain.util.EmptyResult

interface AuthRepository {
    suspend fun login(email: String, password: String): EmptyResult<DataError.Network>
    suspend fun register(email: String, password: String): EmptyResult<DataError.Network>
}