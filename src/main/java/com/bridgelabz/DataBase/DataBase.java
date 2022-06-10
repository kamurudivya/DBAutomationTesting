package com.bridgelabz.DataBase;

public class DataBase {
    //MYSQL Connection
    public static final String dbUrl = "jdbc:mysql://localhost:3306/upload";
    public static final String userName = "root";
    public static final String password = "Sanvir08$$";

    //Queries
    public static String insertQuery = "INSERT INTO discount1(id, title, expire_date, amount) value (?, ?, ?, ?)";
    public static String fetchQuery = "SELECT * FROM discount1";
    public static String updateQuery = "UPDATE discount1 SET title=?, expire_date=?, amount=? WHERE id=?";
    public static String deleteQuery = "DELETE FROM discount1 WHERE id=?";
}
