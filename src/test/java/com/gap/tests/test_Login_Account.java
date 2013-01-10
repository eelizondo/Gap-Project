package com.gap.tests;

import com.gap.component.gap_component;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

/**

 @Test : test_Login_Account
 OK - Navigate to http://rocky-escarpment-5701.herokuapp.com/users/sign_in
 OK - Validate Correct page displayed
 OK - Enter User Term [ tester@growthaccelerationpartners.com ]
 OK - Enter Password Term [ asdf1234 ]
 OK - Click Sign In
 OK - Validate Signed in successfully

 */

public class test_Login_Account extends gap_component {

    @Test
    public void test_Gap_Login_Account(){

        access_Gap();
        assertTrue(isGapLogoPresent(), "Site not loaded correctly not displayed!!!");
        enterEmail();
        enterPass();
        clickSignIn();
        assertTrue(isGapWelcomeMessagePresent(), "User is not Loged In not displayed!!!");

    }

}
