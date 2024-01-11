package base.pageobject;

public class LoginPage {

    public final String LoginPage_Email_txtbx = "//input[@placeholder='Email']";
    public final String LoginPage_Password_txtbx = "//input[@placeholder='Password']";
    public final String LoginPage_SignIn_btn = "//button[@title='Sign in with Newspapers.com']";
    public final String LoginPage_hdr ="//h1[text()='Sign in to Newspapers.com™']";
    public final String LoginPage_errormsg ="//div[text()='There is a problem with your email/password.']";
}
