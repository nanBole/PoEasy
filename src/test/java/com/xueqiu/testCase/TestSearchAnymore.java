package com.xueqiu.testCase;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.xueqiu.page.App;
import com.xueqiu.page.SearchPage;
import com.xueqiu.Utils.RetryRule;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.IOException;
import java.net.MalformedURLException;
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
    public RetryRule retryRule = new RetryRule(2);

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
     * 参数提供，从外部yaml文件中读取
     * @return
     */
    @Parameterized.Parameters
    public static List<String> data() throws IOException {
        //从文件中读取数据，保持路径相同
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        String path = "/"+ TestSearchAnymore.class.getCanonicalName().replace(".",
                "/") + ".yaml";
        List datas = mapper.readValue(TestSearchAnymore.class.getResourceAsStream(
                path),List.class);
       return datas;
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
