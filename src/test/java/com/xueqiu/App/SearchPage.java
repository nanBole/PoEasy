package com.xueqiu.App;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * @author 我的袜子有个洞
 * @description:
 * @path: JunitTest com.yxbj.App
 * @date: 2021/4/9 14:14
 **/
public class SearchPage extends BasePage {

    private By inputBox = By.id("com.xueqiu.android:id/search_input_text");
    //
    private By selectBox = By.id("com.xueqiu.android:id/stockCode");
    private By current_price = By.id("com.xueqiu.android:id/stock_current_price");
    private By add = By.id("com.xueqiu.android:id/add_attention");
    private By cancel = By.id("com.xueqiu.android:id/action_close");

    public SearchPage search(String keyWord) {
        findElement(inputBox).sendKeys(keyWord);
        return this;
    }

    public double getCurrentPrice() {
        List<WebElement> ele = findElements(selectBox);
        ele.get(0).click();
        System.out.println(findElement(current_price).getText());
        return Double.parseDouble(findElement(current_price).getText());
    }

    public void clickAndAdd(){
        findElementsAndClick(add,0);
    }

    /**
     * 搜索框取消按钮
     * @return
     */
    public App cancel(){
        findElementAndClick(cancel);
        return new App();
    }


}
