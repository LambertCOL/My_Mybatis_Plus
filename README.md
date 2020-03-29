# My_Mybatis_Plus
demo环境是SpringBoot项目

### 项目结构图

![image-20200329094307626](img\结构图.png)

### 为演示mybatis-plus操作的前置工作

1. 数据库表及数据

   ```SQL
   SET FOREIGN_KEY_CHECKS=0;
   
   -- ----------------------------
   -- Table structure for user
   -- ----------------------------
   DROP TABLE IF EXISTS `user`;
   CREATE TABLE `user` (
     `id` bigint(20) NOT NULL COMMENT '主键ID',
     `name` varchar(30) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '姓名',
     `age` int(11) DEFAULT NULL COMMENT '年龄',
     `email` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '邮箱',
     PRIMARY KEY (`id`)
   ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
   
   -- ----------------------------
   -- Records of user
   -- ----------------------------
   INSERT INTO `user` VALUES ('1', 'Jone', '18', 'test1@baomidou.com');
   INSERT INTO `user` VALUES ('2', 'Jack', '20', 'test2@baomidou.com');
   INSERT INTO `user` VALUES ('3', 'Tom', '28', 'test3@baomidou.com');
   INSERT INTO `user` VALUES ('4', 'Sandy', '21', 'test4@baomidou.com');
   INSERT INTO `user` VALUES ('5', 'Billie', '24', 'test5@baomidou.com');
   
   ```

2. 实体类

   ```JAVA
   @Data	//导入Lombok依赖
   public class User {
       private Long id;
       private String name;
       private Integer age;
       private String email;
   }
   ```

3. mapper接口

   ```JAVA
   //继承BaseMapper，泛型带上需要mapper操作的实体类
   //接口中不用定义任何方法，Mybatis-plus会帮我们做的
   public interface UserMapper extends BaseMapper<User> {
   }
   ```

   

### 使用mybatis-plus的准备工作

1、安装mybatis-plus，如果是maven项目就导入其依赖：`x.x.x`是版本号

  SpringBoot项目：

```XML
<dependency>
    <groupId>com.baomidou</groupId>
    <artifactId>mybatis-plus-boot-starter</artifactId>
    <version>x.x.x</version>
</dependency>
```



2、进行mybatis-plus配置

SpringBoot项目：

```JAVA
@MapperScan("cn.lamb.my_mybatis_plus.mapper")//使用MapperScan注解扫描先前定义的mapper包
@SpringBootApplication
public class MybatisPlusApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisPlusApplication.class, args);
    }

}
```

