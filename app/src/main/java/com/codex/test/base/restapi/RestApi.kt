package com.codex.test.base.restapi

import com.codex.test.constant.CodexTestApi
import io.reactivex.Observable
import retrofit2.http.*

interface RestApi {

    @Headers("Content-Type: application/json")
    @GET(CodexTestApi.getListStory)
    fun getListStory(
        @Query("print") print: String
    ): Observable<Any>

    @Headers("Content-Type: application/json")
    @GET(CodexTestApi.getDataListStory)
    fun getDetailStory(
        @Query("print") print: String
    ): Observable<Any>
}