package com.example.espressoswiperightissue

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.swipeLeft
import androidx.test.espresso.action.ViewActions.swipeRight
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {
  @Test
  fun positionDisplayed() {
    ActivityScenario.launch(MainActivity::class.java).use {
      onView(withText("Page 0"))
        .check(matches(isDisplayed()))

      onView(withId(R.id.viewPager)).perform(swipeLeft())

      onView(withText("Page 1"))
        .check(matches(isDisplayed()))

      onView(withId(R.id.viewPager)).perform(swipeRight())

      onView(withText("Page 0"))
        .check(matches(isDisplayed()))
    }
  }
}