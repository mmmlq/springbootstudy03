package com.lq.springboot;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MpGenerator {
	
	public static void main(String[] args) {
		
		//文件夹名称
		String packageName = "com.lq.springboot.tool";
		//输出目录
		String outDir="E://test1";
        
        generateByTables(packageName, outDir,"tbl_user");
		
//		generateTable("TT_EQ_PART");
		
	}
	
	private static void generateTable(String... tableNames) {
		AutoGenerator mpg =new AutoGenerator();
		mpg.setTemplateEngine(new FreemarkerTemplateEngine());
		
		GlobalConfig gc = new GlobalConfig();
		gc.setOutputDir("D://test//");
        gc.setFileOverride(true);
        gc.setActiveRecord(true);// 不需要ActiveRecord特性的请改为false
        gc.setEnableCache(false);// XML 二级缓存
        gc.setBaseResultMap(true);// XML ResultMap
        gc.setBaseColumnList(true);// XML columList
        gc.setAuthor("luoqi");
        
        // 自定义文件命名，注意 %s 会自动填充表实体属性！
         gc.setMapperName("I%sDao");
         gc.setXmlName("%sDao");
         gc.setServiceName("I%sService");
         gc.setServiceImplName("%sServiceImpl");
        // gc.setControllerName("%sAction");
        mpg.setGlobalConfig(gc);
        
        
     // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.MYSQL);
        dsc.setTypeConvert(new MySqlTypeConvert(){
            // 自定义数据库表字段类型转换【可选】
            @Override
            public DbColumnType processTypeConvert(String fieldType) {
                System.out.println("转换类型：" + fieldType);
        // 注意！！processTypeConvert 存在默认类型转换，如果不是你要的效果请自定义返回、非如下直接返回。
                return super.processTypeConvert(fieldType);
            }
        });
        
        dsc.setDriverName("com.mysql.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("root");
        dsc.setUrl("jdbc:mysql://localhost:3306/springboot?useUnicode=true&characterEncoding=utf-8&useSSL=false");
        mpg.setDataSource(dsc);
        
     // 策略配置
        StrategyConfig strategy = new StrategyConfig();
     strategy.setCapitalMode(true);// 全局大写命名 ORACLE 注意
        strategy.setTablePrefix(new String[] { "tbl"});// 此处可以修改为您的表前缀
        strategy.setNaming(NamingStrategy.underline_to_camel);// 表名生成策略
         strategy.setInclude(tableNames); // 需要生成的表
//         strategy.setExclude(new String[]{"test"}); // 排除生成的表
        // 自定义实体父类
        // strategy.setSuperEntityClass("com.baomidou.demo.TestEntity");
        // 自定义实体，公共字段
        // strategy.setSuperEntityColumns(new String[] { "test_id", "age" });
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
        // strategy.setEntityBuilderModel(true);
        mpg.setStrategy(strategy);
        
        
     // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent("com.lq.sprigboot");
        pc.setModuleName("system");
        mpg.setPackageInfo(pc);
        
        // 注入自定义配置，可以在 VM 中使用 cfg.abc 【可无】
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("abc", this.getConfig().getGlobalConfig().getAuthor() + "-mp");
                this.setMap(map);
            }
        };
        
        List<FileOutConfig> focList = new ArrayList<FileOutConfig>();
        // 调整 xml 生成目录演示
        focList.add(new FileOutConfig("/templates/mapper.xml.vm") {
           @Override
           public String outputFile(TableInfo tableInfo) {
               return "/develop/code/xml/" + tableInfo.getEntityName() + ".xml";
           }
       });
       cfg.setFileOutConfigList(focList);
       mpg.setCfg(cfg);
       
       TemplateConfig tc = new TemplateConfig();
       tc.setXml(null);
       mpg.setTemplate(tc);
       
       // 执行生成
       mpg.execute();

				
	}
	
	
	private static void generateByTables( String packageName,String outDir, String... tableNames) {
	        GlobalConfig config = new GlobalConfig();
	        String dbUrl = "jdbc:mysql://localhost:3306/springboot?useUnicode=true&characterEncoding=utf-8&useSSL=false";
	        DataSourceConfig dataSourceConfig = new DataSourceConfig();
	        dataSourceConfig.setDbType(DbType.MYSQL)
	                .setUrl(dbUrl)
	                .setUsername("root")
	                .setPassword("root")
	                .setDriverName("com.mysql.jdbc.Driver");
	        StrategyConfig strategyConfig = new StrategyConfig();
	        strategyConfig
	                .setCapitalMode(true)
	                .setEntityLombokModel(false)
	                .setDbColumnUnderline(true)
	                .setNaming(NamingStrategy.underline_to_camel)
	                .entityTableFieldAnnotationEnable(true)
	                .setTablePrefix(new String[] { "tbl"})//表前缀
	                .setInclude(tableNames);//修改替换成你需要的表名，多个表名传数组
	        
	        
	        config.setActiveRecord(true)
			        .setFileOverride(true)
			        .setActiveRecord(true)// 不需要ActiveRecord特性的请改为false
			        .setEnableCache(false)// XML 二级缓存
			        .setBaseResultMap(true)// XML ResultMap
			        .setBaseColumnList(true)// XML columList
	                .setAuthor("luoqi")
	                .setOutputDir(outDir)
	                .setFileOverride(true)
	                
	                .setMapperName("%sDao")
	                .setXmlName("%sDao")
	                .setServiceName("I%sService")
	                .setServiceImplName("%sServiceImpl")
                    .setControllerName("%sAction");
	                
//	                .setServiceImplName("%sServiceImpl")
//	                .setMapperName("%sDao")
//	                .setControllerName("%sAction");
	       
	        new AutoGenerator().setGlobalConfig(config)
	                .setDataSource(dataSourceConfig)
	                .setStrategy(strategyConfig)
	                .setPackageInfo(
	                        new PackageConfig()
	                                .setParent(packageName)
	                                .setController("action")
	                                .setEntity("model")
	                                .setService("service")
	                                .setMapper("dao")
	                ).execute();
	    }
/*
	    private void generateByTables(String packageName, String... tableNames) {
	        generateByTables(true, packageName, tableNames);
	    }
*/
}
