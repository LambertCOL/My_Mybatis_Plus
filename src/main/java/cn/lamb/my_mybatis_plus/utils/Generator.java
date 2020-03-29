package cn.lamb.my_mybatis_plus.utils;

import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.apache.commons.lang3.StringUtils;

import java.util.Scanner;

/**
 * @Description 代码生成器
 * @Date 2020/3/29 10:27
 * @Creator Lambert
 */
public class Generator {

    /**
     * 读取控制台内容
     */
    public static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("请输入" + tip + "：");
        System.out.println(help.toString());
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotEmpty(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }

    /**
     * 运行main方法
     * 输入【模块名】如sys
     * 输入【表名】如user
     * 会在项目主路径下创建sys包
     * 包内是对应user表的controller、entity、mapper、service
     *
     * @param args
     */
    public static void main(String[] args) {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        //全局配置
        String projectPath = globalConfig(mpg);

        // 数据源配置
        dataSourceConfig(mpg);

        // 包配置
        PackageConfig pc = packageConfig(mpg);

        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };

        // 如果模板引擎是 velocity
        String templatePath = "/templates/mapper.xml.vm";

        /**
        // 如果模板引擎是 freemarker
        String templatePath = "/templates/mapper.xml.ftl";
        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        // 自定义配置会被优先输出
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return projectPath + "/src/main/resources/mapper/" + pc.getModuleName() + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });
        */
        /*
        cfg.setFileCreate(new IFileCreate() {
            @Override
            public boolean isCreate(ConfigBuilder configBuilder, FileType fileType, String filePath) {
                // 判断自定义文件夹是否需要创建
                checkDir("调用默认方法创建的目录");
                return false;
            }
        });
        */
        /*
        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);
        // 配置模板
        templateConfig(mpg);
        */

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        //strategy.setSuperEntityClass("你自己的父类实体,没有就不用设置!");
        strategy.setEntityLombokModel(true);
        strategy.setRestControllerStyle(true);
        // 公共父类
        //strategy.setSuperControllerClass("你自己的父类控制器,没有就不用设置!");
        // 写于父类中的公共字段
        strategy.setSuperEntityColumns("id");
        strategy.setInclude(scanner("表名，多个英文逗号分割").split(","));
        strategy.setControllerMappingHyphenStyle(true);
        strategy.setTablePrefix(pc.getModuleName() + "_");
        mpg.setStrategy(strategy);
        //设置模板
        //mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();
    }

    /**
     * 全局配置
     *
     * @param mpg
     */
    private static String globalConfig(AutoGenerator mpg) {
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        gc.setOutputDir(projectPath + "/src/main/java");
        gc.setAuthor("Lambert");
        gc.setOpen(false);
        // gc.setSwagger2(true); 实体属性 Swagger2 注解
        mpg.setGlobalConfig(gc);
        return projectPath;
    }

    /**
     * 数据源配置
     *
     * @param mpg
     */
    private static void dataSourceConfig(AutoGenerator mpg) {
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql:///my_mybatis_plus?useUnicode=true&useSSL=false&characterEncoding=utf8");
        // dsc.setSchemaName("public");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("123456");
        mpg.setDataSource(dsc);
    }

    /**
     * 包配置
     *
     * @param mpg
     */
    private static PackageConfig packageConfig(AutoGenerator mpg) {
        PackageConfig pc = new PackageConfig();
        pc.setModuleName(scanner("模块名"));
        pc.setParent("cn.lamb.my_mybatis_plus");
        mpg.setPackageInfo(pc);
        return pc;
    }

    /**
     * 配置模板
     *
     * @param mpg
     */
    private static void templateConfig(AutoGenerator mpg) {
        TemplateConfig templateConfig = new TemplateConfig();

        // 配置自定义输出模板
        //指定自定义模板路径，注意不要带上.ftl/.vm, 会根据使用的模板引擎自动识别
        // templateConfig.setEntity("templates/entity2.java");
        // templateConfig.setService();
        // templateConfig.setController();

        templateConfig.setXml(null);
        mpg.setTemplate(templateConfig);
    }


    private static GlobalConfig globalConfig;
    private static DataSourceConfig dataSourceConfig;

    public static void configureGlobalConfig() {
        globalConfig = new GlobalConfig();
        globalConfig.setOutputDir(System.getProperty("D:/_A") + "/src/main/java");
        globalConfig.setAuthor("Lambert");
        globalConfig.setOpen(false);
    }

    public static void configureDataSourceConfig() {
        dataSourceConfig.setUrl("jdbc:mysql:///my_mybatis_plus?useUnicode=true&useSSL=false&characterEncoding=utf8");
        dataSourceConfig.setDriverName("com.mysql.jdbc.Driver");
        dataSourceConfig.setUsername("root");
        dataSourceConfig.setPassword("123456");
    }
}
