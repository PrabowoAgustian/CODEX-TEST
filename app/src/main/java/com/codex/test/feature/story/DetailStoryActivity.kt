package com.codex.test.feature.story

import android.os.Bundle
import com.codex.test.R
import com.codex.test.base.view.activity.BaseDaggerActivity
import com.codex.test.constant.LiveDataTag
import com.codex.test.feature.viewmodel.StoryViewModel
import com.codex.test.pojo.common.Response
import com.codex.test.pojo.response.BaseResponse
import kotlinx.android.synthetic.main.activity_detail_story.*

@Suppress("CAST_NEVER_SUCCEEDS")
class DetailStoryActivity : BaseDaggerActivity<StoryViewModel>() {

    override fun layoutRes(): Int {
        return R.layout.activity_detail_story
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initDataViewModel()
    }

    private fun initDataViewModel() {
        viewModel.getDetailStory()
    }

    override fun doOnResponseSuccess(response: Response) {
        when(response.type){
            LiveDataTag.getDetailStorySuccess -> {
                initComponent(response as BaseResponse)
            }
        }
    }

    private fun initComponent(baseResponse: BaseResponse) {
        titleDescTextView.text = baseResponse.title
        byUserNameTextView.text = baseResponse.by
        dateTextView.text = baseResponse.time
        descTextView.text = baseResponse.text
    }
}