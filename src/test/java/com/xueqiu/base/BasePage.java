package com.xueqiu.base;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author 我的袜子有个洞
 * @description:
 * @path: JunitTest com.yxbj.page
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
            handleAlert();
            driver.findElement(by).click();
        }

    }

    /**
     * 遍历查找随机出现的元素
     */
    private static void handleAlert() {
        System.out.println("----- Start handling pop ups -----");
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
//            //TODO:暂时未遇到没有关闭按钮的弹窗，遇到后具体处理
//            if (alert.equals(By.id("yyy"))) {
//                System.out.println("yyy found");
//                //点击其他地方取消
//                Dimension size = driver.manage().window().getSize();
//                try {
//                    new TouchAction<>(driver).
//                            tap(PointOption.point(size.width / 2, size.height / 2)).perform();
//                } catch (Exception e) {
//                    e.printStackTrace();
//                } finally {
//                    System.out.println("yyy clicked");
//                }
//            }//TODO:

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
     * findElementsAllClick,不通用,只适合该系统特定测试用例
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
     * Map <String，String>反序列化
     * <p>
     * String jsonInput = "{\"key\": \"value\"}";
     * TypeReference<HashMap<String, String>> typeRef
     * = new TypeReference<HashMap<String, String>>() {};
     * Map<String, String> map = mapper.readValue(jsonInput, typeRef);
     * <p>
     * 我们像序列化一样使用Jackson的ObjectMapper，使用readValue（）处理输入。
     * 另外，请注意我们在所有反序列化示例中都将使用Jackson的TypeReference来描述目标Map的类型。
     * 这是Map的toString（）表示形式：
     * search:
     * steps:
     * - id: xxxx
     * - id: dddd
     * send: content
     * cancel:
     * - id: xxxx
     *
     * Yaml文件解析
     * @param method
     * @throws IOException
     */
    public static void parseSteps(String path ,String method) {

        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
//        参数直接指定路径
//        String path = "/" + this.getClass().getCanonicalName().replace(".",
//                "/") + ".yaml";
        TypeReference<HashMap<String, TestSteps>> typeRef
                = new TypeReference<HashMap<String, TestSteps>>() {
        };

        try {
            HashMap<String, TestSteps> steps = mapper.readValue(
                    BasePage.class.getResourceAsStream(path), typeRef
            );
            parseStepsForDriver(steps.get(method));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    /**
     *根据解析出的文件信息，来定义方法跟操作步骤的驱动
     * @param steps
     */
    private static void parseStepsForDriver(TestSteps steps){
//        steps.get(method).getSteps().forEach(step -> {
        steps.getSteps().forEach(step -> {
            //TODO:定位方式待完成
            WebElement element = null;
            String id = step.get("id");
            if (id != null) {
                element = findElement(By.id(id));
            }
            String xpath = step.get("xpath");
            if (xpath != null) {
                element = findElement(By.xpath(xpath));
            }
            //对应content-desc
            String aid = step.get("aid");
            if (aid != null) {
                //MobileBy extends By...
                element = findElement(MobileBy.AccessibilityId(aid));
            }

            //TODO：具体操作步骤抽象
            //输入
            String send = step.get("send");
            //获取属性
            String attr = step.get("get");
            if (send!=null){
                element.sendKeys(send);
            }else if (attr!=null){
                element.getAttribute(attr);
            }else {
                element.click();
            }
        });
    }

    /**
     * 通过方法名解析yaml文件
     * @param method
     */
    public  void parseSteps(String method) {

        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
//        参数直接指定路径
        String path = "/" + this.getClass().getCanonicalName().replace(".",
                "/") + ".yaml";
        TypeReference<HashMap<String, TestSteps>> typeRef
                = new TypeReference<HashMap<String, TestSteps>>() {
        };

        try {
            HashMap<String, TestSteps> steps = mapper.readValue(
                    this.getClass().getResourceAsStream(path), typeRef
            );
            parseStepsForDriver(steps.get(method));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
