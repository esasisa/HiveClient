package com.hadoop.hive;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class HiveClient {

	private static String driverName = "org.apache.hive.jdbc.HiveDriver";
	private static String JDBC_URL= <Hive JDBC URL>;
	// Leave it blank, if you want to access default hive database
	private static String DB_NAME = <Hive Database name>;
	private static String USER_NAME = "";
	private static String PASSWORD = "";
	// example:: "hdfs://<HDFS Host name>/tmp/my_udf.jar"
	private static String UDF_JAR_LOCATION = <UDF JAR Location in HDFS>;
	private static String UDF_ALIAS = <UDF alias name to access this in hive QL>;
	//example "com.my.udf.UpperCase"
	private static String UDF_CLASS = <UDF class name>;

	public static void main(String[] args) throws SQLException, ClassNotFoundException {

		Class.forName(driverName);

		String selectQuery = "select "+UDF_ALIAS+"(<coloum ame>) from <table name>";

		Connection con = DriverManager.getConnection(JDBC_URL+DB_NAME, USER_NAME, PASSWORD);
		Statement stmt = con.createStatement();
		String querys[] = new String[2];
		querys[0] = "add jar "+UDF_JAR_LOCATION;
		
		//Run create function query only once to register new alias,  
		querys[1] = "create function "+UDF_ALIAS+" as '"+UDF_CLASS+"'";
		for(String query : querys){
			stmt.execute(query);
		}
		ResultSet res = stmt.executeQuery(selectQuery);
		System.out.println(res);
		while (res.next()) {
			System.out.println(res.getString(1));
		}
	}
}
