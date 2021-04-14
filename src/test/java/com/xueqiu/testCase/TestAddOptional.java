package com.xueqiu.testCase;

import com.xueqiu.App.App;
import com.xueqiu.App.SearchPage;
import io.qameta.allure.*;
import io.qameta.allure.junit4.DisplayName;
import org.junit.BeforeClass;
import org.junit.Test;

import java.net.MalformedURLException;

import static org.hamcrest.Matchers.closeTo;
import static org.junit.Assert.assertThat;

/**
 * @author 我的袜子有个洞
 * @description: 添加自选
 * @path: JunitTest com.xueqiu.testCase
 * @date: 2021/4/12 11:53
 **/
public class TestAddOptional {


    public static SearchPage searchPage;

    @BeforeClass
    public static void beforeAll() throws MalformedURLException {
        App.start();
        searchPage = App.toSearch();
    }

    @Test
    @Step("Search Step")
    @DisplayName("Allure2Demo DisplayName")
    @Description("Allure2测试用例C")
    @Link("https://dev.mobizone.cn:8080/Team01ProjectCollection/xqTest/_queries")
    @Link(name = "bugAddress",type = "mylink")
    @Issue("002")
    @Severity(SeverityLevel.MINOR)
    public void optional() {
       searchPage.search("alibaba").clickAndAdd();
    }


}
