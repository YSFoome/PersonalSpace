package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;

public class jdbcwork {
	 String sql_url;	//���ݿ�·��
	 String name;		//�û���
	 String password;	//����
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
			System.out.println("���ݿ����Ӵ���");
			e.printStackTrace();
			dbclose();
		}		//��������
		catch (SQLException e) {
			System.out.println("jdbcwork25");
			// TODO Auto-generated catch block
			dbclose();
			e.printStackTrace();
		}
	}
	//sql��� ��Ӧ���� �õ�������
	public Vector<Vector<String>> Select(String sql,String[] datas) {
		Vector<Vector<String>> resultVector= new Vector<>();
		try {
			System.out.println("��ѯ");
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
	//sql��� ����
	public boolean insertOrDelete(String sql,String[] dataStrings) {
		try {
			//׼��sql���
			preparedStatement=conn.prepareStatement(sql);
			
			int i=1;
			//���û�����������ò�����sql���ֱ��ִ��
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
			System.out.println("�ر����ݿ��������");
			e.printStackTrace();
		}
	}
	
	
}
