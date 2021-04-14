package com.org.WeWork.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;


/**
 * @author 我的袜子有个洞
 * @description:
 * @path: JunitTest com.org.WeWork.page
 * @date: 2021/3/8 17:42
 **/
public class ContactPage extends BasePage {   //通讯录
    /**
     * 添加成员
     * @param userName 姓名
     * @param acctId 账号
     * @param phone 电话
     * @return
     */

    // 添加
    public ContactPage add(String userName, String acctId, String phone){
        findElement(By.id("username")).sendKeys(userName);
        findElement(By.id("memberAdd_acctid")).sendKeys(acctId);
        findElement(By.id("memberAdd_phone")).sendKeys(phone);
        findElement(By.linkText("保存")).click();
        return this;

    }

    // 删除

    /**  这3种都不行
     *       new WebDriverWait(driver, 5,5000).until(ExpectedConditions.elementToBeClickable(By.linkText("删除")));
     *       driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
     *       driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
     * @param keyWord
     * @return
     * @throws InterruptedException
     */
    public ContactPage delete(String keyWord) throws InterruptedException {
        findElement(By.id("memberSearchInput")).sendKeys(keyWord);
        Thread.sleep(5000);
//      waitClickable(By.linkText("删除"));
        findElement(By.linkText("删除")).click();
        Thread.sleep(1000);
        findElement(By.linkText("确认")).click();
        findElement(By.id("clearMemberSearchInput")).click();
        return this;
    }

    /**
     * 删除通讯录页面的成员信息1
     */

    public ContactPage deleteCurrentPage()  {
        try {//等待页面加载完成，没有变化了再继续操作
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        waitClickable(By.cssSelector(".ww_checkbox"));
        List<WebElement> elements = findElements(By.cssSelector(".ww_checkbox"));
        for (int i =2 ; i < elements.size();i++){
            elements.get(i).click();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        waitClickable(By.linkText("删除"));
        findElement(By.linkText("删除")).click();
        findElement(By.linkText("确认")).click();
        return this;
    }

    /**
     * 批量导入文件1
     */
    public ContactPage importMemberFile(String path){

        findElement(By.partialLinkText("批量导入/导出"),10).click();
        findElement(By.linkText("文件导入")).click();
        findElement(By.id("js_upload_file_input")).sendKeys(path);
        findElement(By.id("submit_csv"),10).click();
        findElement(By.id("reloadContact")).click();
        return this;
    }


    // list列表
    public void list(){

    }

}
