package com.example.gridapp.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Topic(
    @StringRes val topicId: Int,
    val numberOfCourses: Int,
    @DrawableRes val iconId: Int

)
