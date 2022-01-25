package co.za.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;

@Configuration
public class DatasourceConfig {

//    @Bean
//    @ConfigurationProperties(prefix = "datasource")
//    public DataSource dataSource(Environment environment){
//        return DataSourceBuilder.create().build();
//    }
}
