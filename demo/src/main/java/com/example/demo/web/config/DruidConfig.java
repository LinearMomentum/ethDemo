package com.example.demo.web.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DruidConfig {
    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druid(){
        return new DruidDataSource();
    }
    public ServletRegistrationBean statViewServlet(){
       ServletRegistrationBean servletRegistrationBean= new ServletRegistrationBean(new StatViewServlet(),"/druid/*");
       Map<String,String> ini=new HashMap<>();
       ini.put("loginUsername","postgres");
       ini.put("loginPassword","123123");
       ini.put("allow","localhost");
       servletRegistrationBean.setInitParameters(ini);
       return servletRegistrationBean;
    }
    @Bean
    public FilterRegistrationBean webStatFilter(){
        FilterRegistrationBean bean=new FilterRegistrationBean();
        bean.setFilter(new WebStatFilter());
        Map<String,String> ini=new HashMap<>();
        ini.put("exclusions","*.js,*.css,/druid/*");
        bean.setInitParameters(ini);
        bean.setUrlPatterns(Arrays.asList("/*"));
        return bean;
    }
}
