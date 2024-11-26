package service;

import dao.AccountDao;
import dao.TransInfoDao;
import db.DBUtil;
import model.Account;
import model.TransInfo;

import java.sql.Connection;

/**
 * <p>
 *  File Name: TransService
 *  File Function Description
 *  <li></li>
 *  Version: V1.0
 * </p>
 *
 * @Author 23754
 *         <p>
 *         <li>Create Date：2024/11/25-13:50</li>
 *         <li>Revise Records</li>
 *         <li>-----------------------------------------------------------</li>
 *         <li>Revise Author: 23754 </li>
 *         <li>Revise Date: 2024/11/25-13:50</li>
 *         <li>Revise Content: </li>
 *         <li>-----------------------------------------------------------</li>
 *         </p>
 */
public class TransService {
	public  String trans(Account from, Account to, Double amount) throws Exception{
		AccountDao accountDao = new AccountDao();
		TransInfoDao transInfoDao = new TransInfoDao();

		from.setAmount(from.getAmount() - amount);
		accountDao.update(from);

		//报错代码
		String a = null;
		a.split("1");

		to.setAmount(to.getAmount()+amount);
		accountDao.update(to);

		TransInfo info = new TransInfo();
		info.setSourceId(from.getId());
		info.setSourceAccount(from.getAccount());
		info.setDestinationId(to.getId());
		info.setDestinationAccount(to.getAccount());
		info.setAmount(amount);
		transInfoDao.insert(info);
		return "success";
	}
	public  String transaction(Account from, Account to, Double amount) throws Exception{
		Connection conn = DBUtil.getConnection();
		conn.setAutoCommit(false); //自动提交关闭
		try {
			AccountDao accountDao = new AccountDao();
			TransInfoDao transInfoDao = new TransInfoDao();

			from.setAmount(from.getAmount() - amount);
			accountDao.update(from);

			//报错代码
//			String a = null;
//			a.split("1");

			to.setAmount(to.getAmount()+amount);
			accountDao.update(to);

			TransInfo info = new TransInfo();
			info.setSourceId(from.getId());
			info.setSourceAccount(from.getAccount());
			info.setDestinationId(to.getId());
			info.setDestinationAccount(to.getAccount());
			info.setAmount(amount);
			transInfoDao.insert(info);

			conn.commit();
			return "success";
		}catch (Exception e){
			conn.rollback();
			e.printStackTrace();
			return "fail";
		}

	}
}