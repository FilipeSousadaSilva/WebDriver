package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class ModalConvidar {
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
  public void testModalConvidar() throws Exception {
    driver.get(baseUrl + "/");
    driver.findElement(By.id("input-email")).clear();
    driver.findElement(By.id("input-email")).sendKeys("filipe.ss2011@gmail.com");
    driver.findElement(By.id("input-senha")).clear();
    driver.findElement(By.id("input-senha")).sendKeys("123mudar");
    driver.findElement(By.cssSelector("button[title=\"Entrar\"]")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.cssSelector("strong"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    driver.findElement(By.cssSelector("strong")).click();
    driver.findElement(By.id("nomeConvidado")).clear();
    driver.findElement(By.id("nomeConvidado")).sendKeys("Filipe Teste");
    driver.findElement(By.id("emailConvidado")).clear();
    driver.findElement(By.id("emailConvidado")).sendKeys("qa.veri.z@gmail.com");
    driver.findElement(By.id("MensagemConvidado")).clear();
    driver.findElement(By.id("MensagemConvidado")).sendKeys("teste");
    driver.findElement(By.id("sendEmailInvite")).click();
    driver.get("https://accounts.google.com/ServiceLogin?service=mail&passive=true&rm=false&continue=https://mail.google.com/mail/?tab%3Dwm&scc=1&ltmpl=default&ltmplcache=2&emr=1&osid=1#identifier");
    driver.findElement(By.id("choose-account-0")).click();
    driver.findElement(By.id("Passwd")).clear();
    driver.findElement(By.id("Passwd")).sendKeys("Pass1Word");
    driver.findElement(By.id("signIn")).click();
    driver.findElement(By.xpath("//td[5]/div[2]")).click();
    assertEquals("filipe sousa da empresa testefasdadfa lhe convida para conhecer o GetSharing, uma solução de gestão eletrônica de documentos, que permite armazenar, organizar, visualizar e compartilhar seus documentos de forma simples e segura, na nuvem!\n \n teste \n \n Experimente grátis: \n https://login.getsharing.com.br/comprar", driver.findElement(By.xpath("//div[2]/p[2]")).getText());
    driver.findElement(By.xpath("//span/a")).click();
    driver.findElement(By.xpath("//div[2]/div/table/tbody/tr/td[2]/div/div")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [clickAt | //div/div/div/div/div/div/div/div/div/div[2]/div[3]/div/div | ]]
    driver.findElement(By.xpath("//div/a/span")).click();
    driver.findElement(By.xpath("//div[3]/div[2]/a")).click();
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
