package web.simple.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends ProfilePage {
    private By openLogin = By.xpath("//a[text()='Войти']");
    private By loginBox = By.name("login");
    private By passwordBox = By.name("password");
    private By processLogin = By.xpath("//*[@class='sign-form__btn button_with-loader ']");

    public LoginPage(WebDriver driver) {
        super(driver);
        driver.get(BASE_URL);

        waitAndClick(openLogin);
        waitVisibility(loginBox);
    }

    public LoginPage typeLogin(String email) {
        driver.findElement(loginBox).sendKeys(email);
        return this;
    }

    public LoginPage typePassword(String password) {
        driver.findElement(passwordBox).sendKeys(password);
        return this;
    }

    public SearchPage clickLogin() {
        /*
        обернуть в try/catсh при ошибке возвращать форму LoginPage иначе SearchPage
         */
        driver.findElement(processLogin).click();
        return new SearchPage(driver);
    }

    public SearchPage loginAs(String email, String password) {
        typeLogin(email);
        typePassword(password);
        return clickLogin();
    }
}
