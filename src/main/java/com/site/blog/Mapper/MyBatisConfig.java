package com.site.blog.Mapper;

import com.alibaba.druid.pool.DruidDataSource;
import com.github.pagehelper.PageInterceptor;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import javax.sql.DataSource;
import javax.xml.crypto.Data;
import java.util.Properties;

@Configuration
@EnableTransactionManagement //支持事务
public class MyBatisConfig implements TransactionManagementConfigurer {

    /**
     *  解决sqlsession（数据源手动注入问题）的办法
     *  http://www.bubuko.com/infodetail-2525492.html
     *  两个方案配合结局
     *  https://www.cnblogs.com/web424/p/6757296.html
     *
     *
     *  另一种在xml中配置的方法
     *  https://www.jb51.net/article/139688.htm
     *  https://www.cnblogs.com/1315925303zxz/p/7364552.html
     *
     *
     *  分页实例
     *  https://www.cnblogs.com/yg_zhang/p/9797796.html
     *  https://blog.csdn.net/xiaolyuh123/article/details/73506189
     */



//    @Bean
//    public DataSource dataSource() {
//        return DataSourceBuilder.create()
//                .driverClassName("spring.datasource.driver-class-name")
//                .url("spring.datasource.url")
//                .username("spring.datasource.username")
//                .password("spring.datasource.password").build();
//    }
//    @Bean
//    @ConfigurationProperties(prefix = "spring.datasource.other")
//    public DataSource dataSource(){
//        return DataSourceBuilder.create().build();
//    }

    @Autowired
    private Environment env;
    @Bean
    public DataSource dataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(env.getProperty("spring.datasource.url"));
        dataSource.setUsername(env.getProperty("spring.datasource.username"));//用户名
        dataSource.setPassword(env.getProperty("spring.datasource.password"));//密码
        dataSource.setDriverClassName(env.getProperty("spring.datasource.driver-class-name"));
        dataSource.setInitialSize(2);//初始化时建立物理连接的个数
        dataSource.setMaxActive(20);//最大连接池数量
        dataSource.setMinIdle(0);//最小连接池数量
        dataSource.setMaxWait(60000);//获取连接时最大等待时间，单位毫秒。
        dataSource.setValidationQuery("SELECT 1");//用来检测连接是否有效的sql
        dataSource.setTestOnBorrow(false);//申请连接时执行validationQuery检测连接是否有效
        dataSource.setTestWhileIdle(true);//建议配置为true，不影响性能，并且保证安全性。
        dataSource.setPoolPreparedStatements(false);//是否缓存preparedStatement，也就是PSCache
        return dataSource;
    }

    @Autowired
    private DataSource dataSource;

    @Override
    public PlatformTransactionManager annotationDrivenTransactionManager() {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource){
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        /*
        自定义数据库配置的时候，需要讲PageHelper的bean注入到Plugins中，
        如果采用系统默认的数据库配置，则只需要定义pagehelper的bean，会自动注入
         */
        /**
         * 此处本来是用org.apache.ibatis.plugin.Interceptor;但是在pagehelper4.0.0之后就不支持这个接口
         * 转而支持com.github.pagehelper.PageInterceptor
         */
        //bean.setPlugins(new PageInterceptor[]{pageHelper()});
        //分页插件
        PageInterceptor pageInterceptor = new PageInterceptor();
        Properties properties = new Properties();
        properties.setProperty("helperDialect", "mysql");
        properties.setProperty("reasonable", "true");
        properties.setProperty("params", "pageNum=pageNum;pageSize=pageSize");
        pageInterceptor.setProperties(properties);

        //添加插件
        bean.setPlugins(new Interceptor[]{pageInterceptor});
        try {
            return bean.getObject();
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory){
        return new SqlSessionTemplate(sqlSessionFactory);
    }

//    @Bean
//    public PageHelper pageHelper(){
//        PageHelper pageHelper = new PageHelper();
//        Properties p = new Properties();
//        p.setProperty("offsetAsPageNum", "true");
//        p.setProperty("rowBoundsWithCount", "true");
//        p.setProperty("reasonable", "true");
//        p.setProperty("dialect", "mysql");
//        pageHelper.setProperties(p);
//        return pageHelper;
//    }

}
