package com.mytaxi.android_demo;
import android.support.test.rule.ActivityTestRule;
import android.support.test.rule.GrantPermissionRule;
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
import static android.support.test.espresso.matcher.RootMatchers.withDecorView;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;


@RunWith(AndroidJUnit4.class)
public class MainActivityEspressoTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule =
            new ActivityTestRule<>(MainActivity.class);

    @Rule
    public GrantPermissionRule mRuntimePermissionRule =
            GrantPermissionRule.grant(android.Manifest.permission.ACCESS_FINE_LOCATION);


//    @Before
//    public void login() {
//
//        String username="crazydog335";
//        String password="venture";
//        onView(withId(R.id.edt_username)).perform(typeText(username), closeSoftKeyboard());
//        onView(withId(R.id.edt_password)).perform(typeText(password), closeSoftKeyboard());
//        onView(withId(R.id.btn_login)).perform(click());
//        System.console().writer().println("Before setup ran");
//
//    }

    @Test
    public void testSearchAndCall() throws InterruptedException {
        String driverName = "Sarah Scott";
        String username="crazydog335";
        String password="venture";
        onView(withId(R.id.edt_username)).perform(typeText(username), closeSoftKeyboard());
        onView(withId(R.id.edt_password)).perform(typeText(password), closeSoftKeyboard());
        onView(withId(R.id.btn_login)).perform(click());
        System.console().writer().println("Before setup ran");
        Thread.sleep(3000);
        onView(withId(R.id.textSearch)).perform(typeText("sa"), closeSoftKeyboard()).check(matches(isDisplayed()));
        onView(withText(driverName)).inRoot(withDecorView(not(is(mActivityRule.getActivity().getWindow().getDecorView()))))
       .perform(click());
        onView(withId(R.id.fab)).perform(click());
//        onView(withId(R.id.drawer_layout)).perform(open());
//        onView(withText("Logout")).perform(click());

    }

}
