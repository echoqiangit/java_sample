package com.sample.controlfilegenerator;

import org.springframework.jdbc.core.JdbcTemplate;

public class AppDAO {

    private JdbcTemplate devJdbcTemplate;
    private JdbcTemplate uatJdbcTemplate;
    private JdbcTemplate prodJdbcTemplate;

    public Object find(String memberId, String env) {
        //this is a sample to use jdbcTemplate
        /*
        return getJdbcTemplate(env).queryForObject(
            "select id,owner_name,balance,access_time,locked from account where member_id = ?",
                new RowMapper<Account>() {
                    @Override
                    public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Account account = new Account();
                        account.setId(rs.getLong("id"));
                        account.setOwnerName(rs.getString("owner_name"));
                        account.setBalance(rs.getDouble("balance"));
                        account.setAccessTime(rs.getTimestamp("access_time"));
                        account.setLocked(rs.getBoolean("locked"));
                        return account;
                    }
                }, memberId);
        */
        return null;      
    }

    JdbcTemplate getJdbcTemplate(String env) {
        JdbcTemplate t = null;
        if (env.equalsIgnoreCase("PROD")) {
            t = prodJdbcTemplate;
        } else if (env.equalsIgnoreCase("UAT")) {
            t = uatJdbcTemplate;
        } else if (env.equalsIgnoreCase("DEV")) {
            t = devJdbcTemplate;

        } else {
            throw new RuntimeException("Environment [" + env + "] is not supported.");
        }
        return t;
    }

    public AppDAO(JdbcTemplate devJdbcTemplate, JdbcTemplate uatJdbcTemplate, JdbcTemplate prodJdbcTemplate) {
        this.devJdbcTemplate = devJdbcTemplate;
        this.uatJdbcTemplate = uatJdbcTemplate;
        this.prodJdbcTemplate = prodJdbcTemplate;
    }

}
