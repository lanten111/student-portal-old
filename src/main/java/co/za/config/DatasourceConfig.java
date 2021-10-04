package co.za.config;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;

@Configuration
public class DatasourceConfig {
//
//    @Bean
//    public DataSource dataSource(Environment environment){
//        DataSourceBuilder<?> dataSourceBuilder = DataSourceBuilder.create();
//        dataSourceBuilder.password("postgres")
//                .username("postgres")
//                .url("jdbc:postgresql://localhost:5432/studentdb")
//                .driverClassName("org.postgresql.Driver");
//        return dataSourceBuilder.build();
//    }
}
