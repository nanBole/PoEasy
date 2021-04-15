package com.xueqiu.testCase;

import com.xueqiu.Utils.RetryRule;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author 我的袜子有个洞
 * @description:
 * @path: PoEasy com.xueqiu.testCase
 * @date: 2021/4/15 21:49
 **/
public class TestRule {


    @Rule
    public RetryRule retryRule = new RetryRule(5);

    @Test
    public void TestAddition_isCorrect() throws Exception {
        assertEquals(8, 2 + 2);
    }

    @Test
    public void TestMulitiplication_isCorrect() throws Exception {
        assertEquals(4, 2 * 2);
    }

}

