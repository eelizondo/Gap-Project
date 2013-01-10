package com.gap.tests;

import com.gap.component.gap_component;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**

 @Test : test_Dashboard_Element_Present
 OK - Navigate to http://rocky-escarpment-5701.herokuapp.com/users/sign_in
 OK - Validate Correct page displayed
 OK - Enter User Term [ tester@growthaccelerationpartners.com ]
 OK - Enter Password Term [ asdf1234 ]
 OK - Click Sign In
 OK - Validate Signed in successfully
 OK - Click Add Vacation Request [ Vacation Request User ]
 OK - Select Random Type of Change
 OK - Enter Requested on day
 OK - Enter Since day
 OK - Enter Until day
 OK - Update Total days
 OK - Enter Vacation Description
 OK - Click Create Vacation
 OK - Validate Vacation Request Successfully Completed

 */

public class test_Vacation_Request extends gap_component {

    @Test
    public void test_Gap_Vacation_Request(){

        access_Gap();
        assertTrue(isGapLogoPresent(), "Site not loaded correctly not displayed!!!");
        enterEmail();
        enterPass();
        clickSignIn();
        assertTrue(isGapWelcomeMessagePresent(), "User is not Loged In not displayed!!!");

        // Need to improve this
        driver.navigate().to("http://rocky-escarpment-5701.herokuapp.com/employees/14/vacations/new");

        selectTypeOfChange();
        enterRequestedOn(dateToday());
        enterSince(dateSince());
        enterUntil(dateUntil());
        clickTotalDays();
        enterVacationDescription();
        clickCreateVacation();

        String compare_result = getMessage();
        assertEquals(compare_result, "VACATION WAS SUCCESSFULLY CREATED.", "Possible Issues when Creating Vacation Request");

    }

}
