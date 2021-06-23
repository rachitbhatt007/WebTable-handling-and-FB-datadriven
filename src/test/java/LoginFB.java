import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LoginFB extends BaseTest{
    @Test(dataProvider = "dp")
    public void fbtest(String data){
        String user[] = data.split(",");

        WebDriver driver= getDriver();
        FacebookHome facebookHome = new FacebookHome(driver,user[0],user[1]);
        facebookHome.login();
        driver.quit();
    }



@DataProvider(name = "dp")
public Object[][] logindata() throws IOException, ParseException {

        JSONParser jsonParser = new JSONParser();
        JSONObject jsonobj = (JSONObject) jsonParser.parse(new FileReader("src/main/resources/Json files/Facebook.json"));
        JSONArray jarr = (JSONArray) jsonobj.get("FacebookData");
        String arr[][] =  new String[jarr.size()][1];
        for(int i = 0;i< jarr.size();i++){
            JSONObject user =(JSONObject) jarr.get(i);
            String username = user.get("email").toString();
            String password = user.get("password").toString();
            arr[i][0] = username +","+ password;
        }
      return arr;
    }

}
