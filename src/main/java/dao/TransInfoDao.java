package dao;

import db.DBUtil;
import model.Account;
import model.TransInfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  File Name: TransInfoDao
 *  File Function Description
 *  <li></li>
 *  Version: V1.0
 * </p>
 *
 * @Author 23754
 *         <p>
 *         <li>Create Date：2024/11/25-13:39</li>
 *         <li>Revise Records</li>
 *         <li>-----------------------------------------------------------</li>
 *         <li>Revise Author: 23754 </li>
 *         <li>Revise Date: 2024/11/25-13:39</li>
 *         <li>Revise Content: </li>
 *         <li>-----------------------------------------------------------</li>
 *         </p>
 */
public class TransInfoDao {
	public void insert(TransInfo transInfo) throws Exception{
		Connection conn = DBUtil.getConnection();
		String sql = ""+
				"insert into trans_info (source_id," +
				" source_account,destination_id,destination_account,amount)" +
				" values (?,?,?,?,?);";
		PreparedStatement ptml = conn.prepareStatement(sql);

		ptml.setInt(1,transInfo.getSourceId());
		ptml.setString(2,transInfo.getSourceAccount());
		ptml.setInt(3,transInfo.getDestinationId());
		ptml.setString(4,transInfo.getDestinationAccount());
		ptml.setDouble(5,transInfo.getAmount());
		ptml.execute();
	}

	public void update(TransInfo transInfo) throws Exception{
		Connection conn = DBUtil.getConnection();
		String sql = ""+
				"update trans_info " +
				"set source_id=?, source_account=?, " +
				"destination_id=?, destination_account=?, " +
				"amount=?" +
				" where id =?";
		PreparedStatement ptml = conn.prepareStatement(sql);

		ptml.setInt(1,transInfo.getSourceId());
		ptml.setString(2,transInfo.getSourceAccount());
		ptml.setInt(3,transInfo.getDestinationId());
		ptml.setString(4,transInfo.getDestinationAccount());
		ptml.setDouble(5,transInfo.getAmount());
		ptml.setInt(6,transInfo.getId());

		ptml.execute();
	}

	public void delete(TransInfo transInfo) throws Exception{
		Connection conn = DBUtil.getConnection();
		String sql = ""+
				"delete from trans_info " +
				" where id =?";
		PreparedStatement ptml = conn.prepareStatement(sql);
		ptml.setInt(1,transInfo.getId());
		ptml.execute();
	}

	public List<TransInfo> query(TransInfo transInfo) throws Exception{
		List<TransInfo> result = new ArrayList<>();
		Connection conn = DBUtil.getConnection();
		StringBuilder sb = new StringBuilder();
		sb.append("select * from trans_info ");
		sb.append(" where source_account like ? ");
		PreparedStatement ptml = conn.prepareStatement(sb.toString());
		ptml.setString(1,"%"+transInfo.getSourceAccount()+"%");
		ResultSet resultSet = ptml.executeQuery();
		TransInfo a = null;
		while (resultSet.next()){
			a = new TransInfo();
			a.setId(resultSet.getInt("id"));
			a.setSourceId(resultSet.getInt("source_id"));
			a.setSourceAccount(resultSet.getString("source_account"));
			a.setDestinationId(resultSet.getInt("destination_id"));
			a.setDestinationAccount(resultSet.getString("destination_account"));
			a.setAmount(resultSet.getDouble("amount"));
			result.add(a);
		}
		return result;
	}
}