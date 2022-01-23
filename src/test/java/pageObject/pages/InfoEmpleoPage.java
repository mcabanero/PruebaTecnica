package pageObject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObject.hook.Hook;


public class InfoEmpleoPage extends Hook {
    WebDriver driver;

    public InfoEmpleoPage(WebDriver remoteDriver){
        driver = remoteDriver;
    }

    public boolean verTituloOferta(String oferta){  // Obtener nombre de la oferta
        String xpathOferta= "//div[@id='site-content']/div[2]/div/div/div[2]/a";
        ((JavascriptExecutor)driver).executeScript("window.scrollBy(0, 100)", "");
        new WebDriverWait(driver, 20).until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathOferta)));
        new WebDriverWait(driver, 20).until(
                ExpectedConditions.elementToBeClickable(By.xpath(xpathOferta)));

        String tituloOferta = driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div/div[2]/a/span[1]")).getText();
        boolean textoOferta = tituloOferta.equals(oferta);
        return textoOferta;
    }

    public boolean verInfoTareas(String tituloTareas){ // Ver las tareas de la oferta
        String tituloTarea = driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[1]/div[1]/div[2]/h2[1]")).getText();
        boolean textoTareas = tituloTarea.equals(tituloTareas);
        return textoTareas;
    }
    public boolean verInfoRequisitos(String tituloRequisitos){ // Ver los requisitos de la oferta
        String tituloRequisito = driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[1]/div[1]/div[2]/h2[2]")).getText();
        boolean textoRequisitos = tituloRequisito.equals(tituloRequisitos);
        return textoRequisitos;
    }
    public boolean verInfoDetalles(String tituloDetalles){ // Ver los detalles de la oferta
        String tituloDetalle = driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[1]/div[1]/div[3]/div[1]")).getText();
        boolean textoDetalles = tituloDetalle.equals(tituloDetalles);
        return textoDetalles;
    }
}
