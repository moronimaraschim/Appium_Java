package com.alura.appium.PageObjects;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPageObject extends PageObjectBase {

    private WebElement botaoCadastro;

    public LoginPageObject(AppiumDriver driver) {
        super(driver);
    }

    @Override
    public void BuscarElementos() {
        botaoCadastro = driver.findElement(By.id("br.com.alura.aluraesporte:id/login_botao_cadastrar_usuario"));
    }

    public CadastroPageObject IrPCadastro() {
        botaoCadastro.click();
        return new CadastroPageObject(this.driver);

    }
}
