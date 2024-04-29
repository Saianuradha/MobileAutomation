package Pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private final AndroidDriver driver;
    public LoginPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterLoginDetails(String email,String password) {
        driver.findElement(By.id("com.spot.play:id/edtEmail")).sendKeys(email);
        driver.findElement(By.id("com.spot.play:id/edtPassword")).sendKeys(password);
        driver.findElement(By.id("com.spot.play:id/btnContinue")).click();
    }
}
