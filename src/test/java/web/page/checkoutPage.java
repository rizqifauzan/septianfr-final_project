package web.page;

/*import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class checkoutPage {
    WebDriver driver;

    By enterFirstName = By.id("first-name");
    By enterLastName = By.id("last-name");
    By enterZipCode = By.id("postal-code");

    public checkoutPage(WebDriver driver){
        this.driver = driver;
    }

    public void inputFirstName(String firstName){
        driver.findElement(enterFirstName).sendKeys(firstName);
    }

    public void inputLastName(String lastName){
        driver.findElement(enterLastName).sendKeys(lastName);
    }

    public void inputZipCode(int zipCode){
        String convertedZipCode = String.valueOf(zipCode);
        driver.findElement(enterZipCode).sendKeys(convertedZipCode);
    }

    public void clickContinueButton(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement continueBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("continue")));
        continueBtn.click();

        System.out.println("First name field value: " + driver.findElement(enterFirstName).getAttribute("value"));
        System.out.println("Last name field value: " + driver.findElement(enterLastName).getAttribute("value"));
        System.out.println("Postal code value: " + driver.findElement(enterZipCode).getAttribute("value"));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("title")));
    }
}*/

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class checkoutPage {

    WebDriver driver;
    WebDriverWait wait;

    By enterFirstName = By.xpath("//*[@id='first-name']");
    By enterLastName = By.xpath("//*[@id='last-name']");
    By enterZipCode = By.xpath("//*[@id='postal-code']");
    By continueBtn = By.id("continue");

    public checkoutPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public void inputFirstName(String firstName){
        WebElement first = wait.until(ExpectedConditions.visibilityOfElementLocated(enterFirstName));
        first.clear();
        first.sendKeys(firstName);
    }

    public void inputLastName(String lastName){
        WebElement last = wait.until(ExpectedConditions.visibilityOfElementLocated(enterLastName));
        last.clear();
        last.sendKeys(lastName);
    }

    public void inputZipCode(int zipCode){
        WebElement zip = wait.until(ExpectedConditions.visibilityOfElementLocated(enterZipCode));
        zip.clear();
        zip.sendKeys(String.valueOf(zipCode));
    }

    public void clickContinueButton(){
        WebElement continuebtn = wait.until(ExpectedConditions.elementToBeClickable(continueBtn));
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView(true); arguments[0].click();", continuebtn);

        // Wait until the URL actually changes to step two
        wait.until(ExpectedConditions.urlContains("checkout-step-two.html"));
    }
}
