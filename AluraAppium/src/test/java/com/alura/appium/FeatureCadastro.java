package com.alura.appium;

import com.alura.appium.PageObjects.CadastroPageObject;
import com.alura.appium.PageObjects.LoginPageObject;
import io.appium.java_client.AppiumDriver;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.NoSuchElementException;

public class FeatureCadastro {
    @Test
    public void nao_cadastrar_usuario_com_senhar_que_nao_conferem() {

        //Configurações:
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        LoginPageObject telaLogin = new LoginPageObject(driver);

        //Teste:
        telaLogin.BuscarElementos();
        CadastroPageObject telaCadastro = telaLogin.IrPCadastro();
        telaCadastro.BuscarElementos();
        telaCadastro.Cadastrar("Bugan", "123", "456");
        Assert.assertTrue("Senhas não conferem", telaCadastro.MensagemErro());
        driver.navigate().back();
    }

    @Test
    public void cadastrar_um_novo_usuario() throws NoSuchElementException {

        //Configurações:
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        LoginPageObject telaLogin = new LoginPageObject(driver);

        //Teste:
        telaLogin.BuscarElementos();
        CadastroPageObject telaCadastro = telaLogin.IrPCadastro();
        telaCadastro.BuscarElementos();
        telaLogin = telaCadastro.Cadastrar("Bugan", "123", "123");
        telaLogin.BuscarElementos();
    }
}
