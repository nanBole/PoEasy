package com.xueqiu.testCase;

import com.xueqiu.App.App;
import com.xueqiu.App.StockPage;
import com.xueqiu.Utils.RetryRule;
import org.junit.Rule;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.net.MalformedURLException;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

/**
 * @author 我的袜子有个洞
 * @description: 添加股票自选
 * @path: PoEasy com.xueqiu.testCase
 * @date: 2021/4/21 18:21
 **/
public class TestStock {

    @Rule
    public RetryRule retryRule = new RetryRule(2);

    public static StockPage stockPage;

    @BeforeAll
    public static void beforeAll() throws MalformedURLException {
        App.start();
        stockPage = App.toStocks();
    }
    //每个方法都会执行的-Junit5
    @BeforeEach
    public void beforeEach(){
        System.out.println("--- test begining ---");
    }

   @Test
    public  void addDefaultStocks() throws InterruptedException {
       if (stockPage.getAllStocks().size() >=1){
           stockPage.deleteAllStocks();
       }

       assertThat(stockPage.addDefaultSelectedStocks().getAllStocks().size()
               ,greaterThanOrEqualTo(4));
   }

}
