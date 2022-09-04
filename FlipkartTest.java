package org.examples;

import com.opencsv.CSVWriter;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class FlipkartTest {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.flipkart.com/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS);

        driver.findElement(By.cssSelector("._2KpZ6l._2doB4z")).click();
        driver.findElement(By.name("q")).getText();
        driver.findElement(By.name("q")).clear();
        driver.findElement(By.name("q")).sendKeys("smartwatch");
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);

        String text = driver.findElement(By.className("_4rR01T")).getText();
        String price = driver.findElement(By.cssSelector("._30jeq3._1_WHN1")).getText();


        String outputFile = "test.csv";
        boolean alreadyExists = new File(outputFile).exists();

        try {
            // use FileWriter constructor that specifies open for appending
            CSVWriter writer = new CSVWriter(new FileWriter(outputFile, true),',');

            // if the file didn't already exist then we need to write out the header line
            if (!alreadyExists){
                String[] header = { "Name", "Amount"};
                writer.writeNext(header);
            }

            // add data to csv
            String[] data1 = { text, price };
            writer.writeNext(data1);

            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        driver.close();
    }

}
