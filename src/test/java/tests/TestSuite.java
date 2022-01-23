package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.hook.Hook;
import pageObject.pages.EmpleoPage;
import pageObject.pages.InfoEmpleoPage;

public class TestSuite extends Hook {
    String listaOfertasDisponibles = "//*[@id='site-content']/div[2]/div[4]/div[1]/div[5]";
    String titulo = "145 OFERTAS DISPONIBLES";
    String tituloLista = "/html/body/div[3]/div[2]/div[4]/div[1]/div[4]";

    String nombreEmpleo = "Android Junior";
    String sectorEmpleo = "Consultores";
    String ciudadEmpleo = "Madrid";

    String tareas = "Tareas";
    String requisitos = "Requisitos";
    String detalles = "DETALLES";

    String URL = "https://www.alten.es/career/";

    @Test(priority = 0) // Ver el listado de ofertas disponibles
    public void listadoEmpleoTest(){
        driver.get("https://www.alten.es");

        HomePage.clickBtnEmpleo(); // Pulsar sobre el boton Empleo

        EmpleoPage empleoPage = new EmpleoPage(driver);

        Boolean existeTitulo = empleoPage.obtenerTitulo(titulo, tituloLista);
        Assert.assertTrue(existeTitulo);

        Boolean existeElemento = driver.findElements(By.xpath(listaOfertasDisponibles)).size() != 0;
        Assert.assertTrue(existeElemento);
    }

    @Test(priority = 1) // Buscar la oferta de empleo Android Junior
    public void buscarEmpleoTest(){
        driver.get(URL);

        driver.findElement(By.xpath(("/html/body/div[5]/div[3]/button[1]"))).click();

        EmpleoPage empleoPage = new EmpleoPage(driver);

        empleoPage.buscarOferta(nombreEmpleo);

        InfoEmpleoPage infoEmpleoPage = new InfoEmpleoPage(driver);

        Boolean existeTituloOferta = infoEmpleoPage.verTituloOferta(nombreEmpleo);
        Assert.assertTrue(existeTituloOferta);
    }

    @Test(priority = 2) // Ver informacion de la oferta de empleo Android Junior
    public void verInfoEmpleoTest(){
        driver.get(URL);

        //driver.findElement(By.xpath(("/html/body/div[5]/div[3]/button[1]"))).click();

        EmpleoPage empleoPage = new EmpleoPage(driver);
        empleoPage.clickBtnOferta();

        InfoEmpleoPage infoEmpleoPage = new InfoEmpleoPage(driver);

        Boolean existeTituloTareas = infoEmpleoPage.verInfoTareas(tareas);
        Assert.assertTrue(existeTituloTareas);

        Boolean existeTituloRequisitos = infoEmpleoPage.verInfoRequisitos(requisitos);
        Assert.assertTrue(existeTituloRequisitos);

        Boolean existeTituloDetalles = infoEmpleoPage.verInfoDetalles(detalles);
        Assert.assertTrue(existeTituloDetalles);
    }

}
