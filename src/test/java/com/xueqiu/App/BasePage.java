package com.xueqiu.App;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 我的袜子有个洞
 * @description:
 * @path: JunitTest com.yxbj.App
 * @date: 2021/4/9 14:02
 **/
public class BasePage {

    public static AndroidDriver driver;

    /**
     * findElement方法，如果找不到元素，handleAlert()处理
     * @param by
     * @return
     */
    public static WebElement findElement(By by){
        //TODO 递归是最好的处理方式
       try {
           return driver.findElement(by);
       }catch (Exception e){
           //TODO 随机出现的元素处理
           handleAlert();
           return driver.findElement(by);
       }

    }

    /**
     * findElementAndClick方法，如果找不到元素，handleAlert()处理
     * @param by
     */
    public static void findElementAndClick(By by){
        //TODO
        try {
             driver.findElement(by).click();
        }catch (Exception e){
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
//        alertBox.add(By.xpath("yyy"));

        alertBox.forEach(alert -> {
            By adsLocator = alert;
            List<WebElement> ads = driver.findElements(adsLocator);
            if (ads.size() >= 1) {
                ads.get(0).click();
            }
        });
    }

    /**
     * findElements
     * @param by
     * @return
     */
    public static List<WebElement> findElements(By by) {
        return driver.findElements(by);
    }

    /**
     * findElementsAndClick
     */
    public static void findElementsAndClick(By by,int index) {
        List<WebElement> ele= driver.findElements(by);
        ele.get(index).click();
    }



    /**
     * 测试手机页面是原生还是Webview
     * @throws InterruptedException
     */
    public static void webView() throws InterruptedException {
        System.out.println(driver.getContext());
        Thread.sleep(3000);
        for (Object str: driver.getContextHandles()){
            System.out.println(str);
        }
        Thread.sleep(3000);
        System.out.println(driver.getContext());
    }


}
