package com.xueqiu.getResources;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.xueqiu.testCase.TestSearchAnymore;
import org.apache.commons.io.FileUtils;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @author 我的袜子有个洞
 * @description: 路径测试，读取的地址路径为编译后的路径
 * file:/D:/IntelliJ%20IDEA%202019.1.3/workspace/PoEasy/target/test-classes/
 * file:/D:/IntelliJ%20IDEA%202019.1.3/workspace/PoEasy/target/test-classes/page/TestStock.yaml
 * @path: PoEasy com.xueqiu.getResources
 * @date: 2021/4/27 20:03
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
                "/com/xueqiu/testCase/TestSearchAnymore.yaml"),List.class);
        System.out.println(data);
    }

    @Test
    public void test1(){
        System.out.println(TestSearchAnymore.class.getCanonicalName());
        System.out.println("/"+ TestSearchAnymore.class.getCanonicalName()
                            .replace(".","/") + ".yaml");
    }


}
