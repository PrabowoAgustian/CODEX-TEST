package com.codex.test.pojo.response

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class BaseResponse (var by : String = "",
                         var descendants : Int = 0,
                         var id : Int = 0,
                         var time : Long = 0,
                         var title : String = "",
                         var text : String = "",
                         var url : String = "",
                         var score : Int = 0) : Parcelable