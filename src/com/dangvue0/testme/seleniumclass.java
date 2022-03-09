package com.dangvue0.testme;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

class seleni {
    ChromeDriver driver;
    String defaultwindow;

    public String getDefaultwindow() {
        return defaultwindow;
    }

    public void setprop() {
        System.setProperty("webdriver.chrome.driver","/Users/dangvue0/Downloads/chromedriver");
    }

    public void startChrome() {
        this.driver = new ChromeDriver();
    }

    public void searchyoutube(String searchword) {
        this.driver.get("https://www.youtube.com");
        this.defaultwindow = this.driver.getWindowHandle();
    }

    public void searchyoutube(){
        this.driver.get("https://www.youtube.com");
        this.defaultwindow = this.driver.getWindowHandle();
    }

    public void opentab(String tempWord) {

        if (this.driver == null) {
            setprop();
            startChrome();
            searchyoutube();
            gui.maintab = this.defaultwindow;
        }

        try{
            this.driver.executeScript("window.open(\"https://www.youtube.com\")");
            for(String windowhandle: this.driver.getWindowHandles()) {
                this.driver.switchTo().window(windowhandle);
            }
            List<WebElement> webEles = this.driver.findElements( By.id("search"));
            for (WebElement webele: webEles) {
                if (webele.getTagName().equals("input")) {
                    webele.click();
                    webele.sendKeys(tempWord + Keys.ENTER);
                }
            }
        }finally {

            }

    }
}

