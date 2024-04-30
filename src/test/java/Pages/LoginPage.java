package Pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    @FindBy(id = "com.spot.play:id/edtEmail")
    public WebElement emailInput;

    @FindBy(id = "com.spot.play:id/edtPassword")
    public WebElement passwordInput;

    @FindBy(id = "com.spot.play:id/btnContinue")
    public WebElement continueButton;
    @FindBy(id = "com.spot.play:id/btnForgotPass")
    public WebElement forgotPassButton;
    @FindBy(id = "android:id/button1")
    public WebElement yesButton;

    @AndroidFindBy(accessibility = "Home")
    public WebElement homeMenu;

    @FindBy(id = "com.spot.play:id/alertTitle")
    public WebElement alertPopUp;

    @FindBy(id = "android:id/message")
    public WebElement alertMsg;
    @FindBy(id = "com.spot.play:id/tvTitle")
    public WebElement resetPassTitle;
    public LoginPage(AndroidDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void enterLoginDetails(String email,String password) {
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        continueButton.click();
    }
}
