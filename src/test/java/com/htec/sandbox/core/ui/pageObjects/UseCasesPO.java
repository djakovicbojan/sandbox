package com.htec.sandbox.core.ui.pageObjects;

import com.htec.sandbox.steps.BaseSteps;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UseCasesPO extends BaseSteps {

    public String useCases = "//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div[2]/div/a/div/span/img";
    public String createUseCaseButton = "//*[@id=\"root\"]/div/div[2]/div/a[2]";

    public String titleField = "title";
    public String descriptionField = "description";
    public String expectedResultField = "expected_result";
    public String automationSwitch = "//*[@id=\"root\"]/div/div[2]/div/div/div/form/div[4]/div/div/label";
    public String stepField = "stepId";
    public String submitButton = "//*[@data-testid=\"submit_btn\"]";



    public void navigateToUseCasePage() {

        WebDriverWait wait = new WebDriverWait(driver, 10);

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(useCases)));
        driver.findElement(By.xpath(useCases)).click();

    }

    public void createUseCases() {

        WebDriverWait wait = new WebDriverWait(driver, 10);

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(createUseCaseButton)));
        driver.findElement(By.xpath(createUseCaseButton)).click();

        driver.findElement(By.name(titleField)).sendKeys(random.nextObject(String.class));
        driver.findElement(By.name(descriptionField)).sendKeys(random.nextObject(String.class));
        driver.findElement(By.name(expectedResultField)).sendKeys(random.nextObject(String.class));
        driver.findElement(By.xpath(automationSwitch)).click();
        driver.findElement(By.id(stepField)).sendKeys(random.nextObject(String.class));

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(submitButton)));
        driver.findElement(By.xpath(submitButton)).click();
    }

    public void editUseCases(int useCase) {

        String useCaseButton = "//*[@id=\"root\"]/div/div[2]/div/div/a[" + useCase + "]";

        WebDriverWait wait = new WebDriverWait(driver, 10);

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(useCaseButton)));
        driver.findElement(By.xpath(useCaseButton)).click();

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.name(titleField)));

        String title = driver.findElement(By.name(titleField)).getAttribute("value");
        int titleLength = title.length();
        String description = driver.findElement(By.name(descriptionField)).getAttribute("value");
        int descriptionLength = description.length();
        String expected = driver.findElement(By.name(expectedResultField)).getAttribute("value");
        int expectedLength = expected.length();
        String step = driver.findElement(By.id(stepField)).getAttribute("value");
        int stepLength = step.length();


        driver.findElement(By.name(titleField)).clear();
        driver.findElement(By.name(titleField)).sendKeys(
                Keys.chord("This field previously had " + titleLength + " characters"));

        driver.findElement(By.name(descriptionField)).clear();
        driver.findElement(By.name(descriptionField)).sendKeys(
                Keys.chord("This field previously had " + descriptionLength + " characters"));

        driver.findElement(By.name(expectedResultField)).clear();
        driver.findElement(By.name(expectedResultField)).sendKeys(
                Keys.chord("This field previously had " + expectedLength + " characters"));

        driver.findElement(By.id(stepField)).clear();
        driver.findElement(By.id(stepField)).sendKeys(
                Keys.chord("This field previously had " + stepLength + " characters"));

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(submitButton)));
        driver.findElement(By.xpath(submitButton)).click();
    }


}
