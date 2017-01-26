package db;

import java.sql.*;

import static log.Logger.stdout;

/**
 * User: gsunderam
 * Date: Aug 3, 2015
 */
public class EmployeeDao {
	public static void main(String[] args) throws SQLException {
		Connection conn = DerbyDb.createConnection();
		Statement st = conn.createStatement();
		DatabaseMetaData metadata = conn.getMetaData();
		String fns = metadata.getStringFunctions();
		stdout(fns);
//		ResultSet rs = st.executeQuery("{fn CURRENT_DATE()}");

//		while (rs.next()) stdout("Result is " + rs.getDate(1));
		DerbyDb.closeConnection();
	}
}
