package com.xueqiu.testCase;

import com.xueqiu.App.App;
import com.xueqiu.App.SearchPage;
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
    public void optional() {
       searchPage.search("alibaba").clickAndAdd();
    }


}
