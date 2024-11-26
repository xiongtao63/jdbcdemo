package dao;

import db.DBUtil;
import model.Goddess;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  File Name: GoddessDao
 *  File Function Description
 *  <li></li>
 *  Version: V1.0
 * </p>
 *
 * @Author 23754
 *         <p>
 *         <li>Create Date：2024/11/18-11:08</li>
 *         <li>Revise Records</li>
 *         <li>-----------------------------------------------------------</li>
 *         <li>Revise Author: 23754 </li>
 *         <li>Revise Date: 2024/11/18-11:08</li>
 *         <li>Revise Content: </li>
 *         <li>-----------------------------------------------------------</li>
 *         </p>
 */
public class GoddessDao {
	public void addGoddess(Goddess g) throws SQLException {
		Connection connection = DBUtil.getConnection();
		String sql = ""+
				"insert into imooc_goddess"+
				"(user_name,sex,age,birthday,email,mobile,"+
				"create_user,create_date,update_user,update_date,isdel)"+
				"values(" +
				"?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1,g.getUser_name());
		preparedStatement.setInt(2,g.getSex());
		preparedStatement.setInt(3,g.getAge());
		preparedStatement.setDate(4,new Date(g.getBirthday().getTime()));
		preparedStatement.setString(5,g.getEmail());
		preparedStatement.setString(6,g.getMobile());
		preparedStatement.setString(7,g.getCreate_user());
		preparedStatement.setDate(8,new Date(g.getBirthday().getTime()));
		preparedStatement.setString(9,g.getUpdate_user());
		preparedStatement.setDate(10,new Date(g.getBirthday().getTime()));
		preparedStatement.setInt(11,g.getIsdel());
		preparedStatement.execute();
	}

	public void updateGoddess(Goddess g) throws SQLException {
		Connection connection = DBUtil.getConnection();
		String sql = ""+
				" update imooc_goddess "+
				" set user_name=?,sex=?,age=?,birthday=?,email=?,mobile=?, "+
				" update_user=?,update_date=?,isdel=?"+
				" where id=?";

		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1,g.getUser_name());
		preparedStatement.setInt(2,g.getSex());
		preparedStatement.setInt(3,g.getAge());
		preparedStatement.setDate(4,new Date(g.getBirthday().getTime()));
		preparedStatement.setString(5,g.getEmail());
		preparedStatement.setString(6,g.getMobile());
		preparedStatement.setString(7,g.getUpdate_user());
		preparedStatement.setDate(8,new Date(g.getBirthday().getTime()));
		preparedStatement.setInt(9,g.getIsdel());
		preparedStatement.setInt(10,g.getId());
		preparedStatement.execute();

	}

	public void delGoddess(Integer id) throws SQLException {
		Connection connection = DBUtil.getConnection();
		String sql = ""+
				" delete from imooc_goddess "+
				" where id=?";

		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1,id);
		preparedStatement.execute();
	}

	public List<Goddess> query() throws SQLException {
		Connection connection = DBUtil.getConnection();
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery("select id,user_name,age from imooc_goddess");
		List<Goddess> list = new ArrayList<>();
		Goddess g = null;
		while (resultSet.next()){
			g = new Goddess();
			g.setId(resultSet.getInt("id"));
			g.setUser_name(resultSet.getString("user_name"));
			g.setAge(resultSet.getInt("age"));
			list.add(g);
		}
		return list;
	}

	public List<Goddess> query(String name,String mobile) throws SQLException {
		Connection connection = DBUtil.getConnection();
		StringBuilder sb = new StringBuilder();
		sb.append("select * from imooc_goddess ");
		sb.append(" where user_name=? and mobile=?");

		PreparedStatement preparedStatement = connection.prepareStatement(sb.toString());
		preparedStatement.setString(1,name);
		preparedStatement.setString(2,mobile);
		ResultSet resultSet = preparedStatement.executeQuery();
		List<Goddess> list = new ArrayList<>();
		Goddess goddess = null;
		while (resultSet.next()){
			goddess = new Goddess();
			goddess.setId(resultSet.getInt("id"));
			goddess.setUser_name(resultSet.getString("user_name"));
			goddess.setSex(resultSet.getInt("sex"));
			goddess.setAge(resultSet.getInt("age"));
			goddess.setBirthday(resultSet.getDate("birthday"));
			goddess.setEmail(resultSet.getString("email"));
			goddess.setMobile(resultSet.getString("mobile"));
			goddess.setCreate_user(resultSet.getString("create_user"));
			goddess.setCreate_date(resultSet.getDate("create_date"));
			goddess.setUpdate_user(resultSet.getString("update_user"));
			goddess.setUpdate_date(resultSet.getDate("update_date"));
			goddess.setIsdel(resultSet.getInt("isdel"));
			list.add(goddess);
		}
		return list;
	}

	public List<Goddess> query(List<Map<String,Object>> params) throws SQLException {
		Connection connection = DBUtil.getConnection();
		StringBuilder sb = new StringBuilder();
		sb.append("select * from imooc_goddess where 1=1");

		if(params != null && params.size() > 0){
			for (int i = 0; i < params.size(); i++) {
				Map<String, Object> map = params.get(i);
				sb.append(" and "+map.get("name")+" "+map.get("rela")+" "+ map.get("value"));
			}
		}

		PreparedStatement preparedStatement = connection.prepareStatement(sb.toString());

		System.out.println(sb.toString());
		ResultSet resultSet = preparedStatement.executeQuery();
		List<Goddess> list = new ArrayList<>();
		Goddess goddess = null;
		while (resultSet.next()){
			goddess = new Goddess();
			goddess.setId(resultSet.getInt("id"));
			goddess.setUser_name(resultSet.getString("user_name"));
			goddess.setSex(resultSet.getInt("sex"));
			goddess.setAge(resultSet.getInt("age"));
			goddess.setBirthday(resultSet.getDate("birthday"));
			goddess.setEmail(resultSet.getString("email"));
			goddess.setMobile(resultSet.getString("mobile"));
			goddess.setCreate_user(resultSet.getString("create_user"));
			goddess.setCreate_date(resultSet.getDate("create_date"));
			goddess.setUpdate_user(resultSet.getString("update_user"));
			goddess.setUpdate_date(resultSet.getDate("update_date"));
			goddess.setIsdel(resultSet.getInt("isdel"));
			list.add(goddess);
		}
		return list;
	}

	public Goddess get(Integer id) throws SQLException {
		Connection connection = DBUtil.getConnection();
		String sql = ""+
				" select * from imooc_goddess "+
				" where id=?";

		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1,id);
		ResultSet resultSet = preparedStatement.executeQuery();
		Goddess goddess = null;

		while (resultSet.next()){
			goddess = new Goddess();
			goddess.setId(resultSet.getInt("id"));
			goddess.setUser_name(resultSet.getString("user_name"));
			goddess.setSex(resultSet.getInt("sex"));
			goddess.setAge(resultSet.getInt("age"));
			goddess.setBirthday(resultSet.getDate("birthday"));
			goddess.setEmail(resultSet.getString("email"));
			goddess.setMobile(resultSet.getString("mobile"));
			goddess.setCreate_user(resultSet.getString("create_user"));
			goddess.setCreate_date(resultSet.getDate("create_date"));
			goddess.setUpdate_user(resultSet.getString("update_user"));
			goddess.setUpdate_date(resultSet.getDate("update_date"));
			goddess.setIsdel(resultSet.getInt("isdel"));

		}
		return  goddess;
	}
}