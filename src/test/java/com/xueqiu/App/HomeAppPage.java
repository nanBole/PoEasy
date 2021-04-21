package com.xueqiu.App;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * @author 我的袜子有个洞
 * @description:
 * @path: PoEasy com.xueqiu.App
 * @date: 2021/4/21 17:47
 **/
public class HomeAppPage extends BasePage {

    private By loadTest = By.id("com.xueqiu.android:id/load_more_text");


    public void getNewsCount() throws InterruptedException {

        WebElement ele = findElement(loadTest);

        String beforeSource = "";

        String afterSource = "";

       while (true){
            beforeSource = driver.getPageSource();
            JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
            javascriptExecutor.executeScript("argument[0].scrollIntoView();", ele);
            if (driver.getPageSource().contains("liuxiunan")){
                findElementAndClick(By.linkText("liuxiunan"));
                break;
            }
            Thread.sleep(2000);
            afterSource = driver.getPageSource();
            if (afterSource.equals(beforeSource)){
                System.out.println("已经到最底部了");
                break;
            }
            Thread.sleep(2000);
        }
        List<WebElement> ele2 = findElements(By.id("com.xueqiu.android:id/topic_title"));
        System.out.println(ele.getSize());

    }


}
