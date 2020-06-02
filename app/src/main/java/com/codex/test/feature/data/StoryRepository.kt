package com.codex.test.feature.data

import com.codex.test.base.data.BaseRepository
import com.codex.test.base.data.PreferenceManager
import com.codex.test.base.restapi.RestApi
import io.reactivex.Observable
import javax.inject.Inject

class StoryRepository@Inject constructor(
    val restApi: RestApi,
    preferenceManager: PreferenceManager
) : BaseRepository(preferenceManager, restApi) {

    fun getListStory(print: String) : Observable<Any> {
        return restApi.getListStory(print)
    }

    fun getDetailStory(print: String) : Observable<Any> {
        return restApi.getDetailStory(print)
    }
}