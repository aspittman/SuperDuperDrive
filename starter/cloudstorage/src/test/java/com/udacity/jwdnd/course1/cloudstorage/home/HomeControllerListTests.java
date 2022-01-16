package com.udacity.jwdnd.course1.cloudstorage.home;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HomeControllerListTests {

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
        driver.get("http://localhost:" + this.port + "/login");
        Assertions.assertEquals("Login", driver.getTitle());

        WebElement username = driver.findElement(By.id("inputUsername"));
        WebElement password = driver.findElement(By.id("inputPassword"));
        username.sendKeys("first");
        password.sendKeys("second");

        WebElement searchBtn = driver.findElement(By.id("login-button"));
        searchBtn.click();
    }

    @Test
    public void homePageFilesTest() {
        driver.get("http://localhost:" + this.port + "/home");
        Assertions.assertEquals("http://localhost:" + this.port + "/home", driver.getCurrentUrl());

        WebElement filesList = driver.findElement(By.id("fileTable"));
        Assertions.assertTrue(filesList.isDisplayed());
        WebElement viewFile = driver.findElement(By.id("view-file"));
        viewFile.click();
        WebElement deleteFile = driver.findElement(By.id("delete-file"));
        deleteFile.click();

        Assertions.assertEquals("http://localhost:" + this.port + "/home", driver.getCurrentUrl());
        Assertions.assertEquals("Home", driver.getTitle());

        WebElement logout = driver.findElement(By.id("logout-button"));
        logout.click();
    }

    @Test
    public void homePageNotesTest() {
        driver.get("http://localhost:" + this.port + "/home");
        Assertions.assertEquals("http://localhost:" + this.port + "/home", driver.getCurrentUrl());

        WebElement notesTab = driver.findElement(By.id("nav-notes-tab"));
        notesTab.click();

        WebElement editNote = driver.findElement(By.id("edit-note"));
        editNote.click();

        WebElement closeEditNote = driver.findElement(By.id("note-close"));
        WebDriverWait windowWait = new WebDriverWait(driver, 5);
        windowWait.until(ExpectedConditions.visibilityOf(closeEditNote));
        closeEditNote.click();

        WebElement deleteNote = driver.findElement(By.id("delete-note"));
        WebDriverWait deleteWait = new WebDriverWait(driver, 5);
        deleteWait.until(ExpectedConditions.visibilityOf(deleteNote));
        deleteNote.click();

        Assertions.assertEquals("http://localhost:" + this.port + "/home", driver.getCurrentUrl());
        Assertions.assertEquals("Home", driver.getTitle());

        WebElement logout = driver.findElement(By.id("logout-button"));
        WebDriverWait logoutWait = new WebDriverWait(driver, 5);
        logoutWait.until(ExpectedConditions.visibilityOf(logout));
        logout.click();
    }

    @Test
    public void homePageCredentialsTest() {
        driver.get("http://localhost:" + this.port + "/home");
        Assertions.assertEquals("http://localhost:" + this.port + "/home", driver.getCurrentUrl());

        WebElement credentialsTab = driver.findElement(By.id("nav-credentials-tab"));
        credentialsTab.click();

        WebElement editCredential = driver.findElement(By.id("edit-credential"));
        editCredential.click();

        WebElement closeEditCredential = driver.findElement(By.id("credential-close"));
        WebDriverWait windowWait = new WebDriverWait(driver, 5);
        windowWait.until(ExpectedConditions.visibilityOf(closeEditCredential));
        closeEditCredential.click();

        WebElement deleteCredential = driver.findElement(By.id("delete-credential"));
        WebDriverWait deleteWait = new WebDriverWait(driver, 5);
        deleteWait.until(ExpectedConditions.visibilityOf(deleteCredential));
        deleteCredential.click();

        Assertions.assertEquals("http://localhost:" + this.port + "/home", driver.getCurrentUrl());
        Assertions.assertEquals("Home", driver.getTitle());

        WebElement logout = driver.findElement(By.id("logout-button"));
        WebDriverWait logoutWait = new WebDriverWait(driver, 5);
        logoutWait.until(ExpectedConditions.visibilityOf(logout));
        logout.click();
    }

    @AfterEach
    public void afterEach() {
        if (this.driver != null) {
            driver.quit();
        }
    }
}
