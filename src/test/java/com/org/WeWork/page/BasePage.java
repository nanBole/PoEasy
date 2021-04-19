package com.org.WeWork.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.List;

/**
 * @author 我的袜子有个洞
 * @description:
 * @path: JunitTest com.org.WeWork.page
 * @date: 2021/3/9 11:35
 * 基类，所有的页面都继承于他
 **/
public class BasePage {

    public static WebDriver driver;

    //driver.findElement
    //常规find
    public WebElement findElement(By by) {

        return driver.findElement(by);
    }

    //增加显示等待find
    public WebElement findElement(By by, int timeout) {
        System.out.println(by);
        if (timeout > 0) {//当时间设置为0的时候，不需要等待,大于0,等待对应时间
            waitClickable(by, timeout);
        }
        return driver.findElement(by);
    }

    public List<WebElement> findElements(By by) {
        return driver.findElements(by);
    }

    //刷新
    public void refresh() {
        driver.navigate().refresh();
    }

    //等待
    public void waitClickable(By by, int timeout) {
        new WebDriverWait(driver, timeout).until(ExpectedConditions.elementToBeClickable(by));
    }

    //等待  ,写死时间
    public void waitClickable(By by) {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(by));
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(by));
    }

    //等待
    public void sleep(long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //切换frame
    public void switchToFrame(int num) {
//        driver.switchTo().frame("ueditor_1");
        driver.switchTo().frame(num);
    }

    //切出frame
    public void exitFrame() {
        driver.switchTo().defaultContent();
    }

    //退出
    public void quit() {
        driver.quit();
    }



}
