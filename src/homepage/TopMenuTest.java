package homepage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class TopMenuTest extends Utility {
    String baseurl = "https://demo.nopcommerce.com/";
    public void selectMenu(String menu){

        List<WebElement> topMenuName = driver.findElements(By.xpath("//ul[@class='top-menu notmobile']\n"));
        for (WebElement name : topMenuName) {
            if(name.getText().equalsIgnoreCase(menu)){
                name.click();
                break;
            }
        }

    }


    @Before
    public void setUp() {

        openBrowser(baseurl);
    }


    @Test
    public void verifyPageNavigation(){
        selectMenu("Computers");
        verifyText("Computers",By.xpath("/html/body/div[6]/div[2]/ul[1]/li[1]/a"));

    }
    @Test
    public void verifyPageNavigation2(){
        selectMenu("Books");
        verifyText("Books",By.xpath("/html/body/div[6]/div[2]/ul[1]/li[5]/a"));
    }


    @After
    public void tearDown() {
        //closeBrowser();

    }
}
