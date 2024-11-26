package test;

import dao.AccountDao;
import dao.TransInfoDao;
import model.Account;
import model.TransInfo;
import service.TransService;

import java.util.Date;

/**
 * <p>
 *  File Name: TestDBCP
 *  File Function Description
 *  <li></li>
 *  Version: V1.0
 * </p>
 *
 * @Author 23754
 *         <p>
 *         <li>Create Date：2024/11/25-15:43</li>
 *         <li>Revise Records</li>
 *         <li>-----------------------------------------------------------</li>
 *         <li>Revise Author: 23754 </li>
 *         <li>Revise Date: 2024/11/25-15:43</li>
 *         <li>Revise Content: </li>
 *         <li>-----------------------------------------------------------</li>
 *         </p>
 */
public class TestDBCP {
	public static void main(String[] args) throws Exception {

		Date a = new Date();
		trans();
		Date b = new Date();

		System.out.println(b.getTime() - a.getTime());

		Date c = new Date();
		transDBCP();
		Date d = new Date();

		System.out.println(d.getTime() - c.getTime());

	}

	private static void trans() throws Exception{
		AccountDao accountDao = new AccountDao();
		Account from = null;

		from = accountDao.get(1);

		System.out.println(from.toString());
	}
	private static void transDBCP() throws Exception{
		AccountDao accountDao = new AccountDao();
		Account from = null;

		from = accountDao.getByDBCP(1);

		System.out.println(from.toString());
	}
}