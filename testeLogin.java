package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TesteLogin {
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
  public void testELogin() throws Exception {
    driver.get(baseUrl + "/");
    driver.findElement(By.id("input-email")).clear();
    driver.findElement(By.id("input-email")).sendKeys("filipess.2011@gmail.com");
    driver.findElement(By.id("input-senha")).clear();
    driver.findElement(By.id("input-senha")).sendKeys("123mudar");
    driver.findElement(By.cssSelector("button[title=\"Entrar\"]")).click();
    driver.get("https://login.getsharing.com.br/");
    driver.findElement(By.id("input-email")).clear();
    driver.findElement(By.id("input-email")).sendKeys("filipe@a.co");
    driver.findElement(By.id("input-senha")).clear();
    driver.findElement(By.id("input-senha")).sendKeys("Pass1Word");
    driver.findElement(By.cssSelector("button[title=\"Entrar\"]")).click();
    assertEquals("Nome de usuário ou senha incorreto", driver.findElement(By.cssSelector("ul.msgErrors > li")).getText());
    driver.findElement(By.id("input-email")).clear();
    driver.findElement(By.id("input-email")).sendKeys("filipe.silva@jmail.com");
    driver.findElement(By.id("input-senha")).clear();
    driver.findElement(By.id("input-senha")).sendKeys("123mudar");
    driver.findElement(By.cssSelector("button[title=\"Entrar\"]")).click();
    assertEquals("Nome de usuário ou senha incorreto", driver.findElement(By.cssSelector("ul.msgErrors > li")).getText());
    driver.findElement(By.id("input-email")).clear();
    driver.findElement(By.id("input-email")).sendKeys("filipess.2011@gmail.com");
    driver.findElement(By.id("input-senha")).clear();
    driver.findElement(By.id("input-senha")).sendKeys("Pass1Word");
    driver.findElement(By.cssSelector("button[title=\"Entrar\"]")).click();
    assertEquals("Senha incorreta. Por favor, insira a senha correta", driver.findElement(By.cssSelector("ul.msgErrors > li")).getText());
    driver.findElement(By.id("input-senha")).clear();
    driver.findElement(By.id("input-senha")).sendKeys("");
    driver.findElement(By.cssSelector("button[title=\"Entrar\"]")).click();
    assertEquals("O campo Senha é necessário", driver.findElement(By.cssSelector("ul.msgErrors > li")).getText());
    driver.findElement(By.id("input-senha")).clear();
    driver.findElement(By.id("input-senha")).sendKeys("123");
    driver.findElement(By.cssSelector("button[title=\"Entrar\"]")).click();
    assertEquals("Sua senha deve ter no máximo 10 e no mínimo 8 caracteres", driver.findElement(By.cssSelector("ul.msgErrors > li")).getText());
    driver.findElement(By.id("input-senha")).clear();
    driver.findElement(By.id("input-senha")).sendKeys("123hgdhfddfg");
    driver.findElement(By.cssSelector("button[title=\"Entrar\"]")).click();
    assertEquals("Sua senha deve ter no máximo 10 e no mínimo 8 caracteres", driver.findElement(By.cssSelector("ul.msgErrors > li")).getText());
    driver.findElement(By.id("input-email")).clear();
    driver.findElement(By.id("input-email")).sendKeys("graciela.arauj@veriz.com.br");
    driver.findElement(By.id("input-senha")).clear();
    driver.findElement(By.id("input-senha")).sendKeys("123mudar");
    driver.findElement(By.cssSelector("button[title=\"Entrar\"]")).click();
    driver.findElement(By.cssSelector("button[title=\"Entrar\"]")).click();
    driver.findElement(By.id("input-email")).clear();
    driver.findElement(By.id("input-email")).sendKeys("graciela.arauj@verizd.com.br");
    driver.findElement(By.id("input-senha")).clear();
    driver.findElement(By.id("input-senha")).sendKeys("123hgdhg");
    driver.findElement(By.cssSelector("button[title=\"Entrar\"]")).click();
    assertEquals("Nome de usuário ou senha incorreto", driver.findElement(By.cssSelector("ul.msgErrors > li")).getText());
    driver.findElement(By.id("input-email")).clear();
    driver.findElement(By.id("input-email")).sendKeys("qa.veriz@gmail.com");
    driver.findElement(By.id("input-senha")).clear();
    driver.findElement(By.id("input-senha")).sendKeys("123hgdhg");
    driver.findElement(By.cssSelector("button[title=\"Entrar\"]")).click();
    driver.findElement(By.cssSelector("button[title=\"Entrar\"]")).click();
    driver.findElement(By.cssSelector("button[title=\"Entrar\"]")).click();
    driver.findElement(By.cssSelector("button[title=\"Entrar\"]")).click();
    assertEquals("Esta conta foi bloqueada por excesso de tentativas erradas. Um e-mail foi enviado para sua conta para que possa desbloqueá-la", driver.findElement(By.cssSelector("ul.msgErrors > li")).getText());
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
