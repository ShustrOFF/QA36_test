import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class Login {
    WebDriver wd;

    @BeforeMethod
    public void preCondition() {
        //open browser
        wd = new ChromeDriver();
        //open site
        wd.get("https://telranedu.web.app/");
    }

    @Test
    public void findElementsOnPage(){
        //by tagname
        WebElement element = wd.findElement(By.tagName("div"));
        List<WebElement> divs = wd.findElements(By.tagName("div"));

        //by id
        WebElement elemroot = wd.findElement(By.id("root"));

        //by class
        WebElement elemclas = wd.findElement(By.className("container"));

        //by name
        wd.findElement(By.name("name"));

        //by link href
        wd.findElement(By.linkText("HOME"));
        wd.findElement(By.linkText("ABOUT"));
        wd.findElement(By.partialLinkText("HO"));
    }

    @Test
        public void registrationSuccess(){
    WebElement itemLogin = wd.findElement(By.linkText("LOGIN"));
    itemLogin.click();

    WebElement email = wd.findElement(By.name("email"));
    email.clear();
    email.click();
    email.sendKeys("VovkSirko34@gmail.com");


    WebElement password = wd.findElement(By.name("password"));
    password.clear();
    password.click();
    password.sendKeys("1267Vovk$");

    WebElement registrationButton = wd.findElement(By.name("registration"));
    registrationButton.click();
    }
    @Test
    public void loginSuccess() {
        //open form
        //wd find button + click
        WebElement itemLogin = wd.findElement(By.linkText("LOGIN"));
        itemLogin.click();
        //fill form
        //find email + click + type
        WebElement email = wd.findElement(By.name("email"));
        email.click();
        email.clear();
        email.sendKeys("noa@gmail.com");
        //find password + click + type
        //submit form
        WebElement password = wd.findElement(By.name("password"));
        password.click();
        password.clear();
        password.sendKeys("Nnoa12345$");
        //find login + click

        List<WebElement> buttons = wd.findElements(By.tagName("button"));
        WebElement buttonLogin = buttons.get(0);
        buttonLogin.click();
        Assert.assertEquals("", "");
    }

    @AfterMethod
    public void postCondition() {
        //close browser
        wd.quit();
    }

}