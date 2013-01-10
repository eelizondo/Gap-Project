package com.gap.tests;

import com.gap.component.gap_component;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**

 @Test : test_Public_ID
 OK - Navigate to http://rocky-escarpment-5701.herokuapp.com/users/sign_in
 OK - Validate Correct page displayed
 OK - Click public site link
 OK - Enter User ID [ 1234567890 ]
 OK - Click Find Employee
 OK - Validate Data Displayed Match User Data

 [Negative Test]
 @Test : test_Public_Invalid_ID
 OK - Navigate to http://rocky-escarpment-5701.herokuapp.com/users/sign_in
 OK - Validate Correct page displayed
 OK - Click public site link
 OK - Enter Invalid User ID [ notvalid ]
 OK - Click Find Employee
 OK - Validate Error Message Displayed

 */

public class test_Public_ID extends gap_component {

    @Test
    public void test_Gap_Valid_Public_ID(){

        access_Gap();
        assertTrue(isGapLogoPresent(), "Site not loaded correctly not displayed!!!");
        clickPublicID();
        enterValidPublicID();
        clickFindEmployee();
        String compare_result = getResult();
        assertEquals(compare_result, "HI TEST USER,", "Term not found");

    }

    @Test
    public void test_Gap_Invalid_Public_ID(){

        access_Gap();
        assertTrue(isGapLogoPresent(), "Site not loaded correctly not displayed!!!");
        clickPublicID();
        enterInvalidPublicID();
        clickFindEmployee();
        String compare_result = getErrorMessage();
        assertEquals(compare_result, "NO EMPLOYEE FOUND WITH THAT IDENTIFICATION", "Term not found");

    }

}
