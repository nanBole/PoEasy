package com.xueqiu.testCase;

import com.sun.deploy.util.SearchPath;
import com.xueqiu.App.App;
import com.xueqiu.App.SearchPage;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

/**
 * @author 我的袜子有个洞
 * @description:
 * @path: JunitTest com.yxbj.testCase
 * @date: 2021/4/9 14:08
 **/
@RunWith(Parameterized.class)
public class TestSearchAnymore {

    public static SearchPage searchPage;

    @BeforeClass
    public static void beforeAll() throws MalformedURLException {
        App.start();
    }

    @Before
    public void before() {
        searchPage = App.toSearch();
    }

    @Parameterized.Parameters
    public static List<String> data() {
        List<String> stocks = new ArrayList<>();
        stocks.add("alibaba");
        stocks.add("xiaomi");
        stocks.add("jingdong");
        return stocks;
    }

    @Parameterized.Parameter
    public String stocks;

    @Test
    public void search() {
        searchPage.search(stocks);
    }

    @After
    public void tearDown() {
        searchPage.cancel();

    }


}
