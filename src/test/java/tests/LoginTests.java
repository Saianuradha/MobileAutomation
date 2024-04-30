package tests;
import Pages.LoginPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    @Test(priority = 1)
    public void LoginTestWithValidCredentials()  {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterLoginDetails("testm04@gmail.com","Test@1234");
        Assert.assertTrue(loginPage.homeMenu.isDisplayed(), "Home menu is not displayed after login");
    }
    @Test(priority = 2)
    public void LoginTestWithInValidCredentials() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterLoginDetails("testm04@gmail.com","Test@12345");
        Assert.assertTrue(loginPage.alertPopUp.isDisplayed());
        String alertText = loginPage.alertMsg.getText();
        Assert.assertEquals(alertText, "Invalid Username or Password");

    }
    @Test(priority = 3)
    public void LoginTestWithForgotPassword() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.forgotPassButton.click();
        Assert.assertTrue(loginPage.alertPopUp.isDisplayed());
        String alertText = loginPage.alertMsg.getText();
        Assert.assertEquals(alertText, "Do you have the verification code already?");
        loginPage.yesButton.click();
        Assert.assertTrue(loginPage.resetPassTitle.isDisplayed());
        String PageTitle = loginPage.resetPassTitle.getText();
        Assert.assertEquals(PageTitle, "Reset Password");

    }
}
