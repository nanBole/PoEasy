package com.org.WeWork.testCase;

import com.org.WeWork.Utils.RetryRule;
import com.org.WeWork.page.App;

import org.junit.*;



/**
 * @author 我的袜子有个洞
 * @description:
 * @path: JunitTest com.org.WeWork
 * @date: 2021/3/8 16:56
 **/

public class ContactPageTest {

    public static App app;

     String phone = "1112222" +(int) (Math.random() * 10000);

    @BeforeClass
    public static void beforeAll()  {
        app = new App();
        app.loginWithCookie();
    }

    @Test
    public void add(){
        app.toMemberAdd().add(phone,phone,phone);
    }

    @Test
    public void delete() throws InterruptedException {
        app.toMemberAdd().add(phone,phone,phone).delete(phone);
    }

    @Test
    public void deleteCurrentPage() throws InterruptedException {
        app.toContact().deleteCurrentPage();
    }

    @Test
    public void fileUpload(){
        app.toContact().importMemberFile("D:\\IntelliJ IDEA 2019.1.3\\workspace\\JunitTest\\src\\test\\resources\\通讯录批量导入模板.xlsx");
    }





}
