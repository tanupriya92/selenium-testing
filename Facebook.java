package org.examples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Facebook {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","src/test/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://facebook.com/");
        driver.manage().window().maximize();

        driver.findElement(By.id("email")).sendKeys("patebij@gmail.com");
        driver.findElement(By.id("pass")).sendKeys("test@123");
        driver.findElement(By.id("u_0_d_JT")).click();

        if(driver.findElement(By.xpath("(//a[text()='Logout'])[1]")).isEnabled()){
            System.out.println("Logout link is present in homepage");
        }
        else
        {
            System.out.println("Logout link is not present ");
        }


    }
}



