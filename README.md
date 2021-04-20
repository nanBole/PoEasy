# PoEasy
根据po模式设计的web自动化和app自动化测试

#环境依赖
jdk1.8,Maven,junit4,allure,log4j,jenkins...

# Allure测试报告生成
执行测试：mvn clean test

生成报告：allure serve target/allure-results   ||   allure serve target/surefire-reports

allure-results 报告展示：
![allure-results](https://user-images.githubusercontent.com/29562824/114662894-0866aa80-9d2c-11eb-9e59-d505b756e9c5.png)

# 用例失败重跑展示
![image](https://user-images.githubusercontent.com/29562824/114899624-b154f880-9e45-11eb-86ba-0a5ada70f7da.png)

# 失败用例页面截图
![image](https://user-images.githubusercontent.com/29562824/114923412-6051fe00-9e5f-11eb-958d-46429b674d7b.png)

# App自动化脚本失败用例截图
![image](https://user-images.githubusercontent.com/29562824/115251190-e2db0600-a15c-11eb-953f-cad14be0f669.png)

# Case失败后截图并添加到Allure报告
![image](https://user-images.githubusercontent.com/29562824/115246662-ac02f100-a158-11eb-925a-010938023c1f.png)

# 集成Jenkins编译后查看Allure报告
![image](https://user-images.githubusercontent.com/29562824/115375933-d5775780-a200-11eb-8cc9-76f52d9ac6c8.png)

