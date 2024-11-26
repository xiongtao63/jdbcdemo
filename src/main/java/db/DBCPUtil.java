package db;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * <p>
 *  File Name: DBCPUtil
 *  File Function Description
 *  <li></li>
 *  Version: V1.0
 * </p>
 *
 * @Author 23754
 *         <p>
 *         <li>Create Date：2024/11/25-15:25</li>
 *         <li>Revise Records</li>
 *         <li>-----------------------------------------------------------</li>
 *         <li>Revise Author: 23754 </li>
 *         <li>Revise Date: 2024/11/25-15:25</li>
 *         <li>Revise Content: </li>
 *         <li>-----------------------------------------------------------</li>
 *         </p>
 */
public class DBCPUtil {
	private static DataSource DS;
	private static final String configFile = "/dbcp.properties";

	public DBCPUtil() {
		initDbcp();
	}

	public  Connection getConn(){
		Connection conn = null;
		if(DS != null){
			try {
				conn = DS.getConnection();
				conn.setAutoCommit(false);
			}
			catch (SQLException e) {
				throw new RuntimeException(e);
			}


		}
		return conn;
	}

	private void initDbcp() {

		try {
			Properties properties = new Properties();
			properties.load(DBCPUtil.class.getResourceAsStream(configFile));
//			properties.load(ClassLoader.getSystemResourceAsStream("src/main/java/db/dbcp.properties"));
			DS = BasicDataSourceFactory.createDataSource(properties);
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public DBCPUtil(String connectUrl){
		initDS(connectUrl);
	}

	private void initDS(String connectUrl) {
	}

	public DBCPUtil(String connectUrl,String username,String password,String driverClass,int initialSize, int maxActive, int maxIdle,int maxWait,
			int minIdle){
		initDS(connectUrl,username,password,driverClass,initialSize,maxActive,maxIdle,maxWait,minIdle);
	}

	private void initDS(String connectUrl, String username, String password, String driverClass, int initialSize, int maxActive, int maxIdle, int maxWait, int minIdle) {
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName(driverClass);
		ds.setUsername(username);
		ds.setPassword(password);
		ds.setUrl(connectUrl);
		ds.setInitialSize(initialSize);
		ds.setMaxActive(maxActive);
		ds.setMaxWait(maxWait);
		ds.setMaxIdle(maxIdle);
		ds.setMinIdle(minIdle);
		DS = ds;
	}

}