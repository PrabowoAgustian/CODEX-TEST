package com.codex.test.feature.story

import android.content.Intent
import android.os.Bundle
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.codex.test.R
import com.codex.test.base.data.PreferenceManager
import com.codex.test.base.view.activity.BaseDaggerActivity
import com.codex.test.constant.LiveDataTag
import com.codex.test.feature.viewmodel.StoryViewModel
import com.codex.test.pojo.adapter.ListStoryAdapter
import com.codex.test.pojo.common.Response
import com.codex.test.pojo.response.BaseResponse
import com.mikepenz.fastadapter.commons.adapters.FastItemAdapter
import kotlinx.android.synthetic.main.activity_top_story.*

@Suppress("CAST_NEVER_SUCCEEDS", "DEPRECATION", "NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
class TopStoryActivity : BaseDaggerActivity<StoryViewModel>(), SwipeRefreshLayout.OnRefreshListener {

    private val listStoryAdapter = FastItemAdapter<ListStoryAdapter>()
    var preferenceManager : PreferenceManager? = null

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
        swipeRefresh.setOnRefreshListener(this)
        swipeRefresh.setProgressBackgroundColorSchemeColor(resources.getColor(R.color.soft_blue))
        configureGridItemAdapter(listTopStoryRecycleView, listStoryAdapter, 2)
        titleTopStoryFav.text = intent.getStringExtra("title")
    }

    private fun initDataViewModel() {
        viewModel.getListCategory()
    }

    override fun onDestroy() {
        super.onDestroy()
        viewModel.unBinding()
    }

    override fun onRefresh() {
        swipeRefresh.isRefreshing = false
        initDataViewModel()
    }

    override fun doOnResponseSuccess(response: Response) {
        when(response.type){
            LiveDataTag.getListStorySuccess -> {
                storyResponse = response.articles as BaseResponse
                showListStory(storyResponse!!)
            }
        }
    }

    fun showListStory(dataStory : BaseResponse){
        listStoryAdapter.clear()
        listStoryAdapter.add(ListStoryAdapter(dataStory))

        listStoryAdapter.withOnClickListener { _, _, item, _ ->
            val intent = Intent(this, DetailStoryActivity::class.java)
            showActivity(intent)
            true
        }
    }
}