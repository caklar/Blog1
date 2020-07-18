**html 文件放入 views 文件夹，css 文件放入 css 文件夹，js 文件放入 js 文件夹**
>更新：07-17 0：25

更新内容：
1. 更新后端目录结构，

![TIM截图20200717002638.png](https://i.loli.net/2020/07/17/XrVfT6npIcbAtCR.png)

分别对Dao、Service、Servlet创建示例类作为demo

2.更新测试文件夹，编写测试文件示例

![TIM截图20200717003109.png](https://i.loli.net/2020/07/17/KVPJiLBdbtF8Evy.png)

3.再再再次修改了数据库


> 以上是17日更新内容

# 环境
- 开发工具：IDEA  HBuilderX
- JDK版本：java version "1.8.0_201"
- 数据库版本：MySQL Server version: 8.0.15
- 服务器：Tomcat 9.0.29


# 数据库设计说明

### article_info 表

| 栏位      | 说明         |
| --------- | ------------ |
| a_id      | 文章id       |
| a_title   | 文章题目     |
| a_cid   | 文章分类id     |
| a_date    | 文章发布日期 |
| a_date    | 文章最后修改日期 |
| a_context | 文章内容     |
| a_view    | 文章浏览次数 |
| a_del     | 删除标志     |

### class_info 表

| 栏位              | 说明           |
| ----------------- | -------------- |
| class_id          | 分类id         |
| class_name        | 分类名字       |
| class_del         | 删除标志       |

### remark_info 表

| 栏位           | 说明       |
| -------------- | ---------- |
| remark_id      | 评论id     |
| remark_aid  | 评论文章id |
| remark_name  | 评论者姓名  |
| remark_name  | 评论者邮箱  |
| remark_date  | 评论日期  |
| remark_context | 评论内容   |
| remark_del   | 删除标志   |



## git团队开发指南


以下是内容


### 不建分支
1. 有两个文件夹


    ![1.png](https://i.loli.net/2020/07/10/cFYwLh5ijdRkg9K.png)

2. 在文件夹v1中克隆项目


    ![2.png](https://i.loli.net/2020/07/10/nDzN3UtvkPhoe28.png)

3. 在文件夹v2中克隆项目

    ![3.png](https://i.loli.net/2020/07/10/bKFdlVqZgNBC63t.png)


4. 修改v1中的README.md

    ![捕获.PNG](https://i.loli.net/2020/07/10/d7ZCmnkWIj6v5Gs.png)

    ↑添加了“git团队开发”标题↑


5. 上传v1中的README.md
    
    ![v1上传.PNG](https://i.loli.net/2020/07/10/2zADGfkPp5a6K9x.png)

6. 修改v2中的README.md
    
    ![修改v2.PNG](https://i.loli.net/2020/07/10/W6gaPnO1zf5V8DH.png)

    ↑添加了“以下是内容”↑

7. git pull
    
    ![pull.PNG](https://i.loli.net/2020/07/10/tduNjpGFK2CxQzg.png)


8. 合并


    ![合并.PNG](https://i.loli.net/2020/07/10/QvIZKnCheRkqDwM.png)

    ↓把不想要的删掉就好了↓


    ![已合并.PNG](https://i.loli.net/2020/07/10/UTKQ2YFtbrEeWwi.png)

9. 上传
    
    ![合并后上传.PNG](https://i.loli.net/2020/07/10/ACesYBfS287oj3T.png)



### 分支测试

1. 创建分支并切换分支


    ![Snipaste_2020-07-13_15-20-54.png](https://i.loli.net/2020/07/13/Grm4eUZkdHIq3c9.png)


    git branch -a 是查看所有分支
    
    git branch 分支名    是新建分支

    git checkout 分支名   是切换分支


2. 在新建的分支下修改内容

    ![Snipaste_2020-07-13_15-22-29.png](https://i.loli.net/2020/07/13/1d9HKvOnzw3T7VA.png)


3. git commit


    ![Snipaste_2020-07-13_15-23-26.png](https://i.loli.net/2020/07/13/9sB5qZNMolF2epS.png)

4. 在master分支下修改内容


    ![Snipaste_2020-07-13_15-24-43.png](https://i.loli.net/2020/07/13/ICos9dquTpMeZAb.png)


5. git commit 


    ![Snipaste_2020-07-13_15-28-51.png](https://i.loli.net/2020/07/13/Q7vRJVsM6uSAXFW.png)


    ![Snipaste_2020-07-13_15-29-08.png](https://i.loli.net/2020/07/13/WR2axczSgNnX6bU.png)


6. 合并分支，但是提示有冲突


    ![Snipaste_2020-07-13_15-29-22.png](https://i.loli.net/2020/07/13/dPazNvp3VbXYUeJ.png)


7. 查看哪里有冲突


    ![Snipaste_2020-07-13_15-29-32.png](https://i.loli.net/2020/07/13/HRzmt1jx68SkPiQ.png)


8. 解决冲突


    ![Snipaste_2020-07-13_15-29-57.png](https://i.loli.net/2020/07/13/e9b52f6DmTrtwvX.png)

    ![Snipaste_2020-07-13_15-30-25.png](https://i.loli.net/2020/07/13/chQEpVwI6LCrBFb.png)


9.  重新git commit


    ![Snipaste_2020-07-13_15-34-53.png](https://i.loli.net/2020/07/13/34xICc9hTLXR1zE.png)


10. 删除分支

    ![Snipaste_2020-07-13_15-36-07.png](https://i.loli.net/2020/07/13/jYtVqMCUZN9vOms.png)


11. 上传

