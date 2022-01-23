package pageObject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EmpleoPage {

    WebDriver driver;

    public EmpleoPage(WebDriver remoteDriver){
        driver = remoteDriver;
    }

    public InfoEmpleoPage clickBtnOferta() { // Pulsar sobre la oferta
        driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div/div[2]/a")).click();

        InfoEmpleoPage nextPage = new InfoEmpleoPage(driver);
        return nextPage;
    }

    public boolean obtenerTitulo(String tituloText, String tituloLista){ // Obtener nombre de la oferta
        String tituloOfertas = driver.findElement(By.xpath(tituloLista)).getText();
        boolean findText = tituloOfertas.equals(tituloText);
        return findText;
    }

    public void buscarOferta(String nombreEmpleo) { // Buscar oferta por nombre de la misma, tipo de sector y ciudad

        driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div/form/div[1]/input")).sendKeys(nombreEmpleo);

        driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div/form/div[2]/div")).click();
        driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div/form/div[2]/div/div/a[4]")).click();

        driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div/form/div[3]/div")).click();
        driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div/form/div[3]/div/div/a[3]")).click();
    }
}
