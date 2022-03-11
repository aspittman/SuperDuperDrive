package com.udacity.jwdnd.course1.cloudstorage.home;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.web.servlet.MockMvc;

@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HomeControllerTests {

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

        WebElement filesTab = driver.findElement(By.id("nav-files-tab"));
        filesTab.click();
        WebElement browse = driver.findElement(By.id("fileUpload"));
        browse.sendKeys("/home/razorx1/Documents/testnote2");
        WebElement selectFile = driver.findElement(By.id("fileSubmit"));
        selectFile.click();
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
        WebElement addNotes = driver.findElement(By.id("add-note-button"));
        addNotes.click();

        WebElement closeSelection = driver.findElement(By.id("note-close"));
        closeSelection.click();

        WebElement noteTitle = driver.findElement(By.id("note-title"));
        WebElement noteDescription = driver.findElement(By.id("note-description"));
        noteTitle.sendKeys("Test");
        noteDescription.sendKeys("Test Description");
        WebElement noteSelect = driver.findElement(By.id("noteSave"));
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(noteSelect));
        noteSelect.click();

        Assertions.assertEquals("http://localhost:" + this.port + "/home", driver.getCurrentUrl());
        Assertions.assertEquals("Home", driver.getTitle());

        WebElement logout = driver.findElement(By.id("logout-button"));
        WebDriverWait logoutWait = new WebDriverWait(driver, 20);
        logoutWait.until(ExpectedConditions.visibilityOf(logout));
        logout.click();
    }

    @Test
    public void homePageCredentialsTest() {
        driver.get("http://localhost:" + this.port + "/home");
        Assertions.assertEquals("http://localhost:" + this.port + "/home", driver.getCurrentUrl());

        WebElement credentialsTab = driver.findElement(By.id("nav-credentials-tab"));
        credentialsTab.click();
        WebElement addCredentials = driver.findElement(By.id("add-credential"));
        addCredentials.click();
        WebElement closeSelection = driver.findElement(By.id("credential-close"));
        closeSelection.click();

        WebElement url = driver.findElement(By.id("credential-url"));
        WebElement username = driver.findElement(By.id("credential-username"));
        WebElement password = driver.findElement(By.id("credential-password"));
        url.sendKeys("http://localhost:" + this.port + "/test");
        username.sendKeys("Dan");
        password.sendKeys("Smith");
        WebElement credentialSave = driver.findElement(By.id("credential-save"));
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(credentialSave));
        credentialSave.click();

        Assertions.assertEquals("http://localhost:" + this.port + "/home", driver.getCurrentUrl());
        Assertions.assertEquals("Home", driver.getTitle());

        WebElement logout = driver.findElement(By.id("logout-button"));
        WebDriverWait logoutWait = new WebDriverWait(driver, 20);
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
