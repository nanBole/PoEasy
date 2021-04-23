package com.xueqiu.testCase;

import com.xueqiu.App.App;
import com.xueqiu.App.HomeAppPage;
import com.xueqiu.Utils.RetryRule;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;

import java.net.MalformedURLException;

import static org.hamcrest.Matchers.closeTo;
import static org.junit.Assert.assertThat;

/**
 * @author 我的袜子有个洞
 * @description:
 * @path: PoEasy com.xueqiu.testCase
 * @date: 2021/4/21 18:21
 **/
public class TestHomeAppPage {

    @Rule
    public RetryRule retryRule = new RetryRule(2);

    public static HomeAppPage testHomeAppPage;

    @BeforeClass
    public static void beforeAll() throws MalformedURLException {
        App.start();
        testHomeAppPage = App.toHomeAppPage();
    }

    @Test
    public void getTest() throws InterruptedException {
        System.out.printf("结果是：%s", testHomeAppPage.getNewsCount());
    }

}
