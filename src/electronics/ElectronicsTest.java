package electronics;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class ElectronicsTest extends Utility {

    String baseurl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {

        openBrowser(baseurl);
    }
    @Test
    public void Testnametextverified() throws InterruptedException {
        //1.1 Mouse Hover on “Electronics” Tab
        mouseHoverToElement(By.xpath("/html/body/div[6]/div[2]/ul[1]/li[1]/a"));
        //1.2 Mouse Hover on “Cell phones” and click
        mouseHoverToElementAndClick(By.xpath("//ul[1]/li[2]/ul/li[2]/a"));
        Thread.sleep(3000);
        //1.3 Verify the text “Cell phones”
        getTextFromElement(By.xpath("//div[3]/div/div[1]/h1"));

    }
    @Test
    public void verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully() throws InterruptedException {
        //2.1 Mouse Hover on “Electronics” Tab
        mouseHoverToElement(By.xpath("//div[6]/div[2]/ul[1]/li[2]/a"));
        //2.2 Mouse Hover on “Cell phones” and click
        mouseHoverToElementAndClick(By.xpath("//ul[1]li[2]/ul/li[2]/a"));

        //2.3 Verify the text “Cell phones”
        getTextFromElement(By.xpath("/html/body/div[6]/div[2]/ul[1]/li[2]/ul/li[2]/a"));
        //2.4 Click on List View Tab
        clickOnElement(By.xpath("//a[@class='viewmode-icon list']"));
        //2.5 Click on product name “Nokia Lumia 1020” link
        clickOnElement(By.xpath("//div[3]/div/div[2]/h2/a"));
        Thread.sleep(1000);
        //2.6 Verify the text “Nokia Lumia 1020”
        getTextFromElement(By.xpath("//div[1]/h1"));
        //2.7 Verify the price “$349.00”
        getTextFromElement(By.xpath("//span[@id='price-value-20']"));
        //2.8 Change quantity to 2
        clearTextFromField(By.xpath("//input[@id='product_enteredQuantity_20']"));
        sendKeysToElement(By.xpath("//input[@id='product_enteredQuantity_20']"),"2");
        //2.9 Click on “ADD TO CART” tab
        clickOnElement(By.xpath("//button[@id='add-to-cart-button-20']"));
        //2.10 Verify the Message "The product has been added to your shopping cart" on Top green Bar
        getTextFromElement(By.xpath("//*[@id=\"bar-notification\"]/div/p"));
        //After that close the bar clicking on the cross button.
        clickOnElement(By.xpath("//span[@class='close']"));

        //2.11 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        mouseHoverToElementAndClick(By.xpath("//ul/li[4]/a/span[1]"));
        //2.12 Verify the message "Shopping cart"
        getTextFromElement(By.xpath("//div/div/div/div[1]/h1"));
        //2.13 Verify the quantity is 2
        getTextFromElement(By.xpath("//input[@name ='itemquantity11215']"));
        //2.14 Verify the Total $698.00
        getTextFromElement(By.xpath("//div[1]/table/tbody/tr[4]/td[2]/span/strong"));
        //2.15 click on checkbox “I agree with the terms of service”
        clickOnElement(By.xpath("//input[@id='termsofservice']"));
        //2.16 Click on checkout
        clickOnElement(By.xpath("//button[@id='checkout']"));
        //“2.17 Verify the Text “Welcome, Please Sign In!”
        getTextFromElement(By.xpath("//div/div/div/div[1]/h1"));
        //2.18 Click on “REGISTER” tab
        clickOnElement(By.xpath("//button[@class='button-1 register-button']"));
        //2.19 Verify the text “Register”
        getTextFromElement(By.xpath("//div/div/div[1]/h1"));
        //2.20 Fill the mandatory fields
        //First Name
        sendKeysToElement(By.xpath("//input[@id='FirstName']"),"Test");
        //Last Name
        sendKeysToElement(By.xpath("//input[@id='LastName']"),"Qa");
        //Email
        sendKeysToElement(By.xpath("//input[@id='Email']"),"Test123@gmail.com");
        //Password
        sendKeysToElement(By.xpath("//input[@id='Password']"),"Test@123.");
        //Conform Password
        sendKeysToElement(By.xpath("//input[@id='ConfirmPassword']"),"Test@123.");
        //2.21 Click on “REGISTER” Button
        clickOnElement(By.xpath(""));

        //2.22 Verify the message “Your registration completed”
        getTextFromElement(By.xpath("//div[@class='result']"));
        //2.23 Click on “CONTINUE” tab
        clickOnElement(By.xpath("//a[@class='button-1 register-continue-button']"));
        //2.24 Verify the text “Shopping cart”
        getTextFromElement(By.xpath("//div/div[1]/h1"));
        //2.25 click on checkbox “I agree with the terms of service”
        clickOnElement(By.xpath("//input[@id='termsofservice']"));
        //2.26 Click on “CHECKOUT”
        clickOnElement(By.xpath("//button[@id='checkout']"));
        //2.27 Fill the Mandatory fields
        //Country:
        selectByValueFromDropdown(By.xpath("//select[@id='BillingNewAddress_CountryId']"),"133");

        //City
        selectByValueFromDropdown(By.xpath("//input[@id='BillingNewAddress_City']"),"ANAND");

        //Address 1:
        sendKeysToElement(By.xpath("//input[@id='BillingNewAddress_Address1']"),"123 Testing Road");
        //Zip / postal code:
        sendKeysToElement(By.xpath("//input[@id='BillingNewAddress_ZipPostalCode']"),"321234");
        //Phone number:
        sendKeysToElement(By.xpath("//input[@id='BillingNewAddress_PhoneNumber']"),"1234567890");

        //2.28 Click on “CONTINUE”
        clickOnElement(By.xpath("//*[@id=\"billing-buttons-container\"]/button[4]"));
        //2.29 Click on Radio Button “2nd Day Air ($0.00)”
        clickOnElement(By.xpath("//input[@id='shippingoption_1']"));
        //2.30 Click on “CONTINUE”
        clickOnElement(By.xpath("//*[@id=\"shipping-method-buttons-container\"]/button"));
        //2.31 Select Radio Button “Credit Card”
        clickOnElement(By.xpath("//*[@id='paymentmethod_1']"));
        //click on "Continue" button
        clickOnElement(By.xpath("//*[@id='payment-method-buttons-container']/button"));
        //2.32 Select “Visa” From Select credit card dropdown
        selectByValueFromDropdown(By.xpath("//select[@id='CreditCardType']"),"visa");

        //2.33 Fill all the details
        //Cardholder name:
        sendKeysToElement(By.xpath("//input[@id='CardholderName']"),"Testing");
        //Card number:
        sendKeysToElement(By.xpath("//input[@id='CardNumber']"),"4263982640269299");
        //Expiration date:(Month)
        selectByValueFromDropdown(By.xpath("//select[@id='ExpireMonth']"),"2");


        //Expiration date:(Yesr)
        selectByValueFromDropdown(By.xpath("//select[@id='ExpireYear']"),"2023");
        //CVV Code
        sendKeysToElement(By.xpath("//input[@id='CardCode']"),"837");

        //2.34 Click on “CONTINUE”CHECKOUT”
        clickOnElement(By.xpath("//*[@id=\"payment-info-buttons-container\"]/button"));
        //2.35 Verify “Payment Method” is “Credit Card”
        getTextFromElement(By.xpath("//div/div[1]/div[2]/ul/li/span[2]"));
        //2.36 Verify “Shipping Method” is “2nd Day Air”
        getTextFromElement(By.xpath("//div/div[2]/div[2]/ul/li/span[2]"));
        //2.37 Verify Total is “$698.00”
        getTextFromElement(By.xpath("//*[@id=\"shopping-cart-form\"]/div[3]/div/div/table/tbody/tr[4]/td[2]/span/strong"));
        //2.38 Click on “CONFIRM”
        clickOnElement(By.xpath("//*[@class=\"button-1 confirm-order-next-step-button\"]"));
        //2.39 Verify the Text “Thank You”
        getTextFromElement(By.xpath("//div/div/div/div[1]/h1"));
        //2.40 Verify the message “Your order has been successfully processed!”
        getTextFromElement(By.xpath("//div[2]/div/div[1]/strong"));
        //2.41 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@class='button-1 order-completed-continue-button']"));
        //2.42 Verify the text “Welcome to our store”
        getTextFromElement(By.xpath("//div[3]/div/div/div/div/div[2]/div[1]/h2"));
        //2.43 Click on “Logout” link
        clickOnElement(By.xpath("//div[2]/div[1]/ul/li[2]/a"));
        //2.44 Verify the URL is “https://demo.nopcommerce.com/”
        getTextFromElement(By.xpath(""));

    }


    @After
    public void tearDown(){
        closeBrowser();

    }
}
