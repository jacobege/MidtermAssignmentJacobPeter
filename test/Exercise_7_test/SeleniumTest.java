package Exercise_7_test;

import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumTest {
    @Test
    public void testPolyteknisk() {
        
        //Setup  
        WebDriver driver = new FirefoxDriver();
        driver.get("http://www.polyteknisk.dk/home");
        
        //Part 1
        WebElement element = driver.findElement(By.id("super_search_input_field"));

        element.sendKeys("Silberschatz");
        
        List<WebElement> elementsByTagNameForm = driver.findElements(By.tagName("form"));
        
        for(WebElement elem : elementsByTagNameForm) {
            if (elem.getAttribute("action").equals("http://www.polyteknisk.dk/home/Soegeresultat")) {
                elem.submit();
                break;
            }
        }
        
        //Part 2
        List<WebElement> elementsByClassName = driver.findElements(By.className("imprint"));
        
        for (WebElement elem : elementsByClassName) {
            System.out.println("Publisher: " + elem.getText());
        }
        
        //Part 3
        List<WebElement> elementsById = driver.findElements(By.id("id"));
        
        for (WebElement elem : elementsById) {
            if (elem.getAttribute("value").equals("9781259252983")) {
                elem.submit();
                break;
            }
        }
        
        List<WebElement> elementsByTagNameA = driver.findElements(By.tagName("a"));
        
        for(WebElement elem : elementsByTagNameA) {
            if (elem.getAttribute("title").equals("Gå til checkout")) {
                elem.click();
                break;
            }
        }
        
        //Part 4
        WebElement elementsByClassNameContent = driver.findElement(By.className("content"));
        
        assertNotEquals(elementsByClassNameContent.getText().trim(), "Kurven er tom");
        
        List<WebElement> elementsByTagNameA_0 = driver.findElements(By.tagName("a"));
        
        boolean found = false;
        for(WebElement elem : elementsByTagNameA_0) {
            String attr = elem.getAttribute("href");
            if (attr != null && attr.equals("http://www.polyteknisk.dk/home/Detaljer/9781259252983")) {
                found = true;
            }
        }
        assertTrue(found);
        
        
        //Part 5
        List<WebElement> elementsByClassNamePriceTotal = driver.findElements(By.className("price_total"));
        
        assertTrue(elementsByClassNamePriceTotal.size() == 1);
        
        assertEquals("778,50 dkk.", elementsByClassNamePriceTotal.get(0).getText().trim());
        
        //Close the browser
        driver.quit();
    }
}