package com.xueqiu.testCase;

import com.xueqiu.App.App;
import com.xueqiu.App.SearchPage;
import com.xueqiu.Utils.RetryRule;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;


/**
 * @author 我的袜子有个洞
 * @description:
 * @path: JunitTest com.yxbj.testCase
 * @date: 2021/4/9 14:08
 **/
@RunWith(Parameterized.class)
public class TestSearchAnymore {

    @Rule
    public RetryRule retryRule = new RetryRule(5);

    public static SearchPage searchPage;

    @BeforeClass
    public static void beforeAll() throws MalformedURLException {
        App.start();
    }


    @Before
    public void before() {
        searchPage = App.toSearch();
    }

    /**
     * 参数提供
     * @return
     */
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
        //取消
        searchPage.cancel();

    }


}
