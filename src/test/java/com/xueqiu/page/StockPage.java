package com.xueqiu.page;

import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 我的袜子有个洞
 * @description:
 * @path: PoEasy com.xueqiu.page
 * @date: 2021/4/25 20:10
 **/
public class StockPage extends BasePage {

    private By stock_Group = By.id("com.xueqiu.android:id/edit_group");
    private By page_Stock = By.id("com.xueqiu.android:id/tv_edit_stock");
    private By check_All = By.id("com.xueqiu.android:id/check_all");
    private By cancel_Follow = By.id("com.xueqiu.android:id/cancel_follow");
    private By accpet_Button = By.id("android:id/button1");
    private By action_Close = By.id("com.xueqiu.android:id/action_close");

    private By stock_Name = By.id("com.xueqiu.android:id/stockName");
    private By hot_Stocks = By.id("com.xueqiu.android:id/tv_check");
    private By add_Focus = By.id("com.xueqiu.android:id/iv_focus");
    private By back = By.id("android:id/up");
    private By create_Cube = By.id("com.xueqiu.android:id/action_create_cube");
    /**
     * 删除所有自选股
     */
    public StockPage deleteAllStocks() {
        findElementAndClick(stock_Group);
        findElementAndClick(page_Stock);
        findElementAndClick(check_All);
        findElementAndClick(cancel_Follow);
        findElementAndClick(accpet_Button);
        findElementAndClick(action_Close);
        return this;
    }

    /**
     * 获取所有自选股信息
     */
    public List<String> getAllStocks() {
        List<String> stocks = new ArrayList<>();
        findElements(stock_Name).forEach(element -> {
            stocks.add(element.getText());
        });
        System.out.println(stocks);
        return stocks;
    }


    /**
     * 添加热门股票自选
     */

    public StockPage addDefaultSelectedStocks() {
        findElementAndClick(hot_Stocks);
        findElementsAllClick(add_Focus);
        findElementAndClick(back);
        return this;
    }

    /**
     * 添加单只股票自选
     */
    public SearchPage toSearch(){
        findElementAndClick(create_Cube);
        return new SearchPage();
    }

}
