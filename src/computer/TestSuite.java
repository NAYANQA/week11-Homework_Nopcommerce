package computer;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.Utility;

import java.nio.ByteOrder;
import java.util.List;

public class TestSuite extends Utility {

    String baseurl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {

        openBrowser(baseurl);
    }

    @Test
    public void TestName() {
        //1.1 Click on Computer Menu.
         WebElement ClickComputer = driver.findElement(By.xpath("//div[6]/div[2]/ul[1]/li[1]/a"));
       ClickComputer.click();

        //1.2 Click on Desktop
        //WebElement ClickDesktop = driver.findElement(By.xpath("//div/div[2]/div[1]/div/div[1]/div/div/a/img"));
        //ClickDesktop.click();

        Actions actions=new Actions(driver);
        WebElement computer=driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div[3]/div/div[2]/div[1]/div/div[1]/div/div/a/img"));
       // WebElement software= driver.findElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[1]/ul[1]/li[3]/a"));
        actions.moveToElement(computer).build().perform();
       // actions.moveToElement(software).click().build().perform();
        //actions.moveToElement(computer).moveToElement(software).click().build().perform();

        //1.3 Select Sort By position "Name: Z to A"

        List<WebElement> productList = driver.findElements(By.xpath("//*[@id=\"products-orderby\"]/option[3]"));
        for (WebElement product : productList) {
            if (product.getText().equalsIgnoreCase("Name: Z to A")) {
                product.click();
            }
        }


        //selectByVisibleTextFromDropDown(By.xpath("//*[@id=\"products-orderby\"]/option[3]"),"Name: Z to A");








        //1.4 Verify the Product will arrange in Descending order.


    }
@Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {
        //2.1 Click on Computer Menu.
    clickOnElement(By.xpath("/html/body/div[6]/div[2]/ul[1]/li[1]/a"));
    //2.2 Click on Desktop
    clickOnElement(By.xpath("/html/body/div[6]/div[3]/div/div[3]/div/div[2]/div[1]/div/div[1]/div/div/a/img"));
    //2.3 Select Sort By position "Name: A to Z"
   // selectByValueFromDropdown(By.xpath("//select[@id='products-orderby']"),"6");
    WebElement dropDown =driver.findElement(By.xpath("//*[@id=\"products-orderby\"]"));
    Select select=new Select(dropDown);
    List<WebElement>allOptions =select.getOptions();
    for(WebElement name:allOptions){
            String n=name.getText();
            System.out.println(n);
        if(name.getText().equalsIgnoreCase("Name: A to Z")){
            name.click();
        }
    }

    //2.4 Click on "Add To Cart"
   // clickOnElement(By.xpath("/html/body/div[6]/div[3]/div/div[3]/div/div[2]/div[2]/div[2]/div/div/div[1]/div/div[2]/div[3]/div[2]/button[1]"));
    Actions actions = new Actions(driver);
    WebElement mouseHoover = driver.findElement(By.xpath("//button[@onclick='return AjaxCart.addproducttocart_catalog(\"/addproducttocart/catalog/1/1/1\"),!1']"));
    actions.moveToElement(mouseHoover).click().build().perform();

   /*WebElement clickCart = driver.findElement(By.xpath("//div[1]/div/div[2]/div[3]/div[2]/button[1]"));
   clickCart.click();
*/
    //2.5 Verify the Text "Build your own computer"
    getTextFromElement(By.xpath("//*[@id=\"product-details-form\"]/div[2]/div[1]/div[2]/div[1]/h1"));
    Thread.sleep(1000);
    //2.6 Select "2.2 GHz Intel Pentium Dual-Core E2200" using Select class
    WebElement dropDown1 = driver.findElement(By.xpath("//*[@id=\"product_attribute_1\"]"));
    Select select1 = new Select(dropDown1);
    List<WebElement>allOptions1 = select1.getOptions();
    for (WebElement name:allOptions1){
        if(name.getText().equalsIgnoreCase("1")){
            name.click();
        }
    }
    //2.7.Select "8GB [+$60.00]" using Select class.
    WebElement dropDown2 =driver.findElement(By.xpath("//*[@id=\"product_attribute_input_2\"]"));
    Select select2 =new Select(dropDown2);
    List<WebElement>allOption2 =select2.getOptions();
    for (WebElement name:allOption2) {
        if(name.getText().equalsIgnoreCase("5"));
       // selectByValueFromDropdown(By.xpath("//select[@id="product_attribute_2"]"),"5");

    }
    //2.8 Select HDD radio "400 GB [+$100.00]"
    clickOnElement(By.xpath("//*[@id=\"product_attribute_3_7\"]"));

    //2.9 Select OS radio "Vista Premium [+$60.00]"
    clickOnElement(By.xpath("//*[@id=\"product_attribute_4_9\"]"));

    //A 2.10 Check Two Check boxes "Microsoft Office [+$50.00]" and "Total Commander [+$5.00]"
    clickOnElement(By.xpath("//*[@id=\"product_attribute_input_5\"]/ul/li[1]/label"));
    clickOnElement(By.xpath("//*[@id=\"product_attribute_5_12\"]"));

    //2.11 Verify the price "$1,475.00"
    verifyThatElementIsDisplayed(By.xpath("//*[@id=\"price-value-1\"]"));

    //2.12 Click on "ADD TO CARD" Button.
    clickOnElement(By.xpath("//*[@id=\"add-to-cart-button-1\"]"));
    //2.13 Verify the Message "The product has been added to your shopping cart" on Top green Bar
    getTextFromElement(By.xpath("//*[@id=\"bar-notification\"]/div/p"));

    //After that close the bar clicking on the cross button.
    clickOnElement(By.xpath("//*[@id=\"bar-notification\"]/div/span"));

    //2.14 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
    Actions actions1=new Actions(driver);
    WebElement Gotocart=driver.findElement(By.xpath("//*[@id=\"topcartlink\"]/a"));
    actions1.moveToElement(Gotocart).click().build().perform();


    //2.15 Verify the message "Shopping cart"
    getTextFromElement(By.xpath("//div[3]/div/div/div/div[1]/h1"));

    //2.16 Change the Qty to "2" and Click on "Update shopping cart"
    sendKeysToElement(By.xpath("//*[@id=\"itemquantity11226\"]"),"2");
    clickOnElement(By.xpath("//*[@id=\"updatecart\"]"));

    //2.17 Verify the Total"$2,950.00"
    getTextFromElement(By.xpath("//*[@id=\"shopping-cart-form\"]/div[3]/div[2]/div[1]/table/tbody/tr[4]/td[2]/span/strong"));
    //2.18 click on checkbox “I agree with the terms of service”
    clickOnElement(By.xpath("//input[@id=\"termsofservice\"]"));

    //2.19 Click on “CHECKOUT”
    clickOnElement(By.xpath("//*[@id=\"checkout\"]"));
    //2.20 Verify the Text “Welcome, Please Sign In!”
    getTextFromElement(By.xpath("//div/div/div/div[1]/h1"));
    //2.21Click on “CHECKOUT AS GUEST” Tab
    clickOnElement(By.xpath("//button[@class='button-1 checkout-as-guest-button']"));
    //2.22 Fill the all mandatory field
    sendKeysToElement(By.xpath("//*[@id=\"BillingNewAddress_FirstName\"]"),"Testing");//First name:
    sendKeysToElement(By.xpath("//*[@id=\"BillingNewAddress_LastName\"]"),"QA");//Last name:
    sendKeysToElement(By.xpath("//*[@id=\"BillingNewAddress_Email\"]"),"testqa@gmail.com");//Email:
    //----country dropdown-------
    WebElement countrydropDown = driver.findElement(By.xpath("//*[@id=\"BillingNewAddress_CountryId\"]"));
    Select select3 = new Select(countrydropDown);
    List<WebElement>allOptions3 = select3.getOptions();
    for (WebElement name:allOptions3){
        if(name.getText().equalsIgnoreCase("India")){
            name.click();
        }
    }
    //-------State dropdown-----------
    WebElement ststedropDown = driver.findElement(By.xpath("//*[@id=\"BillingNewAddress_StateProvinceId\"]"));
    Select select4 = new Select(ststedropDown);
    List<WebElement>allOptions4 = select4.getOptions();
    for (WebElement name:allOptions4){
        if(name.getText().equalsIgnoreCase("Other")){
            name.click();
        }
    }
    sendKeysToElement(By.xpath("//*[@id=\"BillingNewAddress_City\"]"),"");//City:
    sendKeysToElement(By.xpath("//*[@id=\"BillingNewAddress_Address1\"]"),"testing");//Address 1:
    sendKeysToElement(By.xpath("//*[@id=\"BillingNewAddress_ZipPostalCode\"]"),"387001");//Zip / postal code:
    sendKeysToElement(By.xpath("//*[@id=\"BillingNewAddress_PhoneNumber\"]"),"123467890");//Phone number:
    //2.23 Click on “CONTINUE”
    clickOnElement(By.xpath("//*[@id=\"billing-buttons-container\"]/button[4]"));
    //2.24 Click on Radio Button “Next Day Air($0.00)”
    clickOnElement(By.xpath("//*[@id=\"shippingoption_1\"]"));
    //2.25 Click on “CONTINUE”
    clickOnElement(By.xpath("//*[@id=\"shipping-method-buttons-container\"]/button"));
    //2.26 Select Radio Button “Credit Card”
    clickOnElement(By.xpath("//*[@id=\"paymentmethod_1\"]"));

    //2.27 Select “Master card” From Select credit card dropdown
    WebElement carddropDown = driver.findElement(By.xpath("//*[@id=\"CreditCardType\"]"));
    Select select5 = new Select(carddropDown);
    List<WebElement>allOptions5 = select5.getOptions();
    for (WebElement name:allOptions5){
        if(name.getText().equalsIgnoreCase("Master card")){
            name.click();
        }
    }

    //2.28 Fill all the details
    sendKeysToElement(By.xpath("//*[@id=\"CardholderName\"]"),"Test Qa");//Cardholder name:
    sendKeysToElement(By.xpath("//*[@id=\"CardNumber\"]"),"5555 5555 5555 4444");//Card number:

//--------------------------------Expiration date: ------------------
    WebElement datedropDown = driver.findElement(By.xpath("//*[@id=\"ExpireMonth\"]"));
    Select select6 = new Select(datedropDown);
    List<WebElement>allOptions6 = select6.getOptions();
    for (WebElement name:allOptions6){
        if(name.getText().equalsIgnoreCase("12")){
            name.click();
        }
    }
    //Master Card Number: 5555 5555 5555 4444, Exp: 1230, CVV: 123

    //=================Expiration date: ================
    WebElement expdatedropDown = driver.findElement(By.xpath("//*[@id=\"ExpireYear\"]"));
    Select select7 = new Select(expdatedropDown);
    List<WebElement>allOptions7 = select7.getOptions();
    for (WebElement name:allOptions7){
        if(name.getText().equalsIgnoreCase("2030")){
            name.click();
        }
    }
    //------CVV-----
    sendKeysToElement(By.xpath(""),"123");

    //2.29 Click on “CONTINUE”
    clickOnElement(By.xpath("//*[@id=\"payment-info-buttons-container\"]/button"));
    //2.30 Verify “Payment Method” is “Credit Card”
    getTextFromElement(By.xpath("//*[@id=\"checkout-confirm-order-load\"]/div/div/div/div/div[1]/div[2]/ul/li"));
    //2.32 Verify “Shipping Method” is “Next Day Air”
    getTextFromElement(By.xpath("//*[@id=\"checkout-confirm-order-load\"]/div/div/div/div/div[2]/div[2]/ul/li"));
    //2.33 Verify Total is “$2,950.00”
    getTextFromElement(By.xpath("//*[@id=\"shopping-cart-form\"]/div[3]/div/div/table/tbody/tr[4]/td[2]/span/strong"));
    //2.34 Click on “CONFIRM”
    clickOnElement(By.xpath("//*[@id=\"confirm-order-buttons-container\"]/button"));
    //2.35 Verify the Text “Thank You”
    getTextFromElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[1]/h1"));
    //2.36 Verify the message “Your order has been successfully processed!”
    getTextFromElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div/div[1]/strong"));
    //2.37 Click on “CONTINUE”
    clickOnElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div/div[3]/button"));
    //2.37 Verify the text “Welcome to our store”
    getTextFromElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div/div[2]/div[1]/h2"));
}


    @After
    public void tearDown() {
      //  closeBrowser();

    }
}
