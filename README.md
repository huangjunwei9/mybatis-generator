![输入图片说明](https://images.gitee.com/uploads/images/2019/0601/234241_ce48cb71_928367.png "code-generator.png")

# spring-boot-code-generator

![输入图片说明](https://img.shields.io/badge/version-1.0-green.svg "在这里输入图片标题")


#### 背景
由于每次开发后台管理模块的时候，发现都是做的事情都是一样的，做的逻辑都是一样的，只是业务不一样而已，并且在创建文件很浪费的时间，所以决定自己写一个模板代码生成器，方便项目开发，节省更多的时间写逻辑，减少bug的发生和规范的代码编写及结构

#### 介绍
spring-boot-code-generator 是springboot+mybaits+jdbc+mysql的搭建的项目,可以根据表结构自动创建 entity,dao,service,serviceImpl,mapper,controller 6个文件，并且封装了增删改查和分页接口，根据数据库表一键生成代码，节省80%的工作量

#### 环境配置
1.首先到[ spring-boot-code-generator](https://github.com/huangjunwei9/mybatis-generator)下载项目
![输入图片说明](https://images.gitee.com/uploads/images/2019/0619/101143_46045bac_928367.png "下载项目.png")

2.下载成功之后，解压到指定的位置

3.使用（idea,eclipse）开发者工具导入maven项目（这里使用eclipse说明）
![输入图片说明](https://images.gitee.com/uploads/images/2019/0619/102347_5144c98a_928367.png "导入maven工程.png")

4.配置mysql数据库
![输入图片说明](https://images.gitee.com/uploads/images/2019/0619/104341_bc60bcf7_928367.jpeg "配置数据库.jpg")

5.配置全局环境
![输入图片说明](https://images.gitee.com/uploads/images/2019/0619/104523_b950b0f8_928367.png "配置全局环境.png")

6.运行测试用例
![输入图片说明](https://images.gitee.com/uploads/images/2019/0619/112843_b65be11d_928367.png "运行测试用例.png")

7.查看日志是否运行成功
![输入图片说明](https://images.gitee.com/uploads/images/2019/0619/113043_c9b95d39_928367.png "查看日志.png")

8.查看文件是否生成
![输入图片说明](https://images.gitee.com/uploads/images/2019/0619/113812_61b53fd6_928367.png "查看文件.png")



    


