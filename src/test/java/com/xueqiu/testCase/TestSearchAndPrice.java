package com.xueqiu.testCase;

import com.xueqiu.App.App;
import com.xueqiu.App.SearchPage;
import com.xueqiu.Utils.RetryRule;
import org.junit.*;

import java.net.MalformedURLException;

import static org.hamcrest.Matchers.closeTo;
import static org.junit.Assert.assertThat;

/**
 * @author 我的袜子有个洞
 * @description:
 * @path: JunitTest com.yxbj.testCase
 * @date: 2021/4/9 14:08
 **/
public class TestSearchAndPrice {

    @Rule
    public RetryRule retryRule = new RetryRule(5);

    public static SearchPage searchPage;

    @BeforeClass
    public static void beforeAll() throws MalformedURLException {
        App.start();
        searchPage = App.toSearch();
    }

    @Test
    public void search() {
        assertThat(searchPage.search("alibaba").getCurrentPrice(),
                closeTo(241.0, 10.0));
//        searchPage.search("alibaba").getCurrentPrice();
    }



}
