package com.gap.component;

public class gap_component extends BaseTestHelper {

    public String gap_user = "tester@growthaccelerationpartners.com";
    public String gap_password = "asdf1234";
    public String valid_public_id = "123456789";
    public String enterInvalidPublicID = "abcdefg";

// ***** Clicks *****

    /**Click Submit Button*/
    public void clickSignIn() {
        click(".submit");
    }

    /**Click Public ID Link*/
    public void clickPublicID() {
        click("#content>p>a");
    }

    /**Click Find Employee Button*/
    public void clickFindEmployee() {
        click(".actions>input");
    }

    /**Click Create New Employee Button*/
    public void clickCreateNewEmployee() {
        click("#content>p>a");
    }

    /**Click Create New Employee Final Button*/
    public void clickCreateNewEmployeeFinal() {
        click(".actions>input");
    }

    /**Click Total Days Random number to 5*/
    public void clickTotalDays() {
        int total_click = randomInt(5);
        int i = 0;
        do {
            click(".number-spin-btn.number-spin-btn-up");
        } while (i == total_click);
    }

    /**Click Create Vacation Button*/
    public void clickCreateVacation() {
        click(".actions>input");
    }

// ***** Send Keys *****

    /**Enter GAP User*/
    public void enterEmail() {
        String term = gap_user;
        sendKeys("#user_email",term);
    }

    /**Enter Password Data*/
    public void enterPass() {
        String term = gap_password;
        sendKeys("#user_password",term);
    }

    /**Enter Valid Public ID Data*/
    public void enterValidPublicID() {
        String term = valid_public_id;
        sendKeys("#employee_identification",term);
    }

    /**Enter Invalid Public ID Data*/
    public void enterInvalidPublicID() {
        String term = enterInvalidPublicID;
        sendKeys("#employee_identification",term);
    }

    /**Enter First Name Data*/
    public void enterFirstName(String term) {
        sendKeys("#employee_first_name",term);
    }

    /**Enter Last Name Data*/
    public void enterLasttName(String term) {
        sendKeys("#employee_last_name",term);
    }

    /**Enter Mail Data*/
    public void enterEmail(String term) {
        sendKeys("#employee_email",term);
    }

    /**Enter Id Data*/
    public void enterIdentification(String term) {
        sendKeys("#employee_identification",term);
    }

    /**Enter Leader Name Data*/
    public void enterLearderName(String term) {
        sendKeys("#employee_leader_name",term);
    }

    /**Enter Since Day Data*/
    public void enterSince(String term) {
        sendKeys("#vacation_since",term);
    }

    /**Enter Until Day Data*/
    public void enterUntil(String term) {
        sendKeys("#vacation_until",term);
    }

    /**Enter Request On Data*/
    public void enterRequestedOn(String term) {
        sendKeys("#vacation_requested_on",term);
    }

    /**Enter Vacation Description Data*/
    public void enterVacationDescription() {
        sendKeys("#vacation_description","Just need some days of sun!!!");
    }

// ***** Element Present *****

    /**Return if Gap Logo Present on Site*/
    public boolean isGapLogoPresent() {
        return checkIfElementFound("#logo");
    }

    /**Return if Welcome Message Present on Site*/
    public boolean isGapWelcomeMessagePresent() {
        return checkIfElementFound(".flash_notice");
    }

    /**Return if Page Tittle Present on Site*/
    public boolean isPageTittlePresent() {
        return checkIfElementFound("#content>h1");
    }

// ***** GetText *****

    /**Return Result Data*/
    public String getResult(){
        return getText("#content>h1");
    }

    /**Return Message Data*/
    public String getMessage(){
        return getText("#notice");
    }

    /**Return Error Message Data*/
    public String getErrorMessage(){
        return getText("#content>h1");
    }

// ***** Random Drop Down Selects *****

    /**Select Random Year*/
    public void selectYear(){
        selectRandomOptionInSelect("#employee_start_working_on_1i");
    }

    /**Select Random Month*/
    public void selectMonth(){
        selectRandomOptionInSelect("#employee_start_working_on_2i");
    }

    /**Select Random Day*/
    public void selectDay(){
        selectRandomOptionInSelect("#employee_start_working_on_3i");
    }

    /**Select Random Type of Change*/
    public void selectTypeOfChange(){
        selectRandomOptionInSelect("#vacation_type");
    }

}









