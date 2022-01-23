package pageObject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    WebDriver driver;

    public HomePage(WebDriver remoteDriver){
        driver = remoteDriver;
    }

    public EmpleoPage clickBtnEmpleo() {    // Pulsar sobre el boton Empleo
        driver.findElement(By.xpath("//*[@id='menu-item-33']/a")).click();
        EmpleoPage nextPage = new EmpleoPage(driver);
        return nextPage;
    }
}
