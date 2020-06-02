package com.codex.test.feature.domain

import com.codex.test.base.domain.BaseUseCase
import com.codex.test.feature.data.StoryRepository
import com.codex.test.utils.BaseSchedulerProvider
import com.codex.test.utils.JsonParser
import io.reactivex.Observable
import javax.inject.Inject
import javax.inject.Named

class StoryUseCase @Inject constructor(
    private val repository: StoryRepository,
    schedulerFacade: BaseSchedulerProvider,
    @Named("JsonParser") private val parser: JsonParser
) : BaseUseCase(repository,parser, schedulerFacade){

    fun getListStory(print : String) : Observable<Any> {
        return repository.getListStory(print)
            .observeOn(ui())
            .subscribeOn(io())
    }

    fun getDetailStory(print : String) : Observable<Any> {
        return repository.getDetailStory(print)
            .observeOn(ui())
            .subscribeOn(io())
    }
}