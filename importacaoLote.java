package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class ImportacaoLote {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://loginh.getsharing.com.br/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testImportacaoLote() throws Exception {
    driver.get(baseUrl + "/");
    driver.findElement(By.id("input-email")).clear();
    driver.findElement(By.id("input-email")).sendKeys("teste@teste.com");
    driver.findElement(By.id("input-senha")).clear();
    driver.findElement(By.id("input-senha")).sendKeys("123mudar");
    driver.findElement(By.cssSelector("button[title=\"Entrar\"]")).click();
    driver.findElement(By.xpath("//li[@onclick=\"window.location.href ='/#/batch-upload'\"]")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.id("file_button"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    driver.findElement(By.id("file_button")).clear();
    driver.findElement(By.id("file_button")).sendKeys("C:\\Users\\filipe.silva\\Desktop\\Teste_QA123.txt");
    driver.findElement(By.cssSelector("button.botao-selecionar-mais-arquivos")).click();
    driver.findElement(By.id("file_button")).clear();
    driver.findElement(By.id("file_button")).sendKeys("C:\\Users\\filipe.silva\\Desktop\\Teste diário.txt");
    driver.findElement(By.cssSelector("button.botao-proximo")).click();
    driver.findElement(By.xpath("//ul[@id='select-opt']/li/span/a")).click();
    driver.findElement(By.xpath("//ul[3]/li/a")).click();
    driver.findElement(By.xpath("//ul[@id='select-opt']/li[2]/span/a")).click();
    driver.findElement(By.xpath("//ul[4]/li/a")).click();
    driver.findElement(By.xpath("//ul[@id='select-opt']/li[3]/span/a")).click();
    driver.findElement(By.xpath("//ul[5]/li/a")).click();
    driver.findElement(By.xpath("//section[2]/section/div[2]/button")).click();
    driver.findElement(By.cssSelector("button.botao-importar")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.cssSelector("button.botao-nova-Importacao"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    driver.findElement(By.linkText("Documentos Gerais/Portar Vargas 02")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.xpath("//div/li/div[9]"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    driver.findElement(By.xpath("//div/li/div[9]")).click();
    driver.findElement(By.id("excluir")).click();
    driver.findElement(By.cssSelector("div.botoes-modal > #excluir")).click();
    driver.findElement(By.cssSelector("div.bloco-i")).click();
    driver.findElement(By.id("excluir")).click();
    driver.findElement(By.cssSelector("div.botoes-modal > #excluir")).click();
    driver.findElement(By.xpath("//li[@onclick='#']")).click();
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
