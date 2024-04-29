package Pages;

import io.appium.java_client.android.AndroidDriver;

public class BasePage {
    public static AndroidDriver driver;
    private LoginPage loginPage;

    public LoginPage getLoginPage() {
        return loginPage;
    }

}
