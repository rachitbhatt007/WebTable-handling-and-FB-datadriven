
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FacebookHome {
    String username,pass;
    WebDriver driver;
    @FindBy(xpath = "//input[@id='email']")
    WebElement email;

    @FindBy(xpath = "//input[@id='pass']")
    WebElement password;

    @FindBy(css = "#u_0_h_bT")
    WebElement loginButton;

    public FacebookHome(WebDriver driver,String username,String password){
        PageFactory.initElements(driver,this);
        this.driver=driver;
        this.username=username;
        this.pass=password;
    }

    public void login(){
        email.sendKeys(username);
        password.sendKeys(pass);
    }
}
