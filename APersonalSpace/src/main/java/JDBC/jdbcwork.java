package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;

public class jdbcwork {
	 String sql_url;	//数据库路径
	 String name;		//用户名
	 String password;	//密码
	 Connection conn = null;
	 PreparedStatement preparedStatement=null;
	 
	
	public jdbcwork() {
		this.sql_url ="jdbc:sqlserver://localhost:1433;DatabaseName=ChatInfo";
		this.name = "sa";
		this.password ="926474";
		preparedStatement=null;
		initJdbcWork();
	}
	private void initJdbcWork() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(sql_url, name, password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("数据库连接错了");
			e.printStackTrace();
			dbclose();
		}		//连接驱动
		catch (SQLException e) {
			System.out.println("jdbcwork25");
			// TODO Auto-generated catch block
			dbclose();
			e.printStackTrace();
		}
	}
	//sql语句 对应参数 得到的列数
	public Vector<Vector<String>> Select(String sql,String[] datas) {
		Vector<Vector<String>> resultVector= new Vector<>();
		try {
			System.out.println("查询");
			preparedStatement=conn.prepareStatement(sql);
			int i=1;
			if(datas!=null)
			for (String dataString : datas) {
				preparedStatement.setString(i, dataString);
				i++;
			}
			ResultSet resultSet=preparedStatement.executeQuery();
			ResultSetMetaData rsmd=resultSet.getMetaData();

			while (resultSet.next()) {
				Vector<String> currentRow = new Vector<String>();
				for(int i1 = 1; i1 <= rsmd.getColumnCount(); i1++){

					currentRow.addElement(resultSet.getString(i1));
					
				}
				resultVector.addElement(currentRow);
		

			}
			return resultVector;
		} catch (SQLException e) {
			System.out.println("jdbcwork_Select_SQLEX");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			dbclose();
		}
		return null;
		
	}
	//sql语句 参数
	public boolean insertOrDelete(String sql,String[] dataStrings) {
		try {
			//准备sql语句
			preparedStatement=conn.prepareStatement(sql);
			
			int i=1;
			//如果没有数据则不设置参数，sql语句直接执行
			if(dataStrings!=null) {
			for (String string : dataStrings) {
			preparedStatement.setString(i, string);
			i++;
			}
			}
			preparedStatement.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			dbclose();
		}
		return false;
	}

	
	
	private void dbclose() {
		try {
			if(conn!=null) {
				conn.close();
			}
			if(preparedStatement!=null) {
				preparedStatement.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("关闭数据库语柄错误");
			e.printStackTrace();
		}
	}
	
	
}
