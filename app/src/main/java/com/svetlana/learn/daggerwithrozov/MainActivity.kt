@file:Suppress("UNUSED_VARIABLE", "unused", "UNUSED_PARAMETER", "MemberVisibilityCanBePrivate")
package com.svetlana.learn.daggerwithrozov

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.add
import androidx.fragment.app.commit
import com.svetlana.learn.daggerwithrozov.data.Analytics
import javax.inject.Inject

class MainActivity : AppCompatActivity(R.layout.activity_main) {

 override fun onCreate(savedInstanceState: Bundle?) {
     super.onCreate(savedInstanceState)
     appComponent.inject(this)
     with(supportFragmentManager) {
         if (isFragmentContainerEmpty(R.id.fragments)) {
             commit {
                 add<NewsDetailsFragment>(
                     R.id.fragments,
                     FRAGMENT_NEWS_DETAILS,
                     NewsDetailsFragment.makeArgs(TOP_NEWS_ID)
                 )
             }
         }
     }
 }

 @Inject
 fun trackOnStart(analytics: Analytics) {
     analytics.trackScreenShow()
 }

 private companion object {

     private const val TOP_NEWS_ID = "top"
     private const val FRAGMENT_NEWS_DETAILS = "newsDetails"
 }
}
