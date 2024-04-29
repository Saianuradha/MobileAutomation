package SpotAndPlayApp;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

@Test(priority = 1)
    public void LoginTestWithValidCredentials()  {

        //loginPage.enterLoginDetails("testm04@gmail.com","Test@1234");

        driver.findElement(By.id("com.spot.play:id/edtEmail")).sendKeys("testm04@gmail.com");
        driver.findElement(By.id("com.spot.play:id/edtPassword")).sendKeys("Test@1234");
        driver.findElement(By.id("com.spot.play:id/btnContinue")).click();
        Assert.assertTrue(driver.findElement(AppiumBy.accessibilityId("Home")).isDisplayed());

    }
    @Test(priority = 2)
    public void LoginTestWithInValidCredentials() {

        driver.findElement(By.
                id("com.spot.play:id/edtEmail")).sendKeys("testm04@gmail.com");
        driver.findElement(By.id("com.spot.play:id/edtPassword")).sendKeys("Test@123456");
        driver.findElement(By.id("com.spot.play:id/btnContinue")).click();
        Assert.assertTrue(driver.findElement(By.id("com.spot.play:id/alertTitle")).isDisplayed());
        String alertText = driver.findElement(By.id("android:id/message")).getText();
        Assert.assertEquals(alertText, "Invalid Username or Password");

    }
    @Test(priority = 3)
    public void LoginTestWithForgotPassword() {

        driver.findElement(By.id("com.spot.play:id/btnForgotPass")).click();
        Assert.assertTrue(driver.findElement(By.id("com.spot.play:id/alertTitle")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.id("android:id/message")).isDisplayed());
        String alertText = driver.findElement(By.id("android:id/message")).getText();
        Assert.assertEquals(alertText, "Do you have the verification code already?");
        driver.findElement(By.id("android:id/button1")).click();
        Assert.assertTrue(driver.findElement(By.id("com.spot.play:id/tvTitle")).isDisplayed());
        String PageTitle = driver.findElement(By.id("com.spot.play:id/tvTitle")).getText();
        Assert.assertEquals(PageTitle, "Reset Password");

    }
}
