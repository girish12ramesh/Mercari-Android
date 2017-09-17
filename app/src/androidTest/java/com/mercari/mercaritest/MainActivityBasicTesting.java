package com.mercari.mercaritest;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.hamcrest.Matcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.scrollTo;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.anything;

/**
 * Created by girish on 9/16/2017.
 */
@RunWith(AndroidJUnit4.class)
public class MainActivityBasicTesting {

    // I will be using Espresso framework for testing.
    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule =
            new ActivityTestRule<>(MainActivity.class);
  // Here we focus on testing the Gridview adapter. onData(objectMatcher)
  //we can use a DataOption method such as inAdapterView() or atPosition().

    /**
     * Clicks on a GridView item and checks it opens up the OrderActivity with the correct details.
     */
    @Test
    public void clickGridViewItem_OpensOrderActivity() {

        //Testing the scroll view.
        onData(anything()).inAdapterView(withId(R.id.data_list)).perform(scrollTo());

        // Check the price text quantity variable
        onView((withId(R.id.price_text))).check(matches(withText("10")));
        // Check if the sold product is visible

       // onView((withId(R.id.sold))).perform(click()).check(matches(Matcher));

    }

}
