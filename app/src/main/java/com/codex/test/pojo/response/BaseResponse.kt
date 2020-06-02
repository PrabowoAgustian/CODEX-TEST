package com.codex.test.pojo.response

data class BaseResponse (var by : String = "",
                         var descendants : Int = 0,
                         var id : Int = 0,
                         var time : Long = 0,
                         var title : String = "",
                         var text : String = "",
                         var url : String = "",
                         var score : Int = 0)