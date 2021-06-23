import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class WebTable {
    @Test
    public void handletable(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver =  new ChromeDriver();
        driver.get("https://tablepress.org/demo/");
        List<WebElement> rows= driver.findElements(By.xpath("//tbody[@class=\"row-hover\"]/tr"));
        List<WebElement> columns=driver.findElements(By.xpath("//tbody[@class=\"row-hover\"]/tr[1]/td"));
        System.out.println(rows.size());
        System.out.println(columns.size());
        for(WebElement row:rows){
            System.out.println(row.getText());
        }
        driver.quit();

    }
}
