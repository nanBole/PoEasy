package com.org.WeWork.page;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

/**
 * @author 我的袜子有个洞
 * @description:
 * @path: JunitTest com.org.WeWork.page
 * @date: 2021/3/8 17:40
 **/
public class App extends BasePage {
    /**
     * loginWithCookie
     *
     * @return (1) NONE: 当html下载完成之后，不等待解析完成，selenium会直接返回
     * (2) EAGER: 要等待整个dom树加载完成，即DOMContentLoaded这个事件完成，仅对html的内容进行下载解析
     * (3) NORMAL: 即正常情况下，selenium会等待整个界面加载完成（指对html和子资源的下载与解析,如JS文件，图片等，不包括ajax）
     */
    public App loginWithCookie() {

        //cookie
        String sid = "RLfO6jSPTAr5nOy3-2A11gsHmMzEmceiLouRGpRyjGt24TLxyqozEQLFOQ7cAg3U";
        String url = "https://work.weixin.qq.com/";
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NONE);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        System.out.println("打开企业微信登录页面：" + driver.getCurrentUrl());
        driver.get(url);
        System.out.println("点击企业登录按钮:");
        driver.findElement(By.linkText("企业登录")).click();
        System.out.println("添加Cookie直接登录:");
        driver.manage().addCookie(new Cookie("wwrtx.sid", sid));
        driver.navigate().refresh();
        if ("https://work.weixin.qq.com/wework_admin/frame".equals(driver.getCurrentUrl())) {
            System.out.println("登录成功");
        }
        return this;
    }

    /**
     * 通讯录
     */
    public ContactPage toContact() {
//      findElement(By.id("menu_contacts"));
        findElement(By.linkText("通讯录")).click();
        return new ContactPage();
    }

    /**
     * 添加成员
     */
    public ContactPage toMemberAdd() {
        //find  click
        findElement(By.linkText("添加成员")).click();
        return new ContactPage();
    }


    /**
     * 管理工具
     */
    public BroadCastPage toGroupMessage() {
        findElement(By.linkText("管理工")).click();
        findElement(By.partialLinkText("消息群发"), 10).click();
        return new BroadCastPage();

    }

    public void tearDown() {
        quit();
    }

    /**
     * debug
     * @param args
     */
//    public static void main(String[] args) {
//        String phone = "1102222" +(int)(Math.random() * 10000) ;
//        System.out.println(phone);
//    }
}
