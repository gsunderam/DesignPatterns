package db;

import java.sql.*;

import static log.Logger.print;
import static log.Logger.stdout;

/**
 * User: gsunderam
 * Date: Jan 9, 2015
 */
public class DerbyDb {
  private static String dbURL = "jdbc:derby://localhost:1527/MyDbNetTest";
  private static Connection conn = null;
  private static Statement stmt = null;
  
  public static void main(String[] args) {
     createConnection();
//     insertValues();
     selectValues();
     closeConnection();
  }

  private static void selectValues() {
    try {
      stmt = conn.createStatement();
      ResultSet results = stmt.executeQuery("select * from Employee");
      ResultSetMetaData rsmd = results.getMetaData();
      int numberCols = rsmd.getColumnCount();
      for (int i = 1; i <= numberCols; i++) {
        //print Column Names
        print(rsmd.getColumnLabel(i) + "\t\t");
      }

      stdout("\n-------------------------------------------------");

      while (results.next()) {
        int id = results.getInt(1);
        String restName = results.getString(2);
        String cityName = results.getString(3);
        stdout(id + "\t\t" + restName + "\t\t" + cityName);
      }
      results.close();
      stmt.close();
    } catch (SQLException sqlExcept) {
      sqlExcept.printStackTrace();
    }
  }
  

  public static void insertValues() {
    try {
      stmt = conn.createStatement();
      stmt.execute("insert into Employee values (1, 'Sunderam G', '765 W Stottler pl, Gilbert AZ 85233')");
      stmt.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public static Connection createConnection() {
   try {
      Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
      conn = DriverManager.getConnection(dbURL);
      stdout("Connection to dervy is " + conn);
    } catch (Exception e) {
        e.printStackTrace();
    }

		return conn;
  }

  public static void closeConnection() {
    try {
      if (stmt != null) {
        stmt.close();
      }
      if (conn != null) {
        //DriverManager.getConnection(dbURL + ";shutdown=true");
        conn.close();
      }
    } catch (SQLException e) {
        e.printStackTrace();
     }
  }
}
