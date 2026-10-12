package EmployeeManagement;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;


public class EmployeeConntion {
    private static final String url="jdbc:mysql://localhost:3306/ampcode";
    private static final String user="root";
    private static final String password="root";
    private static final String driver="com.mysql.cj.jdbc.Driver";

    //connection
    private static final HikariDataSource Ds;
    static {
        try {
            HikariConfig config = new HikariConfig();
            config.setDriverClassName(driver);
            config.setJdbcUrl(url);
            config.setUsername(user);
            config.setPassword(password);
            config.setMaximumPoolSize(5);
            Ds = new HikariDataSource(config);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } /// try-catch end
    }/// static end
    public static HikariDataSource getDs()throws Exception {
        return Ds;
    }
}