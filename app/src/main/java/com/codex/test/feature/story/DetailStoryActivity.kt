package com.codex.test.feature.story

import android.os.Bundle
import com.codex.test.R
import com.codex.test.base.view.activity.BaseDaggerActivity
import com.codex.test.constant.LiveDataTag
import com.codex.test.feature.viewmodel.StoryViewModel
import com.codex.test.helper.StringHelper
import com.codex.test.helper.TimeHelper
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
                initComponent(response.articles as BaseResponse)
            }
        }
    }

    private fun initComponent(baseResponse: BaseResponse) {
        titleDescTextView.text = baseResponse.title
        descTitleTextView.text = "Deskripsi"
        byUserNameTextView.text = StringHelper.getStringBuilderToString("By ", baseResponse.by)
        dateTextView.text = TimeHelper.getDateFormated(baseResponse.time)
        descTextView.text = baseResponse.text
    }
}