package com.codex.test.utils.callback

import com.codex.test.helper.StringHelper.Companion.getStringBuilderToString
import io.reactivex.functions.Consumer
import java.util.logging.Level
import java.util.logging.Logger
open class CodexTestAdapter<T> : Consumer<T> {
    private val logger = Logger.getLogger(javaClass.name)

    @Throws(Exception::class)
    override fun accept(t: T) {
        logger.log(
            Level.INFO,
            this.javaClass.name,
            getStringBuilderToString(
                "subscribe onNext ",
                t?.toString() ?: ""
            )
        )
    }
}