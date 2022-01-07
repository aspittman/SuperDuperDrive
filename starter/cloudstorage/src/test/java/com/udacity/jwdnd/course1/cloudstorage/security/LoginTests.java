package com.udacity.jwdnd.course1.cloudstorage.security;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class LoginTests {

    @LocalServerPort
    private int port;

    private WebDriver driver;

    @BeforeAll
    static void beforeAll() {
        WebDriverManager.firefoxdriver().setup();
    }

    @BeforeEach
    public void beforeEach() {
        this.driver = new FirefoxDriver();
    }

    @Test
    public void unsecuredPagesAccessibilityTest() {
        driver.get("http://localhost:" + this.port + "/login");
        Assertions.assertEquals("Login", driver.getTitle());

        Actions actionProvider = new Actions(driver);
        WebElement signupButton = driver.findElement(By.linkText("Click here to sign up"));
        actionProvider.click(signupButton).build().perform();

        driver.get("http://localhost:" + this.port + "/signup");
        Assertions.assertEquals("Sign Up", driver.getTitle());

        Actions secondActionProvider = new Actions(driver);
        WebElement backToLogin = driver.findElement(By.linkText("Back to Login"));
        secondActionProvider.click(backToLogin).build().perform();
    }

    @Test
    public void incorrectLoginTest() throws Exception {
        driver.get("http://localhost:" + this.port + "/login");
        Assertions.assertEquals("Login", driver.getTitle());

        WebElement username = driver.findElement(By.id("inputUsername"));
        WebElement password = driver.findElement(By.id("inputPassword"));
        username.sendKeys("kjsda");
        password.sendKeys("iifdb");

        WebElement searchBtn = driver.findElement(By.id("login-button"));
        searchBtn.click();

        Assertions.assertEquals("http://localhost:" + this.port + "/login?error", driver.getCurrentUrl());
        Assertions.assertEquals("Login", driver.getTitle());
    }

    @Test
    public void correctLoginTest() throws Exception {
        driver.get("http://localhost:" + this.port + "/login");
        Assertions.assertEquals("Login", driver.getTitle());

        WebElement username = driver.findElement(By.id("inputUsername"));
        WebElement password = driver.findElement(By.id("inputPassword"));
        username.sendKeys("first");
        password.sendKeys("second");

        WebElement searchBtn = driver.findElement(By.id("login-button"));
        searchBtn.click();

        Assertions.assertEquals("http://localhost:" + this.port + "/home", driver.getCurrentUrl());
        Assertions.assertEquals("Home", driver.getTitle());
    }

    @AfterEach
    public void afterEach() {
        if (this.driver != null) {
            driver.quit();
        }
    }
}
