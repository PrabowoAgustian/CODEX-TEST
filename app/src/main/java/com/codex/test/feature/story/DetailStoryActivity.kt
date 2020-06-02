package com.codex.test.feature.story

import android.content.Intent
import android.os.Bundle
import android.text.Html
import android.widget.Toast
import butterknife.OnClick
import com.codex.test.R
import com.codex.test.base.data.PreferenceManager
import com.codex.test.base.view.activity.BaseDaggerActivity
import com.codex.test.constant.LiveDataTag
import com.codex.test.feature.viewmodel.StoryViewModel
import com.codex.test.helper.StringHelper
import com.codex.test.helper.TimeHelper
import com.codex.test.pojo.common.Response
import com.codex.test.pojo.response.BaseResponse
import kotlinx.android.synthetic.main.activity_detail_story.*

@Suppress("CAST_NEVER_SUCCEEDS", "DEPRECATION")
class DetailStoryActivity : BaseDaggerActivity<StoryViewModel>() {
    var dataStory : BaseResponse? = null

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
                dataStory = response.articles as BaseResponse
                initComponent(dataStory!!)
            }
        }
    }

    private fun initComponent(baseResponse: BaseResponse) {
        titleDescTextView.text = baseResponse.title
        descTitleTextView.text = "Deskripsi"
        byUserNameTextView.text = StringHelper.getStringBuilderToString("By : ", baseResponse.by)
        dateTextView.text = TimeHelper.getDateFormated(baseResponse.time)
        descTextView.text = Html.fromHtml(Html.fromHtml(baseResponse.text).toString())
    }

    @OnClick(R.id.favButton)
    fun favClicked(){
        favButton.isSelected = !favButton.isSelected
        if (favButton.isSelected) {
            val intent = Intent(this, TopStoryActivity::class.java)
            intent.putExtra("title", dataStory?.title)
            showActivity(intent)
            Toast.makeText(this@DetailStoryActivity, "Added to favorites", Toast.LENGTH_LONG).show()
        }
    }
}