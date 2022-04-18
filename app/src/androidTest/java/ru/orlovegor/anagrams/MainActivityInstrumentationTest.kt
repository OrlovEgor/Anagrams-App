package ru.orlovegor.anagrams


import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import org.hamcrest.CoreMatchers.not
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class MainActivityInstrumentationTest {

    @get:Rule
    var activityTestRule: ActivityScenarioRule<MainActivity> =
        ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun get1AnagramOnButtonClick() {
        onView(withId(R.id.text_for_anagram_edittext))
            .perform(typeText("Foxminded"))
            .perform(closeSoftKeyboard())
        onView(withId(R.id.get_anagram_button)).perform(click())
        onView(withId(R.id.result_anagram_text)).check(matches(withText("dednimxoF")))
    }

    @Test
    fun getAnagramWithExceptionOfSpecialCharactersByPressingButton() {
        onView(withId(R.id.text_for_anagram_edittext))
            .perform(typeText("Foxminded cool 24/7"))
            .perform(closeSoftKeyboard())
        onView(withId(R.id.ignored_characters_edittext)).perform(typeText("0123456789/*-+_()"))
            .perform(closeSoftKeyboard())
        onView(withId(R.id.get_anagram_button)).perform(click())
        onView(withId(R.id.result_anagram_text)).check(matches(withText("dednimxoF looc 24/7")))
    }

    @Test
    fun checkStateButtonForEmptyText() {
        onView(withId(R.id.text_for_anagram_edittext))
            .perform(typeText(""))
            .perform(closeSoftKeyboard())
        onView(withId(R.id.ignored_characters_edittext)).perform(typeText("0123456789/*-+_()"))
            .perform(closeSoftKeyboard())
        onView(withId(R.id.get_anagram_button)).check(matches(not(isEnabled())))
    }

}