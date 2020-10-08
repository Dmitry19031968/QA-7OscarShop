import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ProductPageTests extends TestBase {

    @Test(priority = 0)
    public void testUserCanAddProductToBasket(){
        WebElement submenuBooks = driver.findElement(By.className("dropdown-submenu"));
        submenuBooks.click();

        List<WebElement> bookList = driver.findElements(By.className("product_pod"));
        String bookTitle = bookList.get(0).findElement(By.tagName("h3")).getText();
        System.out.println(bookTitle);

        String bookPrice = bookList.get(0).findElement(By.className("price_color")).getText();
        System.out.println(bookPrice);

        bookList.get(0).click();

        WebElement addToBasketButton =driver.findElement(By.className("btn-add-to-basket"));
        addToBasketButton.click();
        List<WebElement> alertList = driver.findElements(By.className("alert"));
        Assert.assertEquals(alertList.size(), 3, "Success messages are not display");
    }

    @Test(priority = 1)
    public void testVerifyingProductNameAndPriceInMessages() throws InterruptedException {
        WebElement submenuBooks = driver.findElement(By.className("dropdown-submenu"));
        submenuBooks.click();
        List<WebElement> bookList = driver.findElements(By.className("product_pod"));
        String bookTitle = bookList.get(0).findElement(By.tagName("h3")).getText();
        System.out.println(bookTitle);
        String bookPrice = bookList.get(0).findElement(By.className("price_color")).getText();
        System.out.println(bookPrice);
        bookList.get(0).click();
        WebElement addToBasketButton =driver.findElement(By.className("btn-add-to-basket"));
        addToBasketButton.click();
        List<WebElement> alertList = driver.findElements(By.className("alert"));
        List<WebElement> alertMessages = driver.findElements(By.cssSelector(".alertinner strong"));
        Thread.sleep(3000);
        String bookTitleInMessage = alertMessages.get(0).getText();
        System.out.println(bookTitleInMessage);
        String bookPriceInMessage = alertMessages.get(2).getText();
        System.out.println(bookPriceInMessage);
        Assert.assertEquals(bookTitle, bookTitleInMessage);
        Assert.assertEquals(bookPrice, bookPriceInMessage);

    }
}
