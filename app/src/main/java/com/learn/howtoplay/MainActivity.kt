package com.learn.howtoplay

import android.app.Activity
import android.content.res.AssetManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.learn.howtoplay.adapter.LessonAdapter
import com.learn.howtoplay.helper.Constants
import com.learn.howtoplay.helper.find
import com.learn.howtoplay.model.Lesson
import java.io.InputStream

class MainActivity : AppCompatActivity() {

    private lateinit var lesson_resycler_view: RecyclerView
    lateinit var lessonsAdapter: LessonAdapter
    lateinit var layoutManager: LinearLayoutManager
    private var iter = 0

    var constants = Constants()
    var lessons = mutableListOf<Lesson>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        makeLesson()

        lesson_resycler_view = find(R.id.tutors_recycler_view)
        lesson_resycler_view.isNestedScrollingEnabled = false
        layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        lesson_resycler_view.layoutManager = layoutManager
        lessonsAdapter = LessonAdapter(lessons, this)
        lesson_resycler_view.adapter = lessonsAdapter
        lessonsAdapter.notifyDataSetChanged()
    }

    fun makeLesson() {

        for (i in constants.lessonFiles) {
            lessons.add(Lesson(constants.lessonNums[iter], constants.lessonTitles[iter], getStringFromFile(i)))
            iter++
        }

    }

    private fun getStringFromFile(file: String): String {
        val s = application.assets.open(file).bufferedReader().use {
            it.readText()
        }

        return s
    }
}
