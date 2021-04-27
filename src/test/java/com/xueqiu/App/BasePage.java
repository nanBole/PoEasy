package com.xueqiu.App;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.DecimalFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author 我的袜子有个洞
 * @description:
 * @path: JunitTest com.yxbj.App
 * @date: 2021/4/9 14:02
 **/
public class BasePage {

    public static AndroidDriver<WebElement> driver;

    /**
     * findElement方法，如果找不到元素，handleAlert()处理
     *
     * @param by
     * @return
     */
    public static WebElement findElement(By by) {
        //TODO 递归是最好的处理方式
        try {
            System.out.println(by);
            return driver.findElement(by);
        } catch (Exception e) {
            //TODO 随机出现的元素处理
            handleAlert();
            return driver.findElement(by);
        }

    }

    //等待  ,写死时间
    public static void waitClickable(By by) {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(by));
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(by));
    }

    /**
     * findElementAndClick方法，如果找不到元素，handleAlert()处理
     *
     * @param by
     */
    public static void findElementAndClick(By by) {
        //TODO
        try {
            System.out.println("click:" + by);
            driver.findElement(by).click();
        } catch (Exception e) {
            //TODO 随机出现的元素处理
            handleAlert();
            driver.findElement(by).click();
        }

    }

    /**
     * 遍历查找随机出现的元素
     */
    private static void handleAlert() {
        System.out.println("开始处理随机出现得升级框或者随机出现得广告弹窗");
        List<By> alertBox = new ArrayList<>();
        //添加定位参数
        alertBox.add(By.id("com.xueqiu.android:id/image_cancel"));
        alertBox.add(By.id("com.xueqiu.android:id/iv_close_tip"));
        alertBox.add(By.className("android.widget.ImageView"));

        // 没有关闭按钮的弹窗
        // alertBox.add(By.id("yyy"));
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        alertBox.forEach(alert -> {
//            By adsLocator = alert;
            List<WebElement> ads = driver.findElements(alert);
            if (ads.size() >= 1) {
                ads.get(0).click();
            }
            //处理没有关闭按钮的弹窗
            //TODO:暂时未遇到没有关闭按钮的弹窗，遇到后具体处理
            if (alert.equals(By.id("yyy"))) {
                System.out.println("yyy found");
                //点击其他地方取消
                Dimension size = driver.manage().window().getSize();
                try {
                    new TouchAction<>(driver).
                            tap(PointOption.point(size.width / 2, size.height / 2)).perform();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    System.out.println("yyy clicked");
                }
            }//TODO:

        });
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    /**
     * findElements
     *
     * @param by
     * @return
     */
    public static List<WebElement> findElements(By by) {
        System.out.println(by);
        return driver.findElements(by);
    }

    /**
     * findElementsAndClick
     */
    public static void findElementsAndClick(By by, int index) {
        List<WebElement> ele = driver.findElements(by);
        ele.get(index).click();
        waitClickable(by);
    }

    /**
     * findElementsAllClick
     */
    public static void findElementsAllClick(By by) {
        List<WebElement> ele = driver.findElements(by);
        for (int i = 0; i < 4; i++) {
            ele.get(i).click();
        }
    }

    /**
     * 测试手机页面是原生还是Webview
     *
     * @throws InterruptedException
     */
    public static void webView() throws InterruptedException {
        System.out.println(driver.getContext());
        Thread.sleep(3000);
        for (Object str : driver.getContextHandles()) {
            System.out.println(str);
        }
        Thread.sleep(3000);
        System.out.println(driver.getContext());
    }

    /**
     * 滑动屏幕
     */
//    public static void executeSlide() {
////        System.out.println("滑动");
//        TouchAction ta = new TouchAction(driver);
//        int width = driver.manage().window().getSize().width;//当前屏幕的宽度
//        System.out.println(width);
//        int height = driver.manage().window().getSize().height; //当前屏幕的高度
//        System.out.println(height);
//        //new一个TouchAction对象，调用其按压press()方法，输入坐标点,moveTo移动到下一个坐标点，之后调用release()和perform()方法执行
//        PointOption P_B = PointOption.point(width / 2, height  / 3);
//        PointOption P_N = PointOption.point(width / 2, height * 3 / 4);
//        WaitOptions waitOption = WaitOptions.waitOptions(Duration.ofSeconds(1));//设置动作持续时间：按压一秒
////        System.out.println("执行");
//        ta.press(P_B).waitAction(waitOption).moveTo(P_N).release().perform();//按压一秒——移动——松开释放
//    }


}
