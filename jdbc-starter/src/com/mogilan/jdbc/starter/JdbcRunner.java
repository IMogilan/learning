package com.mogilan.jdbc.starter;

import org.postgresql.Driver;
import util.ConnectionManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcRunner {
    public static void main(String[] args) throws SQLException {
        Class<Driver> driverClass = Driver.class;
        String sql = """
                UPDATE info
                SET data = 'TestTest'
                WHERE id = 5
                RETURNING *;              
                """;
        try (var connection = ConnectionManager.open();
             var statement = connection.createStatement()) {
            System.out.println(connection.getSchema());
            System.out.println(connection.getTransactionIsolation());
            var executeResult = statement.execute(sql);
            System.out.println(executeResult);
            System.out.println(statement.getUpdateCount());
        }


    }
}
