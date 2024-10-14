package Pages;


import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class CalculatorPage {

    //page elements using @FindBy for Simplicity
    @FindBy(id = "com.android.calculator2:id/digit_1")
    WebElement digit_1;

    @FindBy(id = "com.android.calculator2:id/digit_3")
    WebElement digit_3;

    @FindBy(id = "com.android.calculator2:id/op_add")
    WebElement plus;

    @FindBy(id = "com.android.calculator2:id/digit_2")
    WebElement digit_2;

    @FindBy(id = "com.android.calculator2:id/eq")
    WebElement equals;

    @FindBy(id = "com.android.calculator2:id/formula")
    WebElement result;
    @FindBy(id = "com.android.calculator2:id/op_sub")
    WebElement minus;

    @FindBy(id = "com.android.calculator2:id/op_mul")
    WebElement multi;

    @FindBy(id = "com.android.calculator2:id/op_div")
    WebElement div;

    @FindBy(id = "com.android.calculator2:id/del")
    WebElement deleteButton;

    @FindBy(id = "com.android.calculator2:id/dec_point")
    WebElement point;


    public CalculatorPage(AndroidDriver driver) {

        PageFactory.initElements(driver, this);
    }

    public void Point() {
        point.click();
    }

    public void DeleteBtn(){
        deleteButton.click();
    }

    public  void PressThree()
    {
        digit_3.click();
    }


    public void div() {
        div.click();
    }

    public void Multi() {
        multi.click();
    }

    public void minus() {
        minus.click();


    }

    public void pressOne() {
        digit_1.click();
    }

    public void PressPlus() {
        plus.click();
    }

    public void PressTwo() {
        digit_2.click();
    }

    public void PressEqual() {
        equals.click();
    }

    public String result() {
        return result.getText();
    }


}
