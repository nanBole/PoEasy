package com.xueqiu.Utils;


import com.xueqiu.App.BasePage;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Augmenter;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * @author 我的袜子有个洞
 * @description:
 * @path: PoEasy com.xueqiu.Utils
 * @date: 2021/4/16 0:30
 * https://testerhome.com/topics/10225
 **/
public class TakeScreenShot extends BasePage {

    private static Logger logger = Logger.getLogger(TakeScreenShot.class);

    public static void takePhotoWithApp(String desfilePath,int res) {

        // make screenshot and get is as base64
        final WebDriver augmentedDriver = new Augmenter().augment(driver);
        ((TakesScreenshot) augmentedDriver).getScreenshotAs(OutputType.BASE64);
        // make screenshot and save it to the local filesystem
        //截图
        final File srcfile = ((TakesScreenshot) augmentedDriver)
                .getScreenshotAs(OutputType.FILE);
        try {//拷贝到指定目录文件
            FileUtils.copyFile(srcfile, FileUtils.getFile(desfilePath), true);
            logger.info("----- case failure -----");
            logger.info("----- 图片编号"+ res +" -----");
        } catch (final Exception e) {
            System.out.println(e.toString() + "\n");
        }
    }

}