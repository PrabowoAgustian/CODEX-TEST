package com.codex.test.helper

import android.annotation.SuppressLint
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

@Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS",
    "RECEIVER_NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS"
)
class TimeHelper {
    companion object {

        fun getDateFormated(format: String, time: Long): String {
            val id = Locale("en")
            return SimpleDateFormat(format, id).format(Date(time))
        }

        fun getDateFormated(date: Long?): String {
            return getDateFormated("dd MMMM yyyy", date!!)
        }
    }
}