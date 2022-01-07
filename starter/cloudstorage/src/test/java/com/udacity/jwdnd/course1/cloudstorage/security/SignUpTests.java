package com.udacity.jwdnd.course1.cloudstorage.security;

import com.udacity.jwdnd.course1.cloudstorage.services.UserService;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SignUpTests {

    @LocalServerPort
    private int port;

    @Autowired
    private UserService userService;

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
    public void basicUserRegistration() throws Exception {
        driver.get("http://localhost:" + this.port + "/signup");
        Assertions.assertEquals("Sign Up", driver.getTitle());

        WebElement firstName = driver.findElement(By.id("inputFirstName"));
        WebElement lastName = driver.findElement(By.id("inputLastName"));
        WebElement username = driver.findElement(By.id("inputUsername"));
        WebElement password = driver.findElement(By.id("inputPassword"));

        firstName.sendKeys("Random");
        lastName.sendKeys("Person");
        username.sendKeys("Bob");
        password.sendKeys("password");

        WebElement registerButton = driver.findElement(By.id("buttonSignUp"));
        registerButton.click();
    }

    @AfterEach
    public void afterEach() {
        if (this.driver != null) {
            driver.quit();
        }
    }
}
