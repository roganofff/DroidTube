package com.trainee.droidtube.data

import io.ktor.client.HttpClient
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.plugins.defaultRequest

class KtorClient {
    private val client = HttpClient(OkHttp) {

    }
}