package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class ConvidarEmpresa {
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
  public void testConvidarEmpresa() throws Exception {
    driver.get("http://www.geradorcnpj.com/");
    driver.findElement(By.name("geraCNPJ")).click();
    String Pegacnpj = driver.findElement(By.id("saida")).getAttribute("value");
    driver.get(baseUrl + "/");
    driver.findElement(By.id("input-email")).clear();
    driver.findElement(By.id("input-email")).sendKeys("filipess.2011@gmail.com");
    driver.findElement(By.id("input-senha")).clear();
    driver.findElement(By.id("input-senha")).sendKeys("12345678");
    driver.findElement(By.cssSelector("button[title=\"Entrar\"]")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.id("convida-usuario"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    driver.findElement(By.id("convida-usuario")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.id("company"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    // ERROR: Caught exception [ERROR: Unsupported command [getEval | new Date().setDate( new Date().getDate() + 30) | ]]
    System.out.println(date);
    // ERROR: Caught exception [ERROR: Unsupported command [getEval | d=new Date( new Date().getFullYear(), new Date().getMonth(), new Date().getDate() +30); d=d.getFullYear() | ]]
    System.out.println(year);
    // ERROR: Caught exception [ERROR: Unsupported command [getEval | d=new Date( new Date().getFullYear(), new Date().getMonth(), new Date().getDate()  +30); d=d.getMonth() | ]]
    System.out.println(month);
    // ERROR: Caught exception [ERROR: Unsupported command [getEval | d=new Date( new Date().getFullYear(), new Date().getMonth(), new Date().getDate() + 30).getDate() | ]]
    // ERROR: Caught exception [ERROR: Unsupported command [setTimeout |  | ]]
    // ERROR: Caught exception [ERROR: Unsupported command [getEval | d=new Date().getHours()+" : " + new Date().getMinutes() + " : " + new Date().getSeconds() | ]]
    driver.findElement(By.id("company")).clear();
    driver.findElement(By.id("company")).sendKeys("Teste Empresa- " + day + "/" + month + "/" + year + " - " + time);
    driver.findElement(By.id("cnpj")).clear();
    driver.findElement(By.id("cnpj")).sendKeys(Pegacnpj);
    driver.findElement(By.cssSelector("option[value=\"375\"]")).click();
    new Select(driver.findElement(By.id("FolderName"))).selectByVisibleText("Banco de Currículos");
    driver.findElement(By.cssSelector("span.convidar-usuario-multiple-select-icon")).click();
    driver.findElement(By.xpath("//li[@value='1917']")).click();
    driver.findElement(By.id("name")).clear();
    driver.findElement(By.id("name")).sendKeys("qa");
    driver.findElement(By.id("email")).clear();
    driver.findElement(By.id("email")).sendKeys("qa.veriz@gmail.com");
    driver.findElement(By.id("confirmEmail")).clear();
    driver.findElement(By.id("confirmEmail")).sendKeys("qa.veriz@gmail.com");
    driver.findElement(By.id("lastname")).clear();
    driver.findElement(By.id("lastname")).sendKeys("Veriz");
    driver.findElement(By.id("phone")).clear();
    driver.findElement(By.id("phone")).sendKeys("(11) 1111-11111");
    driver.findElement(By.id("convidar-usuario-button-Convidar")).click();
    driver.findElement(By.xpath("//li[@onclick='#']")).click();
    driver.get("https://mail.google.com/");
    driver.findElement(By.id("choose-account-0")).click();
    driver.findElement(By.id("Passwd")).clear();
    driver.findElement(By.id("Passwd")).sendKeys("12345678");
    driver.findElement(By.id("signIn")).click();
    driver.findElement(By.xpath("//td[5]/div[2]")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | name=GetSharing | ]]
    // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | name=GetSharing | ]]
    assertEquals("GetSharing - Nova empresa Teste Empresa- 17/9/2015 - 11 : 36 : 11", driver.findElement(By.id(":6i")).getText());
    driver.findElement(By.xpath("//div[2]/div/div/div[2]/div/div/div/div/div/div/div/div")).click();
    driver.findElement(By.xpath("//div/span/div")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [clickAt | //div/div/div/div/div/div/div/div/div/div[2]/div[3]/div/div | ]]
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
