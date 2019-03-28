package com.learn.howtoplay.adapter

import android.content.Context
import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.learn.howtoplay.R
import com.learn.howtoplay.model.Lesson

class LessonAdapter(private var values: List<Lesson>, var context: Context): RecyclerView.Adapter<LessonAdapter.LessonViewHolder>(){


    override fun onBindViewHolder(p0: LessonAdapter.LessonViewHolder, p1: Int) {

        val item = values[p1]

        p0.lessonNum.text = item.getLessonNum()
        p0.lessonTitle.text = item.getLessonTitle()
        p0.lessonText.text = "${item.getLessonText().take(100)}..."

    }

    override fun getItemCount(): Int {
        return values.size
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): LessonAdapter.LessonViewHolder {
        val view: View = LayoutInflater.from(p0.context).inflate(R.layout.lesson_item_view, p0, false)
        return LessonViewHolder(view)
    }


    class LessonViewHolder(itemView: View): RecyclerView.ViewHolder(itemView), View.OnLongClickListener, View.OnClickListener {
        override fun onClick(v: View?) {

        }

        override fun onLongClick(v: View?): Boolean {
            return true
        }

        var lessonNum: TextView = itemView.findViewById(R.id.lesson_num)
        var lessonTitle: TextView = itemView.findViewById(R.id.lesson_title)
        var lessonText: TextView = itemView.findViewById(R.id.lesson_text)
        var lessonCard: CardView = itemView.findViewById(R.id.lesson_card)

    }

}