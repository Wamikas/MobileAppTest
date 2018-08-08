package com.mytaxi.android_demo;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.mytaxi.android_demo.activities.MainActivity;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.contrib.DrawerActions.open;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class MainActivityEspressoTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule =
            new ActivityTestRule<>(MainActivity.class);
    private MainActivity mActivity = mActivityRule.getActivity();


    @Before
    public void login() throws InterruptedException {
        String username="crazydog335";
        String password="venture";
        onView(withId(R.id.edt_username)).perform(typeText(username), closeSoftKeyboard());
        onView(withId(R.id.edt_password)).perform(typeText(password), closeSoftKeyboard());
        onView(withId(R.id.btn_login)).perform(click());
    }

    //TODO: remove async waits

    @Test
    public void testSearchAndCall() throws InterruptedException {
        String driverName = "Sarah Scott";
        Thread.sleep(2000);
        onView(withId(R.id.searchContainer)).check(matches(isDisplayed()));
        onView(withId(R.id.textSearch)).perform(typeText("sa"), closeSoftKeyboard());
        Thread.sleep(3000);
        onView(withId(R.id.drawer_layout)).perform(open());
        onView(withText("Logout")).perform(click());
        Thread.sleep(3000);
        onView(withId(R.id.fab)).perform(click());
    }

}
