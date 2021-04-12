package com.org.WeWork.testCase;

import com.org.WeWork.page.App;
import org.junit.AfterClass;
import org.junit.BeforeClass;
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
    public static App app;
    @BeforeClass
    public static void beforeAll()  {
        app = new App();
        app.loginWithCookie();
    }

    @Test
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
//        app.tearDown();
    }
}
