package com.codex.test.feature.story

import android.os.Bundle
import com.codex.test.R
import com.codex.test.base.view.activity.BaseDaggerActivity
import com.codex.test.constant.LiveDataTag
import com.codex.test.feature.viewmodel.StoryViewModel
import com.codex.test.pojo.adapter.ListStoryAdapter
import com.codex.test.pojo.common.Response
import com.codex.test.pojo.response.BaseResponse
import com.mikepenz.fastadapter.commons.adapters.FastItemAdapter
import kotlinx.android.synthetic.main.activity_top_story.*

@Suppress("CAST_NEVER_SUCCEEDS")
class TopStoryActivity : BaseDaggerActivity<StoryViewModel>() {

    private val listStoryAdapter = FastItemAdapter<ListStoryAdapter>()

    var storyResponse : BaseResponse? = null

    override fun layoutRes(): Int {
        return R.layout.activity_top_story
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initDataViewModel()
        initComponent()
    }

    private fun initComponent() {
        configureGridItemAdapter(listTopStoryRecycleView, listStoryAdapter, 2)
    }

    private fun initDataViewModel() {
        viewModel.getListCategory()
    }

    override fun doOnResponseSuccess(response: Response) {
        when(response.type){
            LiveDataTag.getListStorySuccess -> {
                storyResponse = response as BaseResponse
                showListStory(storyResponse!! )
            }
        }
    }

    fun showListStory(dataStory : BaseResponse){
        listStoryAdapter.clear()
        listStoryAdapter.add(ListStoryAdapter(dataStory))
    }
}