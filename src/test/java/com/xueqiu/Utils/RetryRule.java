package com.xueqiu.Utils;

import org.apache.log4j.Logger;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

/**
 * @author 我的袜子有个洞
 * @description: implement一个TestRule interface，实现一个叫apply()的方法。这个方法需要返回一个Statement对象
 * @path: PoEasy com.xueqiu.Utils
 * @date: 2021/4/15 21:42
 **/
public class RetryRule implements TestRule {

    private static Logger logger = Logger.getLogger(RetryRule.class);

    private int retryCount;

    public int getRetryCount() {
        return retryCount;
    }

    public void setRetryCount(int retryCount) {
        this.retryCount = retryCount;
    }

    /**
     * 有参数构造方法
     *
     * @param retryCount
     */
    public RetryRule(int retryCount) {
        this.retryCount = retryCount;
    }

    /**
     * 实现apply方法
     *
     * @return
     */
    public Statement apply(Statement base, Description description) {
        return statement(base, description);
    }

    private Statement statement(Statement base, final Description description) {
        return new Statement() {
            @Override
            public void evaluate() throws Throwable {

                String className = description.getClassName();
                String methodName = description.getMethodName();

                Throwable caughtThrowable = null;
                // implement retry logic here
                for (int i = 0; i < retryCount; i++) {
                    try {
                        //想要在测试方法运行之前做一些事情，就在base.evaluate()之前做
                        base.evaluate();
                        logger.info( className + "." + methodName + " case success, " + (i + 1));
                        return;
                    }catch (Throwable t){
                        caughtThrowable = t;
                        logger.info( className + "." +  methodName + " case failed, " + (i + 1) + ", " + t.getMessage());
                        //用例失败截图
                        TakeScreenShot.takePhotoWithWeb();
                        logger.info("----- 已截取失败用例图片 -----");
                    }
                }
                throw caughtThrowable;
            }
        };
    }
}
