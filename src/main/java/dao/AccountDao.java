package dao;

import db.DBCPUtil;
import db.DBUtil;
import model.Account;
import model.Goddess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  File Name: AccountDao
 *  File Function Description
 *  <li></li>
 *  Version: V1.0
 * </p>
 *
 * @Author 23754
 *         <p>
 *         <li>Create Date：2024/11/25-13:28</li>
 *         <li>Revise Records</li>
 *         <li>-----------------------------------------------------------</li>
 *         <li>Revise Author: 23754 </li>
 *         <li>Revise Date: 2024/11/25-13:28</li>
 *         <li>Revise Content: </li>
 *         <li>-----------------------------------------------------------</li>
 *         </p>
 */
public class AccountDao {
	public void insert(Account account) throws Exception{
		Connection conn = DBUtil.getConnection();
		String sql = ""+
				"insert into account_info (account, amount) values (?,?);";
		PreparedStatement ptml = conn.prepareStatement(sql);

		ptml.setString(1,account.getAccount());
		ptml.setDouble(2,account.getAmount());
		ptml.execute();
	}

	public void update(Account account) throws Exception{
		Connection conn = DBUtil.getConnection();
		String sql = ""+
				"update account_info " +
				"set account=?, amount=? " +
				" where id =?";
		PreparedStatement ptml = conn.prepareStatement(sql);

		ptml.setString(1,account.getAccount());
		ptml.setDouble(2,account.getAmount());
		ptml.setInt(3,account.getId());

		ptml.execute();
	}

	public void delete(Account account) throws Exception{
		Connection conn = DBUtil.getConnection();
		String sql = ""+
				"delete from account_info " +
				" where id =?";
		PreparedStatement ptml = conn.prepareStatement(sql);
		ptml.setInt(1,account.getId());
		ptml.execute();
	}

	public List<Account> query(Account account) throws Exception{
		List<Account> result = new ArrayList<>();
		Connection conn = DBUtil.getConnection();
		StringBuilder sb = new StringBuilder();
		sb.append("select * from account_info ");
		sb.append(" where account like ? ");
		PreparedStatement ptml = conn.prepareStatement(sb.toString());
		ptml.setString(1,"%"+account.getAccount()+"%");
		ResultSet resultSet = ptml.executeQuery();
		Account a = null;
		while (resultSet.next()){
			a = new Account();
			a.setId(resultSet.getInt("id"));
			a.setAccount(resultSet.getString("account"));
			a.setAmount(resultSet.getDouble("amount"));
			result.add(a);
		}
		return result;
	}

	public Account get(Integer id) throws SQLException {
		Connection connection = DBUtil.getConnection();
		String sql = ""+
				" select * from account_info "+
				" where id=?";

		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1,id);
		ResultSet resultSet = preparedStatement.executeQuery();
		Account a = null;

		while (resultSet.next()){
			a = new Account();
			a.setId(resultSet.getInt("id"));
			a.setAccount(resultSet.getString("account"));
			a.setAmount(resultSet.getDouble("amount"));
		}
		return  a;
	}
	public Account getByDBCP(Integer id) throws SQLException {
		DBCPUtil dbcpUtil = new DBCPUtil();
		Connection connection = dbcpUtil.getConn();
		String sql = ""+
				" select * from account_info "+
				" where id=?";

		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1,id);
		ResultSet resultSet = preparedStatement.executeQuery();
		Account a = null;

		while (resultSet.next()){
			a = new Account();
			a.setId(resultSet.getInt("id"));
			a.setAccount(resultSet.getString("account"));
			a.setAmount(resultSet.getDouble("amount"));
		}
		return  a;
	}
}