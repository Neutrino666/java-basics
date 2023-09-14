package web;
import com.google.common.io.Resources;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import web.simple.page.LoginPage;

import java.time.Duration;

public class StepikTest {

    private static final String email = "tosters_shcool@rambler.ru";
    private static final String password = "Testgh12";
    private static final String myCourse = "Моё обучение";

    private ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    private WebDriverWait wait;

    @BeforeAll
    public static void setChromeDriver() {
        System.setProperty("webdriver.chrome.driver", Resources.getResource("chromedriver.exe").getPath());
    }

    @BeforeEach
    public void createDriver() {
        driver.set(new ChromeDriver());
        wait = new WebDriverWait(driver.get(), Duration.ofSeconds(5));
    }

    @AfterEach
    public void disposeDriver() {
        if (driver != null) {
            driver.get().quit();
        }
    }

    @Test
    public void login() {
        Assertions.assertTrue(
                new LoginPage(driver.get())
                        .loginAs(email, password)
                        .isLoggedIn(myCourse)
        );
    }

    @Test
    public void openProfile() {
        Assertions.assertTrue(
                new LoginPage(driver.get())
                        .loginAs(email, password)
                        .openProfile()
                .isProfileOpened()
        );
    }
}
