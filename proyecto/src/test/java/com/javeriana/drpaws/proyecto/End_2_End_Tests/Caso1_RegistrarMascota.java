package com.javeriana.drpaws.proyecto.End_2_End_Tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.test.context.ActiveProfiles;

import java.time.Duration;
import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@ActiveProfiles("test")
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class Caso1_RegistrarMascota
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
    public void testRegistrarMascota()
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
        inputPassword.sendKeys("12345678");

        WebElement botonLogin = driver.findElement(new By.ByCssSelector("button"));
        botonLogin.click();

        // Comprobar si el login se negó:
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("error-box")));
        WebElement errorBox = driver.findElement(By.id("error-box"));
        Assertions.assertThat(errorBox.getText()).isEqualTo("Email o contraseña incorrectos.");

        // Ingresar credenciales correctas:
        inputPassword.clear();

        inputPassword.sendKeys("password1");

        botonLogin.click();

        // Comprobar que se cargó la página de veterinario:
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("Numero-de-mascotas-cargadas")));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("AgregarUsuario")));

        // Ir a la página de registro de usuarios:
        WebElement botonRegistrarUsuarioDesdeElDashboard = driver.findElement(By.id("AgregarUsuario"));

        botonRegistrarUsuarioDesdeElDashboard.click();

        // Comprobar que se cargó la página de registro de usuarios:
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("form-control")));

        // Ingresar datos de usuario:
        WebElement inputCedula = driver.findElement(By.id("cedula"));
        inputCedula.sendKeys("1000806475");

        WebElement inputNombre = driver.findElement(By.id("nombre"));
        inputNombre.sendKeys("Andrés Salamanca");

        WebElement inputEmailUsuario = driver.findElement(By.id("correo"));
        inputEmailUsuario.sendKeys("andres-salamanca@@gmail..com");

        WebElement inputCelular = driver.findElement(By.id("celular"));
        inputCelular.sendKeys("+57 313 486 5061");

        WebElement inputContraseñaUsuario = driver.findElement(By.id("contrasenna"));
        inputContraseñaUsuario.sendKeys("WebEsLaMejorMateriaDelMundo@08");

        WebElement botonRegistrarUsuario = driver.findElement(By.className("btn-primary"));
        botonRegistrarUsuario.click();

        // Comprobar que se negó el registro del usuario:
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("error-por-correo-de-usuario")));
        WebElement errorPorCorreoDeUsuario = driver.findElement(By.id("error-por-correo-de-usuario"));
        Assertions.assertThat(errorPorCorreoDeUsuario.getText()).isEqualTo("Email es requerido y debe ser válido.");

        // Ingresar credenciales correctas:
        inputEmailUsuario.clear();

        inputEmailUsuario.sendKeys("andres-salamanca@gmail.com");

        botonRegistrarUsuario.click();

        // Esperar y manejar la alerta de "Dueño creado exitosamente!":
        WebDriverWait waitAlertDueñoCreado = new WebDriverWait(driver, Duration.ofSeconds(5));
        Alert alertDueñoCreado = waitAlertDueñoCreado.until(ExpectedConditions.alertIsPresent());
        alertDueñoCreado.accept();

        // Comprobar que se cargó la página de veterinario:
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("Numero-de-mascotas-cargadas")));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("AgregarMascota")));

        // Ir a la página de registro de mascotas:
        WebElement botonRegistrarMascotaDesdeElDashboard = driver.findElement(By.id("AgregarMascota"));

        botonRegistrarMascotaDesdeElDashboard.click();

        // Comprobar que se cargó la página de registro de mascotas:
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("form-control")));

        // Ingresar datos de mascota:
        WebElement inputNombreMascota = driver.findElement(By.id("nombre"));
        inputNombreMascota.sendKeys("Firulais");

        WebElement inputRazaMascota = driver.findElement(By.id("raza"));
        inputRazaMascota.sendKeys("Pitbull");

        WebElement inputEdadMascota = driver.findElement(By.id("edad"));
        inputEdadMascota.sendKeys("5");

        WebElement inputPesoMascota = driver.findElement(By.id("peso"));
        inputPesoMascota.sendKeys("20.5");

        WebElement inputEnfermedadMascota = driver.findElement(By.id("enfermedad"));
        inputEnfermedadMascota.sendKeys("Ninguna");

        WebElement inputCedulaUsuario = driver.findElement(By.id("cedulaDueno"));
        inputCedulaUsuario.sendKeys("1000806475");

        WebElement botonRegistrarMascota = driver.findElement(By.className("btn-primary"));
        botonRegistrarMascota.click();

        // Esperar y manejar la alerta de "Dueño creado exitosamente!":
        WebDriverWait waitAlertMascotaCreada = new WebDriverWait(driver, Duration.ofSeconds(5));
        Alert alertMascotaCreada = waitAlertMascotaCreada.until(ExpectedConditions.alertIsPresent());
        alertMascotaCreada.accept();

        // Comprobar que se cargó la página de veterinario:
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("Numero-de-mascotas-cargadas")));

        // Ir a la página de login de usuario:
        WebElement botonLoginUsuarioDesdeElDashboard = driver.findElement(By.id("botonLoginUsuario"));

        botonLoginUsuarioDesdeElDashboard.click();

        // Comprobar que se cargó la página de login de usuario:
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("form-group")));

        // Ingresa credenciales de usuario:
        WebElement inputCedulaUsuarioLogin = driver.findElement(By.id("userId"));
        inputCedulaUsuarioLogin.sendKeys("1000806475");

        WebElement botonLoginUsuario = driver.findElement(By.id("botonIngresar"));
        botonLoginUsuario.click();

        // Comprobar que se cargó la página de usuario:
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("user-pic")));
    }
}
