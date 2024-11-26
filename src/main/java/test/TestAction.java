package test;

import action.GoddessAction;
import model.Goddess;

import java.sql.SQLException;
import java.util.*;

/**
 * <p>
 *  File Name: TestAction
 *  File Function Description
 *  <li></li>
 *  Version: V1.0
 * </p>
 *
 * @Author 23754
 *         <p>
 *         <li>Create Date：2024/11/18-15:00</li>
 *         <li>Revise Records</li>
 *         <li>-----------------------------------------------------------</li>
 *         <li>Revise Author: 23754 </li>
 *         <li>Revise Date: 2024/11/18-15:00</li>
 *         <li>Revise Content: </li>
 *         <li>-----------------------------------------------------------</li>
 *         </p>
 */
public class TestAction {
	public static void main(String[] args) throws SQLException {
		GoddessAction goddessAction = new GoddessAction();
//		List<Goddess> result = goddessAction.query();
//		for (int i = 0; i < result.size(); i++) {
//			System.out.println(result.get(i).getId()+":"+result.get(i).getUser_name());
//
//		}
//
//		Goddess goddess = new Goddess();
//		goddess.setUser_name("小白1");
//		goddess.setSex(0);
//		goddess.setAge(222);
//		goddess.setBirthday(new Date());
//		goddess.setEmail("sdfdsf@dsfds.cmm");
//		goddess.setMobile("199323293829");
//		goddess.setIsdel(1);
//		goddess.setId(5);
//
////		goddessAction.add(goddess);
//		goddessAction.edit(goddess);
//		goddessAction.del(5);


		List<Map<String,Object>> params = new ArrayList<>();
		Map<String,Object> map = new HashMap<>();
		map.put("name","user_name");
		map.put("rela","=");
		map.put("value", "'小美'");
		params.add(map);
		List<Goddess> result = goddessAction.query(params);
		for (int i = 0; i < result.size(); i++) {
			System.out.println(result.get(i).getId()+":"+result.get(i).getUser_name());

		}
	}
}