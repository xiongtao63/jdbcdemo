package dao;

import db.DBUtil;
import model.Goddess;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  File Name: ProduceDao
 *  File Function Description
 *  <li></li>
 *  Version: V1.0
 * </p>
 *
 * @Author 23754
 *         <p>
 *         <li>Create Date：2024/11/20-16:42</li>
 *         <li>Revise Records</li>
 *         <li>-----------------------------------------------------------</li>
 *         <li>Revise Author: 23754 </li>
 *         <li>Revise Date: 2024/11/20-16:42</li>
 *         <li>Revise Content: </li>
 *         <li>-----------------------------------------------------------</li>
 *         </p>
 */
public class ProduceDao {
	public static Integer select_count() throws SQLException {

		//1 获得连接
		Connection connection = DBUtil.getConnection();
		//获得callableStatement
		CallableStatement callableStatement = connection.prepareCall("call sp_select_count(?)");
		callableStatement.registerOutParameter(1, Types.INTEGER);
		//执行存储过程
		callableStatement.execute();
		//处理返回  结果集，出参
		Integer count = callableStatement.getInt(1);

		return count;
	}
	public static List<Goddess> select_filter(String sp_name) throws SQLException {
		List<Goddess> result = new ArrayList<>();
		//1 获得连接
		Connection connection = DBUtil.getConnection();
		//获得callableStatement
		CallableStatement callableStatement = connection.prepareCall("call sp_select_filter(?)");
		callableStatement.setString(1,sp_name);
		//执行存储过程
		callableStatement.execute();
		//处理返回  结果集，出参
		ResultSet resultSet = callableStatement.getResultSet();

		Goddess goddess = null;
		while (resultSet.next()){
			goddess = new Goddess();
			goddess.setId(resultSet.getInt("id"));
			goddess.setUser_name(resultSet.getString("user_name"));
			goddess.setSex(resultSet.getInt("sex"));
			goddess.setAge(resultSet.getInt("age"));
			result.add(goddess);
		}
		return result;
	}
	public static void select_nofilter() throws SQLException {
		//1 获得连接
		Connection connection = DBUtil.getConnection();
		//获得callableStatement
		CallableStatement callableStatement = connection.prepareCall("call sp_select_nofilter()");

		//执行存储过程
		callableStatement.execute();
		//处理返回  结果集，出参
		ResultSet resultSet = callableStatement.getResultSet();
		while (resultSet.next()){
			System.out.println(resultSet.getString("user_name"));
		}
	}
}