package com.siebeprojects.samples.deeplink;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.test.espresso.intent.Intents;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class RecommendedActivityScenarioRuleTest extends AbstractTest {

    @Rule
    public ActivityScenarioRule<MainActivity> rule = new ActivityScenarioRule<>(MainActivity.class);

    @Before
    public void beforeTest() {
        Intents.init();
    }

    @After
    public void afterTest() {
        Intents.release();
    }

    @Test
    public void autoDeepLinkTest() {
        // Click auto deeplink button in the activity screen
        onView(withId(R.id.autodeeplinkbutton)).perform(click());

        // wait for app relaunch
        waitForAppRelaunch(PACKAGENAME);

        // Check that the resultview is visible
        onView(withId(R.id.resultview)).check(matches(isDisplayed()));
    }

    @Test
    public void manualDeepLinkTest() {
        // Click manual deeplink button in the activity screen
        onView(withId(R.id.manualdeeplinkbutton)).perform(click());

        // Click button in the web page
        clickButtonInWebPage(PACKAGENAME, "button");

        // wait for app relaunch
        waitForAppRelaunch(PACKAGENAME);

        // Check that the resultview is visible
        onView(withId(R.id.resultview)).check(matches(isDisplayed()));
    }
}