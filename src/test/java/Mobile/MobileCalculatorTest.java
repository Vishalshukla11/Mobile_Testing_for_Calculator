package Mobile;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Pages.CalculatorPage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class MobileCalculatorTest {
    private AndroidDriver driver;
    private CalculatorPage CP;

    @SuppressWarnings("deprecation")
    @BeforeClass
    public void Setup() throws MalformedURLException
    {
        DesiredCapabilities cap = new DesiredCapabilities() ;
        cap.setCapability(MobileCapabilityType.AUTOMATION_NAME,"Appium");
        cap.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android" );
        cap.setCapability(MobileCapabilityType.PLATFORM_VERSION,"6.0");
        cap.setCapability(MobileCapabilityType.DEVICE_NAME  ,"emulator-5554");
        cap.setCapability("appPackage","com.android.calculator2" );
        cap.setCapability("appActivity","com.android.calculator2.Calculator");

        URL url=new URL("http://127.0.0.1:4723/wd/hub");
        driver= new AndroidDriver(url,cap);
        CP= new CalculatorPage(driver);

    }

    @Test(priority = 1)
    public void testAddition()
    {
      CP.pressOne();
      CP.PressPlus();
      CP.PressTwo();
      CP.PressEqual();
      String expectedResult=CP.result();
      Assert.assertEquals("3",expectedResult,"the addition result is incorrect");
        CP.DeleteBtn();

    }
    @Test(priority = 2)
    public void TestMinus()
    {
        CP.PressTwo();
        CP.minus();
        CP.pressOne();
        CP.PressEqual();
        String expectedResult= CP.result();
        Assert.assertEquals("1",expectedResult,"Minus Result is incorrect ");
        CP.DeleteBtn();


    }
    @Test(priority = 3)
    public void TestMulti()
    {
        CP.PressTwo();
        CP.Multi();
        CP.pressOne();
        CP.PressEqual();
        String expectedResult= CP.result();
        Assert.assertEquals("2",expectedResult,"Minus Result is incorrect ");
        CP.DeleteBtn();

    }
    @Test(priority = 4)
    public void TestDiv()
    {
        CP.PressTwo();
        CP.div();
        CP.PressThree();
        CP.PressEqual();
        String expectedResult= CP.result();
        Assert.assertEquals("0.6666666667",expectedResult,"Minus Result is incorrect ");
        CP.DeleteBtn();


    }
    @Test(priority = 5)
    public  void PointBtn()
    {
        CP.pressOne();
        CP.Point();
        CP.PressThree();
        CP.PressPlus();
        CP.PressThree();
        CP.PressEqual();
        String ExpectedResult= CP.result();
        Assert.assertEquals("4.3",ExpectedResult,"Point button is not working ");
        CP.DeleteBtn();

    }
    @Test(priority = 6)
    public void TestDelete()
    {
        CP.PressTwo();
        CP.div();
        CP.PressThree();
        CP.PressEqual();
        CP.DeleteBtn();
        String expectedResult= CP.result();
        Assert.assertEquals("",expectedResult,"Minus Result is incorrect ");


    }


    @AfterClass
    public void TearDown()
    {
        if(driver!=null)
        {
            driver.quit();
        }
    }



}
