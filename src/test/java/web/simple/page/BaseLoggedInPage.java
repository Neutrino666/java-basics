package web.simple.page;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class BaseLoggedInPage extends BasePage {
    private By loggedInEmail = By.xpath("//a[text()='Моё обучение']");
    private By profileNavBar = By.xpath("//img[@class='navbar__profile-img']");
    private By profileLink = By.xpath("//a[text()='Профиль']");

    public BaseLoggedInPage(WebDriver driver) {
        super(driver);
    }

    public boolean isLoggedIn(String myCourse) {
        try {
            return waitVisibility(loggedInEmail).getText().equals(myCourse);
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            return false;
        }
    }

    public BaseLoggedInPage openProfileNavBar() {
        waitAndClick(profileNavBar);
        return this;
    }

    public ProfilePage openProfile(){
        openProfileNavBar();
        waitAndClick(profileLink);

        return new ProfilePage(driver);
    }
}
