package com.xueqiu.getResources;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * @author 我的袜子有个洞
 * @description: 路径测试，读取的地址路径为编译后的路径
 * file:/D:/IntelliJ%20IDEA%202019.1.3/workspace/PoEasy/target/test-classes/
 * file:/D:/IntelliJ%20IDEA%202019.1.3/workspace/PoEasy/target/test-classes/App/TestStock.yaml
 * @path: PoEasy com.xueqiu.getResources
 * @date: 2021/4/27 20:03
 **/
public class TestResources {
    @Test
    public void readFile() throws IOException {
        System.out.println(this.getClass().getResource("/"));
        System.out.println(this.getClass().getResource("/app/TestStock.yaml"));
        System.out.println(this.getClass().getResource("/app/TestStock.yaml").getPath());
        String path = this.getClass().getResource("/app/TestStock.yaml").getPath();
        String res = FileUtils.readFileToString(new File(path), "UTF-8");
        System.out.println(res);
    }

    public static void main(String[] args) {

    }
}
