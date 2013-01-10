package com.gap.tests;

import com.gap.component.gap_component;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**

@Test : test_New_User
 OK - Navigate to http://rocky-escarpment-5701.herokuapp.com/users/sign_in
 OK - Validate Correct page displayed
 OK - Enter User Term [ tester@growthaccelerationpartners.com ]
 OK - Enter Password Term [ asdf1234 ]
 OK - Click Sign In
 OK - Validate Signed in successfully
 OK - Click Create a new employee
 OK - Enter Random First Name
 OK - Enter Random Last Name
 OK - Enter Random Email
 OK - Enter Random Identification
 OK - Enter Random Leader name
 OK - Enter Random Start Working on

 First name: Test_Name + random number
 Last name: Test_LastName + random number
 Email: test + random number @whoknow.com
 Identification: 123456789 + random number
 Leader name: Same as First Name
 Start working on:
    Random Year;
    Random Month;
    Random Day;

 OK - Click Create Employee
 OK - Validate Successfully message

 */

public class test_New_User extends gap_component {

    @Test
    public void test_Gap_New_User(){

        access_Gap();
        assertTrue(isGapLogoPresent(), "Site not loaded correctly not displayed!!!");
        enterEmail();
        enterPass();
        clickSignIn();
        assertTrue(isGapWelcomeMessagePresent(), "User is not Loged In not displayed!!!");

        clickCreateNewEmployee();
        assertTrue(isPageTittlePresent(), "Site not loaded correctly not displayed!!!");

        String MyName = randomizeData("Edber");
        String MyLastName = randomizeData("Elizondo");
        String MyEmail = randomizeEmail("test@whoknow.com");
        String MyId = randomizeData("123456");

        enterFirstName(MyName);
        enterLasttName(MyLastName);
        enterEmail(MyEmail);
        enterIdentification(MyId);
        enterLearderName(MyName);

        selectYear();
        selectMonth();
        selectDay();

        clickCreateNewEmployeeFinal();

        String compare_result = getMessage();
        assertEquals(compare_result, "EMPLOYEE WAS SUCCESSFULLY CREATED.", "Possible Issues when Creating New User");

    }

}
