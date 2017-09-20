package springcore.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.sql.DriverManager;

@Configuration
public class DatabaseConfig {

    @Bean
    public JdbcTemplate getJdbcTemplate(DriverManagerDataSource dataSource){
        JdbcTemplate template = new JdbcTemplate();
        template.setDataSource(dataSource);
        return template;
    }

    @Bean
    public DriverManagerDataSource getDataSource(){
        DriverManagerDataSource dataSource =
                new DriverManagerDataSource("jdbc:postgresql://localhost:5432/springcore");
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUsername("postgres");
        dataSource.setPassword("root");
        return dataSource;
    }
}
