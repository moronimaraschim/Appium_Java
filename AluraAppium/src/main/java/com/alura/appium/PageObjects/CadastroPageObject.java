package com.alura.appium.PageObjects;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CadastroPageObject extends PageObjectBase {

    private WebElement campoNome;
    private WebElement campoSenha;
    private WebElement campoConfSenha;
    private WebElement botaoCadastrar;
    private final By erroID;
    private final By campoNomeID;
    private final By campoSenhaID;
    private final By campoConfSenhaID;
    private final By btnCadastroID;


    public CadastroPageObject(AppiumDriver driver) {
        super(driver);
        erroID = By.id("br.com.alura.aluraesporte:id/erro_cadastro");
        campoNomeID = By.id("br.com.alura.aluraesporte:id/input_nome");
        campoSenhaID = By.id("br.com.alura.aluraesporte:id/input_senha");
        campoConfSenhaID = By.id("br.com.alura.aluraesporte:id/input_confirmar_senha");
        btnCadastroID = By.id("br.com.alura.aluraesporte:id/cadastro_usuario_botao_cadastrar");
    }

    @Override
    public void BuscarElementos() {

        campoNome = driver.findElement(campoNomeID);
        campoSenha = driver.findElement(campoSenhaID);
        campoConfSenha = driver.findElement(campoConfSenhaID);
        botaoCadastrar = driver.findElement(btnCadastroID);

    }

    public void PreencherFormulario(String usuario, String senha, String confSenha) {

        campoNome.sendKeys(usuario);
        campoSenha.sendKeys(senha);
        campoConfSenha.sendKeys(confSenha);
    }

    public LoginPageObject Cadastrar(String usuario, String senha, String confSenha) {
        PreencherFormulario(usuario, senha, confSenha);
        botaoCadastrar.click();
        return new LoginPageObject(driver);
    }

    public boolean MensagemErro() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(erroID));
        WebElement mensagemError = driver.findElement(erroID);
        return mensagemError.isDisplayed();
    }
}
