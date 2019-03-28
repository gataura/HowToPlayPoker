package com.learn.howtoplay.model

class Lesson(
    private var lessonNum: String = "",
    private var lessonTitle: String = "",
    private var lessonText: String = ""
) {
    fun getLessonNum(): String {
        return lessonNum
    }

    fun setLessonNum(lessonNUm: String) {
        this.lessonNum = lessonNum
    }

    fun getLessonTitle(): String {
        return lessonTitle
    }

    fun setLessonTitle(lessonTitle: String) {
        this.lessonTitle = lessonTitle
    }

    fun getLessonText(): String {
        return lessonText
    }

    fun setLessonText(lessonText: String) {
        this.lessonText = lessonText
    }
}