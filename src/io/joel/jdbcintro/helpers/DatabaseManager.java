package io.joel.jdbcintro.helpers;

import io.joel.jdbcintro.model.Stat;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseManager {

    Statement statement;

    public DatabaseManager(Connection connection) throws SQLException {
        this.statement = connection.createStatement();
    }

    public Statement getStatement() {
        return statement;
    }

    public void CreateStatsTable() throws SQLException {
        statement.executeUpdate("CREATE TABLE stats (id INTEGER PRIMARY KEY, name STRING, wins INTEGER, losses INTEGER)");
    }

    public void DropStatsTable() throws SQLException {
        statement.executeUpdate("DROP TABLE IF EXISTS stats");
    }

    public ResultSet findAll(String table) throws SQLException {
        String formattedSql = String.format("SELECT * FROM %s", table);
        ResultSet rs = statement.executeQuery(formattedSql);
        return rs;
    }
}
