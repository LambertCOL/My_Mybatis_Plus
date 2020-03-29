# My_Mybatis_Plus
Mybatis-plus练习

使用mybatis-plus的准备工作
1、安装mybatis-plus，如果是maven项目就导入其依赖：x.x.x是版本号

  SpringBoot项目：
  <dependency>
    <groupId>com.baomidou</groupId>
    <artifactId>mybatis-plus-boot-starter</artifactId>
    <version>x.x.x</version>
  </dependency>
  
  SpringMVC项目：
  <dependency>
    <groupId>com.baomidou</groupId>
    <artifactId>mybatis-plus</artifactId>
    <version>3.3.1.tmp</version>
  </dependency>
  
2、进行mybatis-plus配置
  @SpringBootApplication
  @MapperScan("cn.lamb.my_mybatis_plus.mapper")
  public class MybatisPlusApplication {

      public static void main(String[] args) {
          SpringApplication.run(MybatisPlusApplication.class, args);
      }

  }
