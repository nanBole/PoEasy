package com.xueqiu.testCase;

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

import static org.hamcrest.Matchers.closeTo;
import static org.junit.Assert.assertThat;

/**
 * @author 我的袜子有个洞
 * @description:
 * @path: JunitTest com.yxbj.testCase
 * @date: 2021/4/9 14:08
 **/
@RunWith(Parameterized.class)
public class TestSearchAndPrice {

    public static SearchPage searchPage;

    @BeforeClass
    public static void beforeAll() throws MalformedURLException {
        App.start();
        searchPage = App.toSearch();
    }

    @Test
    public void search() {
        assertThat(searchPage.search("alibaba").getCurrentPrice(),
                closeTo(230.0, 10.0));
    }

}
