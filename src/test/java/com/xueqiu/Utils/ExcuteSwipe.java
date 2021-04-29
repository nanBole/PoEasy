package com.xueqiu.Utils;

import com.xueqiu.page.BasePage;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

import java.time.Duration;

/**
 * @author 我的袜子有个洞
 * @description:
 * @path: PoEasy com.xueqiu.Utils
 * @date: 2021/4/27 17:30
 **/
public class ExcuteSwipe  extends BasePage {

    /**
     * 滑动屏幕
     */
    public static void executeSlide() {
//        System.out.println("滑动");
        TouchAction ta = new TouchAction(driver);
        int width = driver.manage().window().getSize().width;//当前屏幕的宽度
        int height = driver.manage().window().getSize().height; //当前屏幕的高度
        //new一个TouchAction对象，调用其按压press()方法，输入坐标点,moveTo移动到下一个坐标点，之后调用release()和perform()方法执行
        PointOption P_B = PointOption.point(width / 2, height  / 3);
        PointOption P_N = PointOption.point(width / 2, height * 3 / 4);
        WaitOptions waitOption = WaitOptions.waitOptions(Duration.ofSeconds(1));//设置动作持续时间：按压一秒
//        System.out.println("执行");
        ta.press(P_B).waitAction(waitOption).moveTo(P_N).release().perform();//按压一秒——移动——松开释放
    }
}
