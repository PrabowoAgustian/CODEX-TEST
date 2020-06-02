package com.codex.test.pojo.response

data class BaseResponse (var by : String = "",
                         var descendants : String = "",
                         var id : Int = 0,
                         var time : Long = 0,
                         var title : String = "",
                         var text : String = "",
                         var url : String = "")