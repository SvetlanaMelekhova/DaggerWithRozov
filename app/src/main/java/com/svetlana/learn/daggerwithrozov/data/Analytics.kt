@file:Suppress("UNUSED_PARAMETER")

package com.svetlana.learn.daggerwithrozov.data

import javax.inject.Inject

class Analytics @Inject constructor() {

    fun trackScreenShow() {
    }

    fun trackNewsRequest(newsId: String) {
        // Do nothing
    }
}