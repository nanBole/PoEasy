package com.org.WeWork.page;

import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 我的袜子有个洞
 * @description:
 * @path: JunitTest com.org.WeWork.page
 * @date: 2021/3/16 17:36
 **/
public class BroadCastPage extends BasePage {
    /**
     * 消息群发
     */
    public BroadCastPage messageSend(String member,String title,String body,String author){
        findElement(By.partialLinkText("选择需要发消息的应用"),10).click();
        findElement(By.cssSelector(".ww_icon_AppNotice")).click();
        findElement(By.linkText("确定")).click();
        findElement(By.partialLinkText("选择发送范围")).click();
        findElement(By.id("memberSearchInput"),5).sendKeys(member);
        findElement(By.cssSelector(".ww_searchResult_title_peopleName")).click();
        findElement(By.linkText("确认")).click();
        findElement(By.cssSelector(".ww_editorTitle")).sendKeys(title);
        switchToFrame(0);
        findElement(By.cssSelector(".msg_noticeEditor_frameBody")).sendKeys(body);
        exitFrame();
        findElement(By.cssSelector(".js_amrd_sendName")).sendKeys(author);
        findElement(By.linkText("发送")).click();
        findElement(By.linkText("确定")).click();
//        System.out.println(df.format(new Date()));
        return this;
    }

    public List<String> getSendMsg(){
        List<String> msg = new ArrayList<>();
        findElements(By.cssSelector(".msg_history_msgList_td")).forEach(element -> {
            msg.add(element.getText());
        });


//        findElements(By.cssSelector(".msg_history_msgList_td")).forEach(new Consumer<Object>(){
//
//            @Override
//            public void accept(Object element) {
//                System.out.println(element);
//            }
//        });

//        List<WebElement> elements = findElements(By.cssSelector(".msg_history_msgList_td"));
//        for (WebElement element : elements) {
//            String res =  element.getText();
//            System.out.println(res);
//            msg.add(res);
//        }
        return msg;

    }


}
