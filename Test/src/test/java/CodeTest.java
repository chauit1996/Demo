import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;


public class CodeTest extends MainTest {
    By inputTextBox = By.xpath("//input[@title='Tìm kiếm']");
    By buttonSearch = By.xpath("//div[@class='FPdoLc lJ9FBc']//input[@value='Tìm trên Google']");
    By pageResult = By.xpath("//h1[text()='Kết quả tìm kiếm']/parent::div//h3[@class='LC20lb MBeuO DKV0Md']");
    By videoResult = By.xpath("//div[@class='uVMCKf aNytqb']//div//span[@class='cHaqb']");
    String inputData = "Demo with selenium";
    String text = "Selenium";

    @Test
    public void TC_01_GoogleSearch() {
        // Wait visible and enter data
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(inputTextBox)).sendKeys(inputData);

        // Wait visible and click
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(buttonSearch)).click();

        // Verify text of Page Result
        List<WebElement> listPageResult = driver.findElements(pageResult);
        for (WebElement listPage : listPageResult) {
            System.out.println(listPage.getText().trim().toLowerCase());
            Assert.assertTrue(listPage.getText().trim().toLowerCase().contains(text.toLowerCase()));
        }
        jsExecutor.executeScript("window.scrollBy(800,1000)");

        // Verify text of Video Result
        List<WebElement> listVideoResult = driver.findElements(videoResult);
        for (WebElement listVideo : listVideoResult) {
            System.out.println(listVideo.getText().trim().toLowerCase());
            Assert.assertTrue(listVideo.getText().trim().toLowerCase().contains(text.toLowerCase()));
        }
    }
}