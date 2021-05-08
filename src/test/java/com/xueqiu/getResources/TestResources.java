package com.xueqiu.getResources;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.Serializers;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.xueqiu.base.BasePage;
import com.xueqiu.base.TestSteps;
import com.xueqiu.page.App;
import com.xueqiu.page.SearchPage;
import com.xueqiu.testCase.TestSearchAnymore;
import org.apache.commons.io.FileUtils;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author 我的袜子有个洞
 * @description: 路径测试，读取的地址路径为编译后的路径

 **/
public class TestResources {

    public String name;
    public int age;

//    public TestResources(){}

    @Test
    public void readFile() throws IOException {
        System.out.println(this.getClass().getResource("/"));
        System.out.println(this.getClass().getResource("/app/TestStock.yaml"));
        System.out.println(this.getClass().getResource("/app/TestStock.yaml").getPath());
        String path = this.getClass().getResource("/app/TestStock.yaml").getPath();
        String res = FileUtils.readFileToString(new File(path), "UTF-8");
        System.out.println(res);
    }

    @Test
    public void writeJsonFile() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File("demo.json"), this);
    }

    @Test
    public void readJsonFile() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        TestResources resources = mapper.readValue(new File("demo.json"), this.getClass());
        System.out.println(resources);
        System.out.println(resources.name);
    }

    @Test
    public void readYamlFile() throws IOException {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        Object[][] data = mapper.readValue(this.getClass().getResourceAsStream("/page/testCase/TestStock.yaml"),
                Object[][].class);
        System.out.println(data);
    }

    @Test
    public void readYamlList() throws IOException {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        List data = mapper.readValue(this.getClass().getResourceAsStream(
                "/com/xueqiu/testCase/TestSearchAnymore.yaml"), List.class);
        System.out.println(data);
    }

    @Test
    public void test1() {
        System.out.println(TestSearchAnymore.class.getCanonicalName());
        System.out.println("/" + TestSearchAnymore.class.getCanonicalName()
                .replace(".", "/") + ".yaml");
    }

    @Test
    public void testYamlReader() {
//        Object serverHost = YamlReader.instance.getValueByKey("a.b.c.d");
//        System.out.println(serverHost);

    }

    @Test
    public void steps() throws JsonProcessingException {
        HashMap<String, TestSteps> testcase = new HashMap<String, TestSteps>();
        TestSteps testCaseSteps = new TestSteps();
        List<HashMap<String, String>> steps = new ArrayList<>();

        HashMap<String, String> map = new HashMap<>();
        map.put("id", "xxxx");
        map.put("send", "xxxx");
        steps.add(map);
        steps.add(map);

        testCaseSteps.setSteps(steps);
        testcase.put("search", testCaseSteps);

        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        System.out.println("1");
        mapper.writerWithDefaultPrettyPrinter().writeValueAsString(steps);
    }

    @Test
    public void testCaseStpes() throws MalformedURLException {
        App.start();
//        BasePage basePage = new BasePage();
//        basePage.parseSteps("search");
        SearchPage searchPage = new SearchPage();
        searchPage.parseSteps("search");
    }

}
