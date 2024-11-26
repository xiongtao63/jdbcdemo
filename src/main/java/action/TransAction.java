package action;

import dao.AccountDao;
import model.Account;
import service.TransService;

/**
 * <p>
 *  File Name: TransAction
 *  File Function Description
 *  <li></li>
 *  Version: V1.0
 * </p>
 *
 * @Author 23754
 *         <p>
 *         <li>Create Date：2024/11/25-13:53</li>
 *         <li>Revise Records</li>
 *         <li>-----------------------------------------------------------</li>
 *         <li>Revise Author: 23754 </li>
 *         <li>Revise Date: 2024/11/25-13:53</li>
 *         <li>Revise Content: </li>
 *         <li>-----------------------------------------------------------</li>
 *         </p>
 */
public class TransAction {
	public static void main(String[] args) {
		try {
			String res = trans();
			System.out.println(res);
		}catch (Exception e){
			e.printStackTrace();
		}
	}

	private static String trans() throws Exception{
		AccountDao accountDao = new AccountDao();
		TransService transService = new TransService();
		Account from = null;
		Account to = null;

		from = accountDao.get(1);
		to = accountDao.get(2);

		return transService.transaction(from,to,20d);
	}
}