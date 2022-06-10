package com.bridgelabz.DBTesting;
import com.bridgelabz.DataBase.DataBase;
import java.sql.*;

public class DBATesting {
    static Connection connection;
    PreparedStatement ps;


    public void create() throws SQLException {
        System.out.println("----------Insert data---------");
        ps = connection.prepareStatement(DataBase.insertQuery);
        ps.setInt(1, 7);
        ps.setString(2, "Attitude");
        ps.setString(3, "2023-05-06");
        ps.setString(4, String.valueOf(240.00));
        ps.executeUpdate();
        System.out.println("Data inserted successfully...");
    }
    public void read() throws SQLException {
        System.out.println("----------Fetch data from database---------");
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(DataBase.fetchQuery);
        while (rs.next()) {
            int id = rs.getInt(1);
            String title = rs.getString(2);
            String expire_date = rs.getString(3);
            int amount = rs.getInt(4);
            System.out.println(id + " " + title + " " + expire_date + " " + amount + " ");
        }
    }

    public void update() throws SQLException {
        System.out.println("----------Update data---------");
        ps = connection.prepareStatement(DataBase.updateQuery);
        ps.setString(1, "7");
        ps.setString(2, "Attitude");
        ps.setString(3, "2023-05-06");
        ps.setString(4, String.valueOf(240.00));
        ps.executeUpdate();
        System.out.println("Person data updated successfully.");
    }

    public void delete() throws SQLException {
        System.out.println("----------Delete data---------");
        ps = connection.prepareStatement(DataBase.deleteQuery);
        ps.setInt(1, 106);
        ps.executeUpdate();
        System.out.println("Person data deleted successfully.");
    }

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("JDBC Driver is found");
        } catch (ClassNotFoundException e) {
            System.out.println("JDBC Driver class is not found");
            e.printStackTrace();
        }
        try {
            connection = DriverManager.getConnection(DataBase.dbUrl, DataBase.userName, DataBase.password);
            System.out.println("Connection is established.");

            DBATesting dbaTesting = new DBATesting();
            dbaTesting.delete();
            dbaTesting.read();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Connection can not established.");
        }
    }
}
