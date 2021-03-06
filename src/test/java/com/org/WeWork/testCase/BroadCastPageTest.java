package com.org.WeWork.testCase;

import com.org.WeWork.Utils.RetryRule;
import com.org.WeWork.page.App;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import static org.hamcrest.Matchers.*;
import java.util.List;

import static org.junit.Assert.assertThat;

/**
 * @author 我的袜子有个洞
 * @description:
 * @path: JunitTest com.org.WeWork.testCase
 * @date: 2021/3/17 15:12
 **/

public class BroadCastPageTest {

    @Rule
    public RetryRule retryRule = new RetryRule(1);

    public static App app;

    @BeforeClass
    public static void beforeAll()  {
        app = new App();
        app.loginWithCookie();
    }

    @Test
    @Step("messageSend Step")
    @Description("发送消息")
    public void toSendMessage(){
        String title = "快递";
        List<String> sendMsg = app.toGroupMessage()
                .messageSend("刘秀南", title, "您的快递到了", "老刘")
                .getSendMsg();
        assertThat(sendMsg,hasItem(title));
    }

//    @Test
//    public void getSendMsgTest(){
//        app.toGroupMessage().messageSend("刘秀南","快递","您的快递到了","老刘").getSendMsg();
//    }


    @AfterClass
    public static void quit(){
        app.tearDown();
    }
}
