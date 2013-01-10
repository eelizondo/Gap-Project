package com.gap.component;

public class gap_component extends BaseTestHelper {

    public String gap_user = "tester@growthaccelerationpartners.com";
    public String gap_password = "asdf1234";
    public String valid_public_id = "123456789";
    public String enterInvalidPublicID = "abcdefg";

// ***** Clicks *****

    public void clickSignIn() {
        click(".submit");
    }

    public void clickPublicID() {
        click("#content>p>a");
    }

    public void clickFindEmployee() {
        click(".actions>input");
    }

    public void clickCreateNewEmployee() {
        click("#content>p>a");
    }

    public void clickCreateNewEmployeeFinal() {
        click(".actions>input");
    }

    public void clickTotalDays() {
        int total_click = randomInt(5);
        int i = 0;
        do {
            click(".number-spin-btn.number-spin-btn-up");
        } while (i == total_click);

    }

    public void clickCreateVacation() {
        click(".actions>input");
    }

// ***** Send Keys *****

    public void enterEmail() {
        String term = gap_user;
        sendKeys("#user_email",term);
    }

    public void enterPass() {
        String term = gap_password;
        sendKeys("#user_password",term);
    }

    public void enterValidPublicID() {
        String term = valid_public_id;
        sendKeys("#employee_identification",term);
    }

    public void enterInvalidPublicID() {
        String term = enterInvalidPublicID;
        sendKeys("#employee_identification",term);
    }

    public void enterFirstName(String term) {
        sendKeys("#employee_first_name",term);
    }

    public void enterLasttName(String term) {
        sendKeys("#employee_last_name",term);
    }

    public void enterEmail(String term) {
        sendKeys("#employee_email",term);
    }

    public void enterIdentification(String term) {
        sendKeys("#employee_identification",term);
    }

    public void enterLearderName(String term) {
        sendKeys("#employee_leader_name",term);
    }

    public void enterSince(String term) {
        sendKeys("#vacation_since",term);
    }

    public void enterUntil(String term) {
        sendKeys("#vacation_until",term);
    }

    public void enterRequestedOn(String term) {
        sendKeys("#vacation_requested_on",term);
    }

    public void enterVacationDescription() {
        sendKeys("#vacation_description","Just need some days of sun!!!");
    }

// ***** Element Present *****

    public boolean isGapLogoPresent() {
        return checkIfElementFound("#logo");
    }

    public boolean isGapWelcomeMessagePresent() {
        return checkIfElementFound(".flash_notice");
    }

    public boolean isPageTittlePresent() {
        return checkIfElementFound("#content>h1");
    }

// ***** GetText *****

    public String getResult(){
        return getText("#content>h1");
    }

    public String getMessage(){
        return getText("#notice");
    }

    public String getErrorMessage(){
        return getText("#content>h1");
    }

// ***** Random Drop Down Selects *****

    public void selectYear(){
        selectRandomOptionInSelect("#employee_start_working_on_1i");
    }

    public void selectMonth(){
        selectRandomOptionInSelect("#employee_start_working_on_2i");
    }

    public void selectDay(){
        selectRandomOptionInSelect("#employee_start_working_on_3i");
    }

    public void selectTypeOfChange(){
        selectRandomOptionInSelect("#vacation_type");
    }

}









