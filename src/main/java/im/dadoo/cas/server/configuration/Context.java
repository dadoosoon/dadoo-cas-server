/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package im.dadoo.cas.server.configuration;

import com.alibaba.druid.pool.DruidDataSource;
import javax.annotation.Resource;
import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 *
 * @author codekitten
 */
@Configuration
@EnableWebMvc
//@EnableAspectJAutoProxy
//@PropertySource("classpath:config.properties")
@ComponentScan("im.dadoo.cas")
public class Context extends WebMvcConfigurerAdapter {
  
  @Resource
  private Environment env;
  
//  @Bean(initMethod = "init", destroyMethod = "close")
//  public DataSource dataSource() {
//    DruidDataSource dataSource = new DruidDataSource();
//    dataSource.setUrl(env.getProperty("jdbc.url"));
//    dataSource.setUsername(env.getProperty("jdbc.username"));
//    dataSource.setPassword(env.getProperty("jdbc.password"));
//    return dataSource;
//  }
  
//  @Bean
//  public NamedParameterJdbcTemplate jdbcTemplate() {
//    NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(this.dataSource());
//    return jdbcTemplate;
//  }
  
  @Bean
  public InternalResourceViewResolver viewResolver() {
    InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
    viewResolver.setPrefix("/WEB-INF/views/");
    viewResolver.setSuffix(".jsp");
    return viewResolver;
  }
  
}
