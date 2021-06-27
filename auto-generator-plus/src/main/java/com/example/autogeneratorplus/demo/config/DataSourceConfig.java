package com.example.autogeneratorplus.demo.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:db-demo.properties")
@MapperScan(basePackages = {"com.example.autogeneratorplus.demo.mapper"},
        sqlSessionTemplateRef = "demoSqlSessionTemplate")
public class DataSourceConfig {
    private final static String ENTITY_PACKAGE = "com.example.autogeneratorplus.demo.entity";
    private final static String XML_PATH = "classpath*:com/example/autogeneratorplus/demo/mapper/xml/*.xml";
    private final static String TYPE_ENUMS_PACKAGE = "com.example.autogeneratorplus.demo.**";

    @Bean(name = "demoDataSource")
    @ConfigurationProperties(prefix = "druid.datasource")
    public DataSource druidDataSource() {
        DruidDataSource druidDataSource = new DruidDataSource();
        return druidDataSource;
    }

    @Bean(name = "demoSqlSessionFactory")
    public SqlSessionFactory demoSqlSessionFactory(@Qualifier("demoDataSource") DataSource dataSource)
            throws Exception {
        MybatisSqlSessionFactoryBean bean = new MybatisSqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setTypeAliasesPackage(ENTITY_PACKAGE);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(XML_PATH));
        bean.setTypeEnumsPackage(TYPE_ENUMS_PACKAGE);
        //mybatis-plus分页插件
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));
        bean.setPlugins(interceptor);
//        bean.setGlobalConfig(globalConfig);
        return bean.getObject();
    }

    @Bean(name = "demoSqlSessionTemplate")
    public SqlSessionTemplate sqlSessionTemplate(
            @Qualifier("demoSqlSessionFactory") SqlSessionFactory sqlSessionFactory){
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}
