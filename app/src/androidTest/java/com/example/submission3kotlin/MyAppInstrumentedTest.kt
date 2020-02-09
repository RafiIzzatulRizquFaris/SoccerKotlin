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

        // Cek id search
        onView(withId(R.id.search)).check(matches(isDisplayed()))
        // Klik id search
        onView(withId(R.id.search)).perform(click())
        // Ketik query search
        onView(withId(R.id.search)).perform(typeText("Liverpool"))
        // tekan enter
        onView(withId(R.id.search)).perform(pressKey(KeyEvent.KEYCODE_ENTER))
        idling(3000)

        onView(withId(R.id.rv_search_team)).check(matches(isDisplayed()))
        // Pilih item pertama di RecyclerView Search Team
        onView(withId(R.id.rv_search_team)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(0))
        onView(withId(R.id.rv_search_team)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        idling(2000)

        // Cek gambar apakah sudah muncul
        onView(withId(R.id.posterTeam)).check(matches(isDisplayed()))
        // Cek id tombol favorit
        onView(withId(R.id.btn_favorite)).check(matches(isDisplayed()))
        // Tekan tombol favorit
        onView(withId(R.id.btn_favorite)).perform(click())
        idling(1000)

        pressBack()
        pressBack()

        // Cek tab layout di MainActivity
        onView(withId(R.id.main_tab_layout)).check(matches(isDisplayed()))
        // Klik tab dengan teks "LEAGUES"
        val leagueMatchers = Matchers.allOf(withText("LEAGUES"), isDescendantOfA(withId(R.id.main_tab_layout)))
        onView(leagueMatchers).perform(click())
        idling(1000)

        //  Cek RecyclerView League
        onView(withId(R.id.rv_league)).check(matches(isDisplayed()))
        // Pilih item pertama di RecyclerView League
        onView(withId(R.id.rv_league)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(0))
        onView(withId(R.id.rv_league)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        idling(2000)

        // Cek id search
        onView(withId(R.id.search)).check(matches(isDisplayed()))
        // Klik id search
        onView(withId(R.id.search)).perform(click())
        // Ketik query search
        onView(withId(R.id.search)).perform(typeText("Liverpool"))
        // tekan enter
        onView(withId(R.id.search)).perform(pressKey(KeyEvent.KEYCODE_ENTER))
        idling(3000)

        // cek RecyclerView Search Match
        onView(withId(R.id.rv_search_match)).check(matches(isDisplayed()))
        // Pilih item pertama di RecyclerView Search Match
        onView(withId(R.id.rv_search_match)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(0))
        onView(withId(R.id.rv_search_match)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        idling(2000)

        // Cek gambar apakah sudah muncul
        onView(withId(R.id.homeImg)).check(matches(isDisplayed()))
        // Cek id tombol favorit
        onView(withId(R.id.btn_favorite)).check(matches(isDisplayed()))
        // Tekan tombol favorit
        onView(withId(R.id.btn_favorite)).perform(click())
        idling(1000)

        pressBack()
        pressBack()
        pressBack()

        // Cek teks Nama Liga
        onView(withId(R.id.txtLeagueName)).check(matches(isDisplayed()))
        // Cek tab layout Liga
        onView(withId(R.id.tab_layout)).check(matches(isDisplayed()))
        // Klik tab dengan teks "Previous Match"
        val previousMatchers = Matchers.allOf(withText("Previous Match"), isDescendantOfA(withId(R.id.tab_layout)))
        onView(previousMatchers).perform(click())
        idling(1000)

        // cek RecyclerView Previous Match
        onView(withId(R.id.rv_previous_match)).check(matches(isDisplayed()))
        // Pilih item ketujuh di RecyclerView Search Match
        onView(withId(R.id.rv_previous_match)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(7))
        onView(withId(R.id.rv_previous_match)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(7, click()))
        idling(2000)

        // Cek gambar apakah sudah muncul
        onView(withId(R.id.homeImg)).check(matches(isDisplayed()))
        // Cek id tombol favorit
        onView(withId(R.id.btn_favorite)).check(matches(isDisplayed()))
        // Tekan tombol favorit
        onView(withId(R.id.btn_favorite)).perform(click())
        idling(1000)

        pressBack()
        pressBack()

        idling(1000)
        // Klik tab dengan teks "Next Match"
        val nextMatchers = Matchers.allOf(withText("Next Match"), isDescendantOfA(withId(R.id.tab_layout)))
        onView(nextMatchers).perform(click())
        // Pilih item ketujuh di RecyclerView Next Match
        onView(withId(R.id.rv_next_match)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(7))
        onView(withId(R.id.rv_next_match)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(7, click()))
        idling(2000)

        // Cek gambar apakah sudah muncul
        onView(withId(R.id.homeImg)).check(matches(isDisplayed()))
        // Cek id tombol favorit
        onView(withId(R.id.btn_favorite)).check(matches(isDisplayed()))
        // Tekan tombol favorit
        onView(withId(R.id.btn_favorite)).perform(click())
        idling(1000)


        pressBack()
        pressBack()

        idling(1000)
        // Klik tab dengan teks "Standings"
        val standingsMatchers = Matchers.allOf(withText("Standings"), isDescendantOfA(withId(R.id.tab_layout)))
        onView(standingsMatchers).perform(click())
        // Pilih item ketujuh di RecyclerView Standings
        onView(withId(R.id.rv_standings)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(0))
        onView(withId(R.id.rv_standings)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        idling(2000)

        // Cek gambar apakah sudah muncul
        onView(withId(R.id.posterTeamStandings)).check(matches(isDisplayed()))
        // Cek id tombol favorit
        onView(withId(R.id.btn_favorite)).check(matches(isDisplayed()))
        // Tekan tombol favorit
        onView(withId(R.id.btn_favorite)).perform(click())
        idling(1000)


        pressBack()
        pressBack()

        idling(1000)
        // Klik tab dengan teks "Team"
        val teamMatchers = Matchers.allOf(withText("Team"), isDescendantOfA(withId(R.id.tab_layout)))
        onView(teamMatchers).perform(click())
        // Pilih item ketujuh di RecyclerView Team
        onView(withId(R.id.rv_list_team)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(0))
        onView(withId(R.id.rv_list_team)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        idling(2000)

        // Cek gambar apakah sudah muncul
        onView(withId(R.id.posterTeam)).check(matches(isDisplayed()))
        // Cek id tombol favorit
        onView(withId(R.id.btn_favorite)).check(matches(isDisplayed()))
        // Tekan tombol favorit
        onView(withId(R.id.btn_favorite)).perform(click())
        idling(1000)


        pressBack()
        pressBack()
        pressBack()

        // Klik tab dengan teks "Favorites"
        val favoriteMatchers = Matchers.allOf(withText("FAVORITES"), isDescendantOfA(withId(R.id.main_tab_layout)))
        onView(favoriteMatchers).perform(click())

        val favoriteMatchMatchers = Matchers.allOf(withText("MATCH"), isDescendantOfA(withId(R.id.favorite_tab_layout)))
        onView(favoriteMatchMatchers).perform(click())
        // Pilih item ketujuh di RecyclerView Favorite
        onView(withId(R.id.rv_favorite_match)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(0))
        onView(withId(R.id.rv_favorite_match)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        idling(2000)

        // Cek gambar apakah sudah muncul
        onView(withId(R.id.homeImg)).check(matches(isDisplayed()))
        // Cek id tombol favorit
        onView(withId(R.id.btn_favorite)).check(matches(isDisplayed()))
        // Tekan tombol favorit
        onView(withId(R.id.btn_favorite)).perform(click())
        idling(1000)

        pressBack()

        onView(favoriteMatchers).perform(click())

        val favoriteTeamMatchers = Matchers.allOf(withText("TEAM"), isDescendantOfA(withId(R.id.favorite_tab_layout)))
        onView(favoriteTeamMatchers).perform(click())
        // Pilih item ketujuh di RecyclerView Favorite
        onView(withId(R.id.rv_favorite_team)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(0))
        onView(withId(R.id.rv_favorite_team)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        idling(2000)

        // Cek gambar apakah sudah muncul
        onView(withId(R.id.posterTeamFavorite)).check(matches(isDisplayed()))
        // Cek id tombol favorit
        onView(withId(R.id.btn_favorite)).check(matches(isDisplayed()))
        // Tekan tombol favorit
        onView(withId(R.id.btn_favorite)).perform(click())
        idling(1000)

        pressBack()
    }
}