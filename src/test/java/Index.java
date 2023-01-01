import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;


public class Index {

     WebDriver wd;



     @BeforeMethod
     public void start() {
         wd = new ChromeDriver();
         wd.manage().window().minimize();
         wd.get("c:\\maslopup\\index.html");
         //wd.manage().window().maximize();
         //wd.close();
     }

         @Test
         public void itemsTest(){
             //find item1 & click ==> assert that div#alert contains message "Clicked by Item 1"
             WebElement item1 = wd.findElement(By.cssSelector("[href='#item1']"));
             item1.click();
             WebElement alert = wd.findElement(By.cssSelector("#alert .message"));
             String text = alert.getText();
             Assert.assertTrue(text.equals("Clicked by Item 1"));

             //find item2 & click ==> assert that div#alert contains message "Clicked by Item 2"
             WebElement item2 = wd.findElement(By.cssSelector("[href='#item2'"));
             item2.click();
             WebElement alert2 = wd.findElement(By.cssSelector("#alert .message"));
             String text2 = alert.getText();
             Assert.assertTrue(text2.equals("Clicked by Item 2"));

             //find item3 & click ==> assert that div#alert contains message "Clicked by Item 3"
             WebElement item3 = wd.findElement(By.cssSelector("[href='#item3'"));
             item3.click();
             WebElement alert3 = wd.findElement(By.cssSelector("#alert .message"));
             String text3 = alert.getText();
             Assert.assertTrue(text3.equals("Clicked by Item 3"));

             //find item4 & click ==> assert that div#alert contains message "Clicked by Item 4"
             WebElement item4 = wd.findElement(By.cssSelector("[href='#item4'"));
             item4.click();
             WebElement alert4 = wd.findElement(By.cssSelector("#alert .message"));
             String text4 = alert.getText();
             Assert.assertTrue(text4.equals("Clicked by Item 4"));
         }

         @Test
         public void formTests(){
             //fill name&surname & click send
             WebElement name = wd.findElement(By.cssSelector("#form1 :first-child"));
             name.click();
             name.clear();
             name.sendKeys("Vladimir");
             WebElement surname = wd.findElement(By.cssSelector("#form1 :nth-child(2)"));
             surname.click();
             //surname.clear();
             surname.sendKeys("Shustrov");
             WebElement button = wd.findElement(By.cssSelector(".btn"));
             button.click();
             //assert that div#alert contains message "name&surname"
             WebElement alert5 = wd.findElement(By.cssSelector("#alert .message"));
             String text5 = alert5.getText();
             Assert.assertTrue(text5.equals("Vladimir Shustrov"));
         }
         @Test
         public void tableTest(){
             //check if table has 4 rows
             List<WebElement> rows = wd.findElements(By.cssSelector("tr"));
             Assert.assertEquals(rows.size(), 4);
             //check that last row contains "Mexico"
             WebElement lastRow = wd.findElement(By.cssSelector("tr:last-child"));
             String text = lastRow.getText();
             System.out.println(text);
             //"Poland Chine Mexico" contains "Mexico"
             Assert.assertTrue(text.contains("Mexico"));
             //another variant
             WebElement lastCell = wd.findElement(By.cssSelector("tr:last-child:last-child"));
             String str = lastCell.getText();
             Assert.assertTrue(str.contains("Mexico"));
     }
     @AfterMethod

public void quit(){
    wd.quit();
     }
}