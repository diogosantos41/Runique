package com.dscoding.auth.data

import com.dscoding.auth.domain.AuthRepository
import com.dscoding.core.data.networking.post
import com.dscoding.core.domain.util.DataError
import com.dscoding.core.domain.util.EmptyResult
import io.ktor.client.HttpClient

class AuthRepositoryImpl(private val httpClient: HttpClient) : AuthRepository {
    override suspend fun register(email: String, password: String): EmptyResult<DataError.Network> {
        return httpClient.post<RegisterRequest, Unit>(
            route = "/register",
            body = RegisterRequest(
                email = email,
                password = password
            )
        )
    }
}