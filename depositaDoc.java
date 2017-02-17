package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class DepositaDoc {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "https://login.getsharing.com.br/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testDepositaDoc() throws Exception {
    driver.get("http://loginh.getsharing.com.br/");
    driver.findElement(By.id("input-email")).clear();
    driver.findElement(By.id("input-email")).sendKeys("filipess.2011@gmail.com");
    driver.findElement(By.id("input-senha")).clear();
    driver.findElement(By.id("input-senha")).sendKeys("12345678");
    driver.findElement(By.cssSelector("button[title=\"Entrar\"]")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [getEval | new Date().setDate( new Date().getDate() + 30) | ]]
    System.out.println(date);
    // ERROR: Caught exception [ERROR: Unsupported command [getEval | d=new Date( new Date().getFullYear(), new Date().getMonth(), new Date().getDate() +30); d=d.getFullYear() | ]]
    System.out.println(year);
    // ERROR: Caught exception [ERROR: Unsupported command [getEval | d=new Date( new Date().getFullYear(), new Date().getMonth(), new Date().getDate()  +30); d=d.getMonth() | ]]
    System.out.println(month);
    // ERROR: Caught exception [ERROR: Unsupported command [getEval | d=new Date( new Date().getFullYear(), new Date().getMonth(), new Date().getDate() + 30).getDate() | ]]
    // ERROR: Caught exception [ERROR: Unsupported command [setTimeout |  | ]]
    // ERROR: Caught exception [ERROR: Unsupported command [getEval | d=new Date().getHours()+" : " + new Date().getMinutes() + " : " + new Date().getSeconds() | ]]
    System.out.println(time);
    // ERROR: Caught exception [ERROR: Unsupported command [setTimeout |  | ]]
    driver.findElement(By.cssSelector("strong[title=\"Comercial\"]")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [setTimeout |  | ]]
    driver.findElement(By.cssSelector("#btn-nova-providencia > span")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [setTimeout |  | ]]
    // ERROR: Caught exception [ERROR: Unsupported command [getEval | javascript: storedVars["teste"]++; | ]]
    driver.findElement(By.id("nome-agrupador")).clear();
    driver.findElement(By.id("nome-agrupador")).sendKeys("Agrupador-" + day + "/" + month + "/" + year + "/" + time);
    driver.findElement(By.id("enviar")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.cssSelector("#btn-novo-documento > span"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    driver.findElement(By.cssSelector("#btn-novo-documento > span")).click();
    driver.findElement(By.id("nome-documento")).clear();
    driver.findElement(By.id("nome-documento")).sendKeys("Documento-" + day + "/" + month + "/" + year + "/" + time);
    driver.findElement(By.id("file")).clear();
    driver.findElement(By.id("file")).sendKeys("C:\\Users\\Veriz\\Desktop\\Teste_QA123.txt");
    driver.findElement(By.id("depositar-documento")).click();
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
