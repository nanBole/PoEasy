package com.xueqiu.App;

import io.appium.java_client.android.AndroidDriver;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class App extends BasePage {

    @Before
    public static void start() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "android");
//        desiredCapabilities.setCapability("deviceName", "PRA-AL00X_DUP7N17323011090");
        desiredCapabilities.setCapability("deviceName", "DUP7N17323011090");
        desiredCapabilities.setCapability("appActivity", ".view.WelcomeActivityAlias");
        desiredCapabilities.setCapability("appPackage", "com.xueqiu.android");
        desiredCapabilities.setCapability("ensureWebviewsHavePages", true);
        //处理升级框，弹出框
        desiredCapabilities.setCapability("noReset",true);
        //配置chomerdriver路径,配置多个版本的chromerdriver,当存在webview时,可以自己寻找匹配的驱动
        desiredCapabilities.setCapability("chromedriverExecutableDir","D:/selenium");
        desiredCapabilities.setCapability("autoGrantPermissions",true);
        URL remoteUrl = new URL("http://localhost:4723/wd/hub");

        driver = new AndroidDriver(remoteUrl, desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    public static SearchPage toSearch() {
        findElementAndClick(By.id("com.xueqiu.android:id/home_search"));
         return new SearchPage();
    }

    public static OpenAccoutPage toOpenAccout(){
        findElementsAndClick(By.id("tab_name"),4);
        return new OpenAccoutPage();
    }


//    @After
//    public void tearDown() {
////        driver.quit();
//    }
}

