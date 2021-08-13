package com.platform.generator;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 代碼生成器
 * @author lin512100
 * @date 2021/6/8
 */
@SpringBootApplication
public class GeneratorApplication {

    public static void main(String[] args) {
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        gc.setOutputDir("D:\\project\\customer\\spring-platform-cloud\\spring-platform-all\\spring-platform-generator");
        gc.setFileOverride(true);
        gc.setActiveRecord(true);
        // XML 二级缓存
        gc.setEnableCache(false);
        // XML ResultMap
        gc.setBaseResultMap(true);
        // XML columnList
        gc.setBaseColumnList(false);
        gc.setAuthor("LiJieYao");

        // 自定义文件命名，注意 %s 会自动填充表实体属性！
        // gc.setMapperName("%sDao");
        // gc.setXmlName("%sDao");
        gc.setServiceName("%sService");
        // gc.setServiceImplName("%sServiceDiy");
        // gc.setControllerName("%sAction");
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.MYSQL);

        dsc.setDriverName("com.mysql.jdbc.Driver");
        dsc.setUsername("");
        dsc.setPassword("");
        dsc.setUrl("");
        mpg.setDataSource(dsc);

        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        // 全局大写命名 ORACLE 注意
        //strategy.setCapitalMode(true);
        // 此处可以修改为您的表前缀
        strategy.setTablePrefix(new String[]{});
        // 表名生成策略
        strategy.setNaming(NamingStrategy.underline_to_camel);
        // 需要生成的表
        strategy.setInclude(new String[]{"crop_ent"});
        // 排除生成的表
        // strategy.setExclude(new String[]{
        //     "adm_data_svc_park", "work_order",
        //     "adm_data_svc_park_advantage",
        //     "adm_data_svc_park_house",
        //     "adm_data_svc_park_image"});
        // 自定义实体父类
        strategy.setSuperEntityClass("com.baomidou.mybatisplus.extension.activerecord.Model");
        // strategy.setEntityBuilderModel(true);
        strategy.setEntityColumnConstant(true);
        strategy.setEntityLombokModel(true);
        strategy.setSuperMapperClass("com.baomidou.mybatisplus.core.mapper.BaseMapper");

        // 自定义实体，公共字段
        // strategy.setSuperEntityColumns(new String[] { "id" , "create_time" , "update_time"});

        // 自定义 mapper 父类
        // strategy.setSuperMapperClass("com.baomidou.demo.TestMapper");
        // 自定义 service 父类
        // strategy.setSuperServiceClass("com.baomidou.demo.TestService");
        // 自定义 service 实现类父类
        // strategy.setSuperServiceImplClass("com.baomidou.demo.TestServiceImpl");
        // 自定义 controller 父类
        // strategy.setSuperControllerClass("com.baomidou.demo.TestController");
        // 【实体】是否生成字段常量（默认 false）
        // public static final String ID = "test_id";
        // strategy.setEntityColumnConstant(true);
        // 【实体】是否为构建者模型（默认 false）
        // public User setName(String name) {this.name = name; return this;}
        strategy.setEntityBuilderModel(true);
        mpg.setStrategy(strategy);

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent("com.platform.generator");
        //pc.setModuleName("ico.funding");
        pc.setMapper("mapper");
        pc.setEntity("entity");
        pc.setXml("mapper.impl");
        pc.setController("controller");
        pc.setService("service");
        pc.setServiceImpl("service.impl");
        mpg.setPackageInfo(pc);
        // 执行生成
        mpg.execute();
    }
}
