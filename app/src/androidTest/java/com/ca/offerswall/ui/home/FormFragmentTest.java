package com.ca.offerswall.ui.home;

import com.ca.offerswall.R;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.filters.LargeTest;
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isEnabled;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4ClassRunner.class)
@LargeTest
public class FormFragmentTest {

    @Rule
    public ActivityScenarioRule<HomeActivity> activityTestRule =
            new ActivityScenarioRule<HomeActivity>(
                    HomeActivity.class);

    @Test
    public void checkIfDisplayed() {
        onView(withId(R.id.et_app_id)).check(matches(withText("2070")));
        onView(withId(R.id.et_user_id)).check(matches(withText("superman")));
        onView(withId(R.id.et_token)).check(matches(withText("1c915e3b5d42d05136185030892fbb846c278927")));
    }

    @Test
    public void checkIfOnProceedClicked() {
        onView(withId(R.id.bt_proceed))
                .perform(click())
                .check(matches(isEnabled()));
    }


}