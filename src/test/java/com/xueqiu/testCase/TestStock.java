package com.xueqiu.testCase;

import com.xueqiu.page.App;
import com.xueqiu.page.StockPage;
import com.xueqiu.Utils.RetryRule;
import org.junit.Rule;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.net.MalformedURLException;
import java.util.stream.Stream;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

/**
 * @author 我的袜子有个洞
 * @description: 添加股票自选
 * @path: PoEasy com.xueqiu.testCase
 * @date: 2021/4/21 18:21
 **/
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestStock {

    @Rule
    public RetryRule retryRule = new RetryRule(2);

    public static StockPage stockPage;

    @BeforeAll
    public static void beforeAll() throws MalformedURLException {
        App.start();
        stockPage = App.toStocks();
    }

    @BeforeEach
    public void beforeEach(){
        System.out.println("--- ----- ---");
    }

    /**
     * 添加热门股票到自选
     * @description:order 可以设置从100开始，不必连续，防止中间加用例
     * @throws InterruptedException
     */
   @Test
   @Order(10)
    public  void addDefaultStocks() throws InterruptedException {
       if (stockPage.getAllStocks().size() >=1){
           stockPage.deleteAllStocks();
       }

       assertThat(stockPage.addDefaultSelectedStocks().getAllStocks().size()
               ,greaterThanOrEqualTo(4));
   }

    /**
     * 添加单只股票并取消
     * 使用Junit5参数化传递参数
     */
    @Order(20)
    @ParameterizedTest
    @MethodSource("data")
    public void addStock(String code, String name) {
        stockPage.toSearch().search(code).clickAndSelectStock().cancel();
        assertThat(stockPage.getAllStocks(),hasItem(name));
    }

    public static Stream<Arguments> data(){
        return Stream.of(
                arguments("pdd","拼多多"),
                arguments("jd","京东")
        );
    }




}
