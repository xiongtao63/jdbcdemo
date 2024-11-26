package db;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * <p>
 *  File Name: C3P0Util
 *  File Function Description
 *  <li></li>
 *  Version: V1.0
 * </p>
 *
 * @Author 23754
 *         <p>
 *         <li>Create Date：2024/11/25-16:18</li>
 *         <li>Revise Records</li>
 *         <li>-----------------------------------------------------------</li>
 *         <li>Revise Author: 23754 </li>
 *         <li>Revise Date: 2024/11/25-16:18</li>
 *         <li>Revise Content: </li>
 *         <li>-----------------------------------------------------------</li>
 *         </p>
 */
public class C3P0Util {

	private static ComboPooledDataSource ds = new ComboPooledDataSource();

	public static Connection getConnection(){
		try {
			return ds.getConnection();
		}
		catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}