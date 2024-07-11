package org.example.stepDefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class Hooks {
    public static WebDriver driver;
    public static int currentIndex = 0;

    @Before
    public void setUp() throws IOException, InterruptedException {
        FirefoxProfile ffProf = new FirefoxProfile();
        FirefoxOptions ffOpt = new FirefoxOptions();
        ffProf.addExtension(new File(configurations.getConfig("ffUB0")));
        ffOpt.setProfile(ffProf);

        EdgeOptions edOpt = new EdgeOptions();
        edOpt.addExtensions(new File(configurations.getConfig("chromeUB0")));

        ChromeOptions chrOpt = new ChromeOptions();
        chrOpt.addExtensions(new File(configurations.getConfig("chromeUB0")));

        if (currentIndex % 3 == 0) {
            driver = new FirefoxDriver(ffOpt);
        } else if (currentIndex % 3 == 1) {
            driver = new EdgeDriver(edOpt);
        } else if (currentIndex % 3 == 2) {
            driver = new ChromeDriver(chrOpt);
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //  Wait for extensions to load
        Thread.sleep(1500);
        driver.get(configurations.getConfig("URL"));
    }

    @After
    public void quit() {
        driver.quit();
        currentIndex += 1;
    }
}