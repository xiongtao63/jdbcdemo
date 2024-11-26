package test;

import db.C3P0Util;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * <p>
 *  File Name: TestC3P0
 *  File Function Description
 *  <li></li>
 *  Version: V1.0
 * </p>
 *
 * @Author 23754
 *         <p>
 *         <li>Create Date：2024/11/25-16:21</li>
 *         <li>Revise Records</li>
 *         <li>-----------------------------------------------------------</li>
 *         <li>Revise Author: 23754 </li>
 *         <li>Revise Date: 2024/11/25-16:21</li>
 *         <li>Revise Content: </li>
 *         <li>-----------------------------------------------------------</li>
 *         </p>
 */
public class TestC3P0 {
	public static void main(String[] args) throws SQLException {
		Connection conn = C3P0Util.getConnection();
		System.out.println(conn.getCatalog());
	}
}