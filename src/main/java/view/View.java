package view;

import java.util.Scanner;

/**
 * <p>
 *  File Name: View
 *  File Function Description
 *  <li></li>
 *  Version: V1.0
 * </p>
 *
 * @Author 23754
 *         <p>
 *         <li>Create Date：2024/11/18-15:22</li>
 *         <li>Revise Records</li>
 *         <li>-----------------------------------------------------------</li>
 *         <li>Revise Author: 23754 </li>
 *         <li>Revise Date: 2024/11/18-15:22</li>
 *         <li>Revise Content: </li>
 *         <li>-----------------------------------------------------------</li>
 *         </p>
 */
public class View {
	private static final String CONTEXT=
	"欢迎来到女生禁区:"+
	"下面是女神禁区的功能列表:\n"+
			"[MAIN/M]:主菜单\n"+
			"[QUERY/Q]:查看全部女神的信息\n"+
			"[GET/G]:查看某位女神的详细信息\n"+
			"[ADD/A]:添加女神信息\n"+
			"[UPDATE/U]:更新女神信息\n"+
			"[DELETE/D]:删除女神信息\n"+
			"[SEARCH/S]:查询女神信息(根据姓名、手机号来查询)\n"+
			"[EXIT/E]:退出女神禁区\n"+
			"[BREAK/B]:退出当前功能，返回主菜单";


	private static final String OPERATION_MAIN ="MAIN";
	private static final String OPERATION_QUERY ="QUERY";
	private static final String OPERATION_GET ="GET";
	private static final String OPERATION_ADD="ADD";
	private static final String OPERATION_UPDATE = "UPDATE";
	private static final String OPERATION_DELETE="DELETE";
	private static final String OPERATION_SEARCH = "SEARCH";
	private static final String OPERATION_EXIT="EXIT";
	private static final String OPERATION_BREAK ="BREAK";

	public static void main(String[] args) {
		System.out.println(CONTEXT);
		Scanner scanner = new Scanner(System.in);
		while (true){
			String in = scanner.next().toString();
			if(OPERATION_EXIT.equals(in.toUpperCase()) || OPERATION_EXIT.substring(0,1).equals(in.toUpperCase())){
				System.out.println("您已成功退出");
				break;
			}
			System.out.println("你输入的是:"+in);
		}
	}
}