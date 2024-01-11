package stepDefinitions;

import base.pageobject.HomePage;
import base.pageobject.LoginPage;
import base.testbase.TestBase;
import base.utilities.BrowserManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.time.Duration;


public class LoginStepsDefinition {

    private final HomePage objectHomePage;
    private final LoginPage objectLoginPage;
    private final TestBase actions;
    private final BrowserManager browser;

    public LoginStepsDefinition(HomePage objectHomePage, LoginPage objectLoginPage, TestBase actions, BrowserManager browser) {
        this.objectHomePage = objectHomePage;
        this.objectLoginPage = objectLoginPage;
        this.actions = actions;
        this.browser = browser;
    }


    @Given("the user is on the homepage")
    public void the_user_is_on_the_homepage(){
        browser.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        actions.navigate("https://www.newspapers.com/");
    }

    @When("the user clicks the Sign in button")
    public void the_user_clicks_the_sign_in_button() throws Exception {
        actions.switchToDefault();
        actions.explicitWait(objectHomePage.Homepage_Newspaper_icn);
        actions.click(objectHomePage.Homepage_SignIn_btn);
    }

    @Then("the user should be on the Login page")
    public void the_user_should_be_on_the_login_page() throws Exception {
        actions.switchToDefault();
        actions.verifyVisibility(objectLoginPage.LoginPage_hdr);
    }

    @And("the user enters {string} and {string}")
    public void the_user_enters_email_and_password(String email, String password) {
       actions.enter(email,objectLoginPage.LoginPage_Email_txtbx);
       actions.enter(password,objectLoginPage.LoginPage_Password_txtbx);
    }

    @And("clicks the login button")
    public void clicks_the_login_button() throws Exception {
        // Write code here that turns the phrase above into concrete actions
        actions.click(objectLoginPage.LoginPage_SignIn_btn);
    }

    @Then("the user should be redirected to the homepage")
    public void the_user_should_be_redirected_to_the_homepage() throws Exception {
        actions.switchToDefault();
        actions.explicitWait(objectHomePage.Homepage_Newspaper_icn);
        actions.verifyVisibility(objectHomePage.Homepage_Newspaper_icn);
    }

    @And ("the user close the browser")
    public void the_user_close_the_browser () {
        browser.close();
    }

    @Then("the user should not be able to login")
    public void theUserShouldNotBeAbleToLogin() throws Exception {
        actions.switchToDefault();
        actions.explicitWait(objectLoginPage.LoginPage_errormsg);
        //actions.verifyVisibility(objectLoginPage.LoginPage_errormsg);
    }
}





