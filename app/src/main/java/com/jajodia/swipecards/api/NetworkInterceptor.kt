package com.jajodia.swipecards.api

import okhttp3.*
import okhttp3.ResponseBody.Companion.toResponseBody

class NetworkInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        return interceptInvalidResponses(
            chain.proceed(chain.request())
        )
    }

    private fun interceptInvalidResponses(response: Response): Response {

        val stringResponse = response.body?.string()
        val newResponseBody: ResponseBody?

        if (response.code == 200 && stringResponse?.get(0) != '{') {
            val res = stringResponse?.drop(1)
            newResponseBody = res?.toResponseBody()
        } else
            return response

        return createResponseBody(response, newResponseBody)
    }

    private fun createResponseBody(
        oldResponseObject: Response,
        newResponseBody: ResponseBody?
    ): Response {

        return Response.Builder()
            .body(newResponseBody)
            .request(oldResponseObject.request)
            .protocol(oldResponseObject.protocol)
            .headers(oldResponseObject.headers)
            .code(oldResponseObject.code)
            .message(oldResponseObject.message)
            .build()
    }

}