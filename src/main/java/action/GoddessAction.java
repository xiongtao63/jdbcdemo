package action;

import dao.GoddessDao;
import model.Goddess;

import java.sql.SQLException;
import java.util.*;

/**
 * <p>
 *  File Name: GoddessAction
 *  File Function Description
 *  <li></li>
 *  Version: V1.0
 * </p>
 *
 * @Author 23754
 *         <p>
 *         <li>Create Date：2024/11/18-11:29</li>
 *         <li>Revise Records</li>
 *         <li>-----------------------------------------------------------</li>
 *         <li>Revise Author: 23754 </li>
 *         <li>Revise Date: 2024/11/18-11:29</li>
 *         <li>Revise Content: </li>
 *         <li>-----------------------------------------------------------</li>
 *         </p>
 */
public class GoddessAction {

	public void add(Goddess goddess) throws SQLException {
		GoddessDao goddessDao = new GoddessDao();
		goddessDao.addGoddess(goddess);
	}

	public void edit(Goddess goddess) throws SQLException {
		GoddessDao goddessDao = new GoddessDao();
		goddessDao.updateGoddess(goddess);
	}

	public Goddess get(Integer id) throws SQLException {
		GoddessDao goddessDao = new GoddessDao();
		return goddessDao.get(id);
	}
	public void del(Integer id) throws SQLException {
		GoddessDao goddessDao = new GoddessDao();
		goddessDao.delGoddess(id);
	}
	public List<Goddess> query() throws SQLException {
		GoddessDao goddessDao = new GoddessDao();
		return goddessDao.query();
	}
	public List<Goddess> query(List<Map<String,Object>> params) throws SQLException {
		GoddessDao goddessDao = new GoddessDao();
		return goddessDao.query(params);
	}



	public static void main(String[] args) throws SQLException {
		GoddessDao goddessDao = new GoddessDao();
//		List<Goddess> query = goddessDao.query();
//		for (Goddess goddess: query){
//			System.out.println(goddess.getUser_name()+"," +goddess.getAge());
//		}
		Goddess g = new Goddess();
		g.setUser_name("景甜1");
		g.setAge(30);
		g.setSex(1);
		g.setBirthday(new Date());
		g.setEmail("ddddddd@ddd.cn");
		g.setMobile("18888888888");
		g.setCreate_user("admin");
		g.setUpdate_user("admin");
		g.setIsdel(1);
		g.setId(3);
//		List<Goddess> list = goddessDao.query("景甜1","18888888888");
		List<Map<String, Object>> params = new ArrayList<>();
		Map<String, Object> map = new HashMap<>();
		map.put("name","user_name");
		map.put("rela","like");
		map.put("value","'景甜1'");
		params.add(map);
		map = new HashMap<>();
		map.put("name","mobile");
		map.put("rela","like");
		map.put("value","'18888888888'");
		params.add(map);
		List<Goddess> list = goddessDao.query(params);
		for (int i = 0; i < list.size(); i++) {

			System.out.println(list.get(i).toString());
			
		}
		//		Goddess result = goddessDao.get(4);
//		System.out.println(result.toString());
//		goddessDao.delGoddess(3);
//		goddessDao.updateGoddess(g);
//		goddessDao.addGoddess(g);
	}
}