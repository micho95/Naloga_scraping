
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Scraper {



    
    public static void main( String[] args ) throws IOException, InterruptedException
    {

        System.setProperty("webdriver.chrome.driver", "D:/Chrome/chromedriver.exe");
     
        WebDriver driver = new ChromeDriver();  
        
        driver.get("https://www.basketball-reference.com/");

        Thread.sleep(500);

        driver.findElement(ByXPath.xpath("//*[@id='qc-cmp2-ui']/div[2]/div/button[3]")).click();

        Scanner my_scan = new Scanner(System.in);

        System.out.print("Vpisi ime igralca brez sumnikov: ");

        String my_text = my_scan.nextLine();

        driver.findElement(By.xpath("//*[@id='header']/div[3]/form/div/div/input[2]")).sendKeys(my_text);  

        Thread.sleep(500);

        driver.findElement(ByXPath.xpath("//*[@id='header']/div[3]/form/input[1]")).click();

        Thread.sleep(500);

        driver.findElement(ByXPath.xpath("//*[@id='players']/div[1]/div[1]/strong/a")).click();

        Thread.sleep(500);

        WebElement element = driver.findElement(By.id("div_per_game"));

        List<WebElement> trojke = element.findElements(By.cssSelector("td[data-stat='fg3a_per_g']"));
        

        List<WebElement>  sezone = element.findElements(By.xpath("//*[@id='per_game']/tbody/tr/th/a"));

        for(int i = 0; i< sezone.size(); i++){
            System.out.println(sezone.get(i).getText() + "\t" + trojke.get(i).getText()); 
         }

         driver.quit();
         my_scan.close();


    }

    
}
