package com.sample.controlfilegenerator;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import java.io.IOException;
import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import sun.misc.BASE64Decoder;

@Configuration
public class SpringConfiguration {

    @Bean
    public AppDAO appDAO() {
        AppDAO appDAO = new AppDAO(devJdbcTemplate(), uatJdbcTemplate(), prodJdbcTemplate());

        return appDAO;
    }

    @Bean
    public JdbcTemplate devJdbcTemplate() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(devDataSource());
        return jdbcTemplate;
    }

    @Bean
    public JdbcTemplate uatJdbcTemplate() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(uatDataSource());
        return jdbcTemplate;
    }

    @Bean
    public JdbcTemplate prodJdbcTemplate() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(prodDataSource());
        return jdbcTemplate;
    }

    @Bean
    public DataSource devDataSource() {
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setDriverClassName("oracle.jdbc.driver.OracleDriver");
        hikariConfig.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:XE");
        hikariConfig.setUsername("root");
        hikariConfig.setPassword(decode("YWJjMTIz"));
        hikariConfig.setMaximumPoolSize(5);
        HikariDataSource dataSource = new HikariDataSource(hikariConfig);

        return dataSource;
    }

    @Bean
    public DataSource uatDataSource() {
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setDriverClassName("oracle.jdbc.pool.OracleDataSource");
        hikariConfig.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:XE");
        hikariConfig.setUsername("root");
        hikariConfig.setPassword(decode("admin"));
        hikariConfig.setMaximumPoolSize(5);
        HikariDataSource dataSource = new HikariDataSource(hikariConfig);

        return dataSource;
    }

    @Bean
    public DataSource prodDataSource() {
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setDriverClassName("oracle.jdbc.pool.OracleDataSource");
        hikariConfig.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:XE");
        hikariConfig.setUsername("root");
        hikariConfig.setPassword(decode("admin"));
        hikariConfig.setMaximumPoolSize(5);
        HikariDataSource dataSource = new HikariDataSource(hikariConfig);

        return dataSource;
    }

    private String decode(String password) {
        BASE64Decoder decoder = new BASE64Decoder();
        String decodedPassword = null;
        try {
            decodedPassword = new String(decoder.decodeBuffer(password));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return decodedPassword;
    }

}
