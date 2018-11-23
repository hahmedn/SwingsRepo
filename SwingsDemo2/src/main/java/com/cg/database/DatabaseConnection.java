package com.cg.database;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnection {

	public static Connection getConnection() {

		String driver="";
		String url="";
		String username="";
		String password="";

		Connection connection = null;

		try {

			FileInputStream fin= new FileInputStream("src/main/resources/database.properties");
			Properties prop= new Properties();
			prop.load(fin);

			driver=prop.getProperty("driver");
			url=prop.getProperty("url");
			username=prop.getProperty("username");
			password=prop.getProperty("password");

			Class.forName(driver);
			connection=DriverManager.getConnection(url,username,password);
			System.out.println("connected with DB");
		} catch (ClassNotFoundException e) {
			System.out.println("driver class needed");
		} catch (SQLException e) {
			System.out.println("Unable to connect with DB ");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return connection;
	}

	public static void main(String[] args) {
		getConnection();
	}
}
