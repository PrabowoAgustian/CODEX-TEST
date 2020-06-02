package com.codex.test.base.domain

import androidx.fragment.app.FragmentActivity
import com.codex.test.base.data.BaseRepository
import com.codex.test.pojo.common.ResponseDummyTestApi
import com.codex.test.utils.BaseSchedulerProvider
import com.codex.test.utils.JsonParser
import com.tbruyelle.rxpermissions2.RxPermissions
import io.reactivex.Observable
import io.reactivex.Scheduler

open class BaseUseCase (
    private val repository: BaseRepository,
    private var jsonParser: JsonParser,
    private var scheduler: BaseSchedulerProvider
) {
    protected fun ui(): Scheduler {
        return scheduler.ui()
    }

    protected fun io(): Scheduler {
        return scheduler.io()
    }

    fun getJsonParser(): JsonParser? {
        return jsonParser
    }

    fun getDummyTestResponse(t: Any?) : ResponseDummyTestApi? {
        return jsonParser.getObject(t, ResponseDummyTestApi::class.java)
    }

    fun getRequestPermission(activity: FragmentActivity, permission: String): Observable<Boolean> {
        return RxPermissions(activity).request(permission).observeOn(ui()).subscribeOn(io())
    }
}