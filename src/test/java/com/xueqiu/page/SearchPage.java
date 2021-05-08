package com.xueqiu.page;

import com.xueqiu.Utils.ExcuteSwipe;
import com.xueqiu.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * @author 我的袜子有个洞
 * @description:
 * @path: JunitTest com.yxbj.page
 * @date: 2021/4/9 14:14
 **/
public class SearchPage extends BasePage {

    private By inputBox = By.id("com.xueqiu.android:id/search_input_text");
    private By selectBox = By.id("com.xueqiu.android:id/stockCode");
    private By current_price = By.id("com.xueqiu.android:id/stock_current_price");
    private By add = By.id("com.xueqiu.android:id/add_attention");
    private By cancel = By.id("com.xueqiu.android:id/action_close");

    /**
     * 搜索框输入股票名称
     *
     * @param keyWord
     * @return
     */
    public SearchPage search(String keyWord) {
        findElement(inputBox).sendKeys(keyWord);
        return this;
    }

    /**
     * 获取股票价格
     *
     * @return
     */
    public double getCurrentPrice() {
        List<WebElement> ele = findElements(selectBox);
        ele.get(0).click();
        System.out.println(findElement(current_price).getText());
        return Double.parseDouble(findElement(current_price).getText());
    }

    /**
     * 搜索页【+】按钮
     */
    public SearchPage clickAndSelectStock() {
        findElementsAndClick(add, 0);
        return this;
    }

    /**
     * 搜索框取消按钮,该按钮从哪个页面进去，取消后就是返回哪个页面
     *
     * @return
     */
    public App cancel() {
        findElementAndClick(cancel);
        ExcuteSwipe.executeSlide();

        return new App();
    }


}
