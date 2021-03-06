package com.codex.test.pojo.adapter

import android.view.View
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.codex.test.R
import com.codex.test.helper.StringHelper
import com.codex.test.helper.TimeHelper
import com.codex.test.pojo.response.BaseResponse
import com.mikepenz.fastadapter.items.AbstractItem

class ListStoryAdapter (var response: BaseResponse) : AbstractItem<ListStoryAdapter, ListStoryAdapter.ViewHolder>() {

    override fun getType(): Int {
        return R.id.list_id
    }

    override fun getLayoutRes(): Int {
        return R.layout.adapter_list_story
    }

    override fun getViewHolder(v: View): ViewHolder {
        return ViewHolder(v)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleStory: AppCompatTextView = itemView.findViewById(R.id.titleStoryTextView)
        val timeStory : AppCompatTextView = itemView.findViewById(R.id.timeStoryTextView)
        val scoreStory : AppCompatTextView = itemView.findViewById(R.id.scoreStoryTextView)
    }

    override fun bindView(
        holder: ViewHolder,
        payloads: List<Any>
    ) {
        super.bindView(holder, payloads)
        holder.titleStory.text = response.title
        holder.timeStory.text = TimeHelper.getDateFormated(response.time)
        holder.scoreStory.text = StringHelper.getStringBuilderToString("Total Comment : ",response.descendants.toString(),
            "  ","Score : ", response.score.toString())
    }

    override fun unbindView(holder: ViewHolder) {
    }
}