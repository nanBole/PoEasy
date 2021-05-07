package com.xueqiu.testCase;

import com.org.WeWork.page.BasePage;
import com.xueqiu.page.App;
import com.xueqiu.page.OpenAccoutPage;
import com.xueqiu.Utils.RetryRule;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;

import java.net.MalformedURLException;

import static com.xueqiu.base.BasePage.webView;

/**
 * @author 我的袜子有个洞
 * @description:
 * @path: JunitTest com.yxbj.testCase
 * @date: 2021/4/9 14:35
 **/
public class TestOpenAccout extends BasePage {

    @Rule
    public RetryRule retryRule = new RetryRule(5);

    private static OpenAccoutPage openAccoutPage;

    @BeforeClass
    public static void beforeAll() throws MalformedURLException {
        App.start();
        openAccoutPage = App.toOpenAccout();
    }

    @Ignore("Not Ready to Run")
    @Test
    public void openAccount() throws InterruptedException {
        System.out.println("成功进入开户页面");

        webView();
    }
}
