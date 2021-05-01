package com.example

import io.ktor.application.*
import io.ktor.response.*
import io.ktor.request.*
import io.ktor.routing.*
import io.ktor.http.*
import kotlin.test.*
import io.ktor.server.testing.*

class ApplicationTest {
    @Test
    fun testRespond200() {
        withTestApplication({ module(testing = true) }) {
            handleRequest(HttpMethod.Get, "/respond-200").apply {
                assertEquals(HttpStatusCode.OK, response.status())
                assertTrue(requestHandled, "requestHandled should be true")
            }
        }
    }

    @Test
    fun testStatus200() {
        withTestApplication({ module(testing = true) }) {
            handleRequest(HttpMethod.Get, "/status-200").apply {
                assertEquals(HttpStatusCode.OK, response.status())
                assertFalse(requestHandled, "requestHandled should be false to detect mistake")
            }
        }
    }

    @Test
    fun testRespond404() {
        withTestApplication({ module(testing = true) }) {
            handleRequest(HttpMethod.Get, "/respond-404").apply {
                assertEquals(HttpStatusCode.NotFound, response.status())
                assertTrue(requestHandled, "requestHandled should be true")
            }
        }
    }

    @Test
    fun testStatus404() {
        withTestApplication({ module(testing = true) }) {
            handleRequest(HttpMethod.Get, "/status-404").apply {
                assertEquals(HttpStatusCode.NotFound, response.status())
                assertFalse(requestHandled, "requestHandled should be false to detect mistake")
            }
        }
    }
}
