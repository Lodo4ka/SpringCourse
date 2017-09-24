package springcore.dao.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;


@Configuration
@ComponentScan("springcore.dao")
public class DataBaseConfigTest {



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
