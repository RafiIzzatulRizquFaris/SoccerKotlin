package com.example.submission3kotlin

import android.view.KeyEvent
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.example.submission3kotlin.ui.activity.MainActivity
import org.hamcrest.Matchers
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MyAppInstrumentedTest {
    @Rule
    @JvmField var activityRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun testAppBehavior(){
        onView(withId(R.id.main_tab_layout)).check(matches(isDisplayed()))
        val leagueMatchers = Matchers.allOf(withText("LEAGUES"), isDescendantOfA(withId(R.id.main_tab_layout)))
        onView(leagueMatchers).perform(click())
        idling(1000)

        onView(withId(R.id.rv_league)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_league)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(0))
        onView(withId(R.id.rv_league)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        idling(2000)

        onView(withId(R.id.search)).check(matches(isDisplayed()))
        onView(withId(R.id.search)).perform(click())
        onView(withId(R.id.search)).perform(typeText("Liverpool"))
        onView(withId(R.id.search)).perform(pressKey(KeyEvent.KEYCODE_ENTER))
        idling(3000)

        onView(withId(R.id.rv_search_match)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_search_match)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(0))
        onView(withId(R.id.rv_search_match)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        idling(2000)

        onView(withId(R.id.homeImg)).check(matches(isDisplayed()))
        onView(withId(R.id.btn_favorite)).check(matches(isDisplayed()))
        onView(withId(R.id.btn_favorite)).perform(click())
        idling(1000)

        pressBack()
        pressBack()
        pressBack()

        onView(withId(R.id.txtLeagueName)).check(matches(isDisplayed()))
        onView(withId(R.id.tab_layout)).check(matches(isDisplayed()))
        val previousMatchers = Matchers.allOf(withText("Previous Match"), isDescendantOfA(withId(R.id.tab_layout)))
        onView(previousMatchers).perform(click())
        idling(1000)

        onView(withId(R.id.rv_previous_match)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_previous_match)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(7))
        onView(withId(R.id.rv_previous_match)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(7, click()))
        idling(2000)

        onView(withId(R.id.homeImg)).check(matches(isDisplayed()))
        onView(withId(R.id.btn_favorite)).check(matches(isDisplayed()))
        onView(withId(R.id.btn_favorite)).perform(click())
        idling(1000)

        pressBack()
        pressBack()

        val nextMatchers = Matchers.allOf(withText("Next Match"), isDescendantOfA(withId(R.id.tab_layout)))
        idling(1000)
        onView(nextMatchers).perform(click())
        onView(withId(R.id.rv_next_match)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(7))
        onView(withId(R.id.rv_next_match)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(7, click()))
        idling(2000)

        onView(withId(R.id.homeImg)).check(matches(isDisplayed()))
        onView(withId(R.id.btn_favorite)).check(matches(isDisplayed()))
        onView(withId(R.id.btn_favorite)).perform(click())
        idling(1000)

        pressBack()
        pressBack()
        pressBack()

        val favoriteMatchers = Matchers.allOf(withText("FAVORITES"), isDescendantOfA(withId(R.id.main_tab_layout)))
        onView(favoriteMatchers).perform(click())
        onView(withId(R.id.rv_favorite)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(0))
        onView(withId(R.id.rv_favorite)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        idling(2000)

        onView(withId(R.id.homeImg)).check(matches(isDisplayed()))
        onView(withId(R.id.btn_favorite)).check(matches(isDisplayed()))
        onView(withId(R.id.btn_favorite)).perform(click())
        idling(1000)

        pressBack()
    }
}