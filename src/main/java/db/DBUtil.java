package db;

import java.sql.*;

/**
 * <p>
 *  File Name: db.DBUtil
 *  File Function Description
 *  <li></li>
 *  Version: V1.0
 * </p>
 *
 * @Author 23754
 *         <p>
 *         <li>Create Date：2024/11/18-10:30</li>
 *         <li>Revise Records</li>
 *         <li>-----------------------------------------------------------</li>
 *         <li>Revise Author: 23754 </li>
 *         <li>Revise Date: 2024/11/18-10:30</li>
 *         <li>Revise Content: </li>
 *         <li>-----------------------------------------------------------</li>
 *         </p>
 */
public class DBUtil {
	private static final String URL = "jdbc:mysql://127.0.0.1:3306/imooc";
	private static final String USER = "root";
	private static final String PASSWORD = "root";

	private static Connection connection;

	static {
		//加载驱动
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USER, PASSWORD);
		}
		catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}  catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}
	public static Connection getConnection(){
		return connection;
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		//加载驱动
		Class.forName("com.mysql.jdbc.Driver");
		//获得数据库连接
		Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery("select user_name,age from imooc_goddess");
		while (resultSet.next()){
			System.out.println(resultSet.getString("user_name")+"," +resultSet.getInt("age"));
		}
	}
}