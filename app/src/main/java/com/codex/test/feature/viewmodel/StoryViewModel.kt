package com.codex.test.feature.viewmodel

import com.codex.test.base.viewmodel.BaseViewModel
import com.codex.test.constant.LiveDataTag
import com.codex.test.feature.domain.StoryUseCase
import com.codex.test.pojo.common.Response
import com.codex.test.pojo.response.BaseResponse
import com.codex.test.utils.callback.CodexTestAdapter
import javax.inject.Inject

class StoryViewModel @Inject constructor(
    private val useCase: StoryUseCase
) : BaseViewModel(useCase){

    var print : String = "pretty"

    fun getListCategory(){
        addDisposable(
            useCase.getListStory(print)
                .doOnSubscribe {
                    response().value = Response.loading()
                }
                .subscribe(object : CodexTestAdapter<Any>() {
                    override fun accept(t: Any) {
                        super.accept(t)
                        val response = getBaseResponse(t)
                        response().value =
                            Response.success(response, LiveDataTag.getListStorySuccess)
                    }
                }, handleError())
        )
    }

    fun getDetailStory(){
        addDisposable(
            useCase.getDetailStory(print)
                .doOnSubscribe {
                    response().value = Response.loading()
                }
                .subscribe(object : CodexTestAdapter<Any>() {
                    override fun accept(t: Any) {
                        super.accept(t)
                        val response = getBaseResponse(t)
                        response().value =
                            Response.success(response, LiveDataTag.getDetailStorySuccess)
                    }
                }, handleError())
        )
    }
}