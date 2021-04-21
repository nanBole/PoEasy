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
    /**
     * 基础配置
     *
     * @throws MalformedURLException
     */
    @Before
    public static void start() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "android");
        desiredCapabilities.setCapability("deviceName", "DUP7N17323011090");
        desiredCapabilities.setCapability("appActivity", ".view.WelcomeActivityAlias");
        desiredCapabilities.setCapability("appPackage", "com.xueqiu.android");
        desiredCapabilities.setCapability("ensureWebviewsHavePages", true);
        //防止重安装app
        desiredCapabilities.setCapability("noReset", true);
        //配置chomerdriver路径,配置多个版本的chromerdriver,当存在webview时,可以自己寻找匹配的驱动
        desiredCapabilities.setCapability("chromedriverExecutableDir", "D:/selenium");
        desiredCapabilities.setCapability("autoGrantPermissions", true);
        //noSign表示不重签名，设置为true表示不重签名app
        desiredCapabilities.setCapability("noSign", true);
        URL remoteUrl = new URL("http://localhost:4723/wd/hub");

        driver = new AndroidDriver(remoteUrl, desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    public static SearchPage toSearch() {
        findElementAndClick(By.id("com.xueqiu.android:id/home_search"));
        return new SearchPage();
    }

    public static OpenAccoutPage toOpenAccout() {
        findElementsAndClick(By.id("tab_name"), 4);
        return new OpenAccoutPage();
    }

    /**
     * 懒加载模式测试
     * @return
     */
    public static HomeAppPage toHuShen() {
        findElementsAndClick(By.id("com.xueqiu.android:id/filter_name"), 3);
        return new HomeAppPage();
    }


//    @After
//    public void tearDown() {
////        driver.quit();
//    }
}

