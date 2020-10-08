package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class HomePage extends PageBase {
    public HomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void selectLanguage(String value) {
        Select selectLang = new Select(driver.findElement(By.name("language")));
        selectLang.selectByValue(value);
    }

    public boolean souldBeRussianText() {
        WebElement loginLink = driver.findElement(By.id("login_link"));
        String loginLinkText = loginLink.getText();
        return loginLinkText.equals("Войти или зарегистрироваться");
    }

    public void clickOnGoButton() {
        WebElement goButton = driver.findElement(By.xpath("//button[@class='btn btn-default']"));
        goButton.click();
    }

    public boolean shouldBeLoginLink() {
        WebElement loginLink = driver.findElement(By.id("login_link"));
        return loginLink.isDisplayed();
    }


    public void enterTextInSearchField(String searchValue) {
        WebElement searchField = driver.findElement(By.id("id_q"));
        searchField.clear();
        searchField.sendKeys(searchValue);
    }

    public void clickOnSearchButton() {
        WebElement searchButton = driver.findElement(By.cssSelector("input[type=\"submit\"]"));
        searchButton.click();
    }

    public boolean shouldBeSearchList(String value) {
        WebElement subTitle = driver.findElement(By.cssSelector(".breadcrumb li.active"));
        return subTitle.getText().contains(value);
    }
}
