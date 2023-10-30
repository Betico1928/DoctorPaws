package com.javeriana.drpaws.proyecto.End_2_End_Tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;

import java.time.Duration;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@ActiveProfiles("test")
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class Caso2_SuministrarTratamiento
{
    private WebDriver driver;
    private WebDriverWait wait;


    @BeforeEach
    public void setUp() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();

        //options.addArguments("--headless");
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-notifications");

        this.driver = new ChromeDriver(options);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void testSuministrarTratamiento()
    {
        // Cargar la página de inicio:
        driver.get("http://localhost:4200/home");
        driver.manage().window().maximize();

        // Ir al login administrativo:
        wait.until(ExpectedConditions.presenceOfElementLocated(new By.ByCssSelector("a[ng-reflect-router-link='/login-administrativo']")));
        WebElement botonLoginAdministrativo = driver.findElement(new By.ByCssSelector("a[ng-reflect-router-link='/login-administrativo']"));
        botonLoginAdministrativo.click();

        // Comprobar que se cargó la página de login administrativo:
        wait.until(ExpectedConditions.presenceOfElementLocated(new By.ByCssSelector("input[id='email']")));

        // Ingresar credenciales:
        WebElement inputEmail = driver.findElement(new By.ByCssSelector("input[id='email']"));
        inputEmail.sendKeys("perezj@email.com");

        WebElement inputPassword = driver.findElement(new By.ByCssSelector("input[id='password']"));
        inputPassword.sendKeys("password1");

        WebElement botonLogin = driver.findElement(new By.ByCssSelector("button"));
        botonLogin.click();

        // Comprobar que se cargó la página de veterinario:
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("Numero-de-mascotas-cargadas")));

        // Ir a la página de tratamientos:
        // Selecciona el botón dentro de la quinta fila (tr) de la tabla
        WebElement botonTratamientos = driver.findElement(By.cssSelector("table tbody tr:nth-child(5) .btn.btn-info > .fa-syringe"));
        botonTratamientos.click();

        // Comprobar que se cargó la página de tratamientos:
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("form-group")));

        // Verificar que se cargó a la mascota adecuada:
        // Nombre de la mascota
        WebElement inputNombreMascota = driver.findElement(By.id("nombre"));
        String actualValue = inputNombreMascota.getAttribute("value");
        Assertions.assertEquals("Luna", actualValue);

        // Raza de la mascota
        WebElement inputRazaMascota = driver.findElement(By.id("raza"));
        actualValue = inputRazaMascota.getAttribute("value");
        Assertions.assertEquals("Labrador Retriever", actualValue);

        // Edad de la mascota
        WebElement inputEdadMascota = driver.findElement(By.id("edad"));
        actualValue = inputEdadMascota.getAttribute("value");
        Assertions.assertEquals("11", actualValue);

        // Peso de la mascota
        WebElement inputPesoMascota = driver.findElement(By.id("peso"));
        actualValue = inputPesoMascota.getAttribute("value");
        Assertions.assertEquals("4.3", actualValue);

        // Enfermedad de la mascota
        WebElement inputEnfermedadMascota = driver.findElement(By.id("enfermedad"));
        actualValue = inputEnfermedadMascota.getAttribute("value");
        Assertions.assertEquals("Sarna (ácaros)", actualValue);

        // Introducir los valores para el tratamiento:
        WebElement inputNombreTratamiento = driver.findElement(By.id("nombreTratamiento"));
        inputNombreTratamiento.sendKeys("Tratamiento de sarna");

        // Descripción del tratamiento:
        WebElement inputDescripcionTratamiento = driver.findElement(By.id("descripcion"));
        inputDescripcionTratamiento.sendKeys("Este tratamiento es para la sarna");

        // Fecha de inicio del tratamiento:
        WebElement fechaInicioInput = driver.findElement(By.id("fechaInicio"));
        fechaInicioInput.sendKeys("19/10/2023");

        // Fecha de fin del tratamiento:
        WebElement inputFechaFinTratamiento = driver.findElement(By.id("fechaFin"));
        inputFechaFinTratamiento.sendKeys("20/10/2023");

        // Frencuencia del tratamiento:
        WebElement inputFrecuenciaTratamiento = driver.findElement(By.id("frecuencia"));
        inputFrecuenciaTratamiento.sendKeys("2 veces al día");

        // Medicamento a suministrar:
        // Localizar el elemento <select> por su ID
        WebElement dropdownMedicamento = driver.findElement(By.id("medicamento"));
        // Crear un objeto Select a partir del elemento <select>
        Select selectMedicamento = new Select(dropdownMedicamento);
        // Seleccionar "TIAMUMIX" por su texto visible
        selectMedicamento.selectByVisibleText("TIAMUMIX");

        // Enviar (o suministrar) el tratamiento:
        WebElement botonRegistrarTratamiento = driver.findElement(By.className("btn-primary"));
        botonRegistrarTratamiento.click();

        // Esperar y manejar la alerta de "Tratamiento generado exitosamente!":
        WebDriverWait waitAlertTratamientoGenerado = new WebDriverWait(driver, Duration.ofSeconds(5));
        Alert alertTratamientoGenerado = waitAlertTratamientoGenerado.until(ExpectedConditions.alertIsPresent());
        alertTratamientoGenerado.accept();

        // Comprobar que se cargó la página de veterinario:
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("Numero-de-mascotas-cargadas")));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("btn-primary")));

        // Ir a la página de visualización de mascota:
        // Selecciona el botón dentro de la quinta fila (tr) de la tabla
        WebElement botonVisualizar = driver.findElement(By.cssSelector("table tbody tr:nth-child(5) .btn.btn-primary > .fa-eye"));
        botonVisualizar.click();

        // Corroborar que se cargó la página de visualización de mascota:
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("mascota-section")));

        // Verificar que se cargó a la mascota adecuada:
        // Localizar los elementos de la tabla
        WebElement nombreMascota = driver.findElement(By.xpath("//table[@class='mascota-info']//th[text()='Nombre']/following-sibling::td"));
        WebElement razaMascota = driver.findElement(By.xpath("//table[@class='mascota-info']//th[text()='Raza']/following-sibling::td"));
        WebElement edadMascota = driver.findElement(By.xpath("//table[@class='mascota-info']//th[text()='Edad']/following-sibling::td"));
        WebElement pesoMascota = driver.findElement(By.xpath("//table[@class='mascota-info']//th[text()='Peso']/following-sibling::td"));

        // Obtener el texto de los elementos
        String nombreActual = nombreMascota.getText();
        String razaActual = razaMascota.getText();
        String edadActual = edadMascota.getText();
        String pesoActual = pesoMascota.getText();

        // Hacer assertions sobre los valores
        Assertions.assertEquals("Luna", nombreActual);
        Assertions.assertEquals("Labrador Retriever", razaActual);
        Assertions.assertEquals("11", edadActual);
        Assertions.assertEquals("4.3", pesoActual);

        // Hacer scroll down para visualizar la tabla de tratamientos:
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");

        // Esperar para visualizar el tratamiento generado:
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Hacer scroll up
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, -document.body.scrollHeight)");

        // Ir al login administrativo:
        WebElement botonLoginAdministrativoAdmin = driver.findElement(By.cssSelector("a[ng-reflect-router-link='/login-administrativo']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", botonLoginAdministrativoAdmin);


        // Comprobar que se cargó la página de login administrativo:
        wait.until(ExpectedConditions.presenceOfElementLocated(new By.ByCssSelector("input[id='email']")));

        // Ingresar credenciales:
        WebElement inputEmailAdmin = driver.findElement(new By.ByCssSelector("input[id='email']"));
        inputEmailAdmin.sendKeys("admin@drpaws.com");

        WebElement inputPasswordAdmin = driver.findElement(new By.ByCssSelector("input[id='password']"));
        inputPasswordAdmin.sendKeys("123");

        WebElement botonLoginAdmin = driver.findElement(new By.ByCssSelector("button"));
        botonLoginAdmin.click();

        // Ingresar a la sección de estadisticas:
        WebElement botonVisualizarEstadisticas = driver.findElement(By.cssSelector(".fa-chart-bar"));
        botonVisualizarEstadisticas.click();

        // Esperar a que carguen las estadisticas:
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".statistics")));
    }
}
