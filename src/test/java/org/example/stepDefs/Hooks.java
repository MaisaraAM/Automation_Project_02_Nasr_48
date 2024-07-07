package org.example.stepDefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.IOException;
import java.time.Duration;

public class Hooks {
    public static WebDriver driver;
    public static int currentIndex = 0;

    @Before
    public void setUp() throws IOException {
        if (currentIndex % 3 == 0) {
            driver = new FirefoxDriver();
        } else if (currentIndex % 3 == 1) {
            driver = new EdgeDriver();
        } else if (currentIndex % 3 == 2) {
            driver = new ChromeDriver();
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(configurations.getFake("URL"));
    }

    @After
    public void quit() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
        currentIndex += 1;
    }
}