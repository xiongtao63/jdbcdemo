package test;

import dao.ProduceDao;
import model.Goddess;

import java.sql.SQLException;
import java.util.List;

/**
 * <p>
 *  File Name: ProduceTest
 *  File Function Description
 *  <li></li>
 *  Version: V1.0
 * </p>
 *
 * @Author 23754
 *         <p>
 *         <li>Create Date：2024/11/20-16:56</li>
 *         <li>Revise Records</li>
 *         <li>-----------------------------------------------------------</li>
 *         <li>Revise Author: 23754 </li>
 *         <li>Revise Date: 2024/11/20-16:56</li>
 *         <li>Revise Content: </li>
 *         <li>-----------------------------------------------------------</li>
 *         </p>
 */
public class JDBCTestProduce {
	public static void main(String[] args) throws Exception {
		ProduceDao produceDao = new ProduceDao();
//		produceDao.select_nofilter();

//		List<Goddess> result = null;
//		result = produceDao.select_filter("18888888888");
//
//		for (int i = 0; i < result.size(); i++) {
//			System.out.println(result.get(i).getUser_name());
//		}

		Integer integer = produceDao.select_count();
		System.out.println(integer);

	}
}