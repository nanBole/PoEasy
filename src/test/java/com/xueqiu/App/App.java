package com.xueqiu.App;

import io.appium.java_client.android.AndroidDriver;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

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
        desiredCapabilities.setCapability("autoGrantPermissions", true);
        //配置chomerdriver路径,配置多个版本的chromerdriver,当存在webview时,可以自己寻找匹配的驱动
        desiredCapabilities.setCapability("chromedriverExecutableDir", "D:/selenium");
        //noSign表示不重签名，设置为true表示不重签名app
        desiredCapabilities.setCapability("noSign", true);
        URL remoteUrl = new URL("http://localhost:4723/wd/hub");

        driver = new AndroidDriver(remoteUrl, desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

//        //判断页面是否加载完成

        new WebDriverWait(driver,30).until(x ->{
            System.out.println(System.currentTimeMillis());
            String xml = driver.getPageSource();
            Boolean  exist = xml.contains("home_search") || xml.contains("image_cancel");
            System.out.println(exist);
            return exist;
        });
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
     * 自选
     * @return
     */
    public static StockPage toStocks(){
        findElementAndClick(By.xpath("//*[contains(@resource-id,'tab_name') and @text='自选']"));
        return new StockPage();
    }

    /**
     * 懒加载模式测试
     * @return
     */
    public static HomeAppPage toHomeAppPage() {
        findElementsAndClick(By.id("com.xueqiu.android:id/filter_name"), 3);
        return new HomeAppPage();
    }


//    @After
//    public void tearDown() {
////        driver.quit();
//    }
}

