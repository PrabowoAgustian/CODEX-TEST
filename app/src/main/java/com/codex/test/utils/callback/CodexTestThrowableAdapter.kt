package com.codex.test.utils.callback

import io.reactivex.functions.Consumer
import java.util.logging.Level
import java.util.logging.Logger

open class CodexTestThrowableAdapter : Consumer<Throwable> {
    private val logger =
        Logger.getLogger(javaClass.name)

    @Throws(Exception::class)
    override fun accept(throwable: Throwable) {
        logger.log(
            Level.SEVERE,
            this.javaClass.name,
            throwable
        )
    }
}