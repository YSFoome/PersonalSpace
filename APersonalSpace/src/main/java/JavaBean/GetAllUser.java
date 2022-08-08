package JavaBean;

import java.util.Vector;

import JDBC.jdbcwork;

public class GetAllUser {
	public Vector<UserInfo> getUserInfos() {
		Vector<UserInfo> leaveMsgInfos = new Vector<>();
		jdbcwork jdbcwork = new jdbcwork();
	
		Vector<Vector<String>> resultVectors = jdbcwork.Select("select * from userinfo",null);
		if (resultVectors.size() > 0) {	
			for (Vector<String> vector : resultVectors) {
				UserInfo userInfo=new UserInfo(vector.get(0), vector.get(1), vector.get(2), vector.get(3), vector.get(4));
				leaveMsgInfos.add(userInfo);
//				System.out.println(userInfo.toString());
			}
			return leaveMsgInfos;
		} else {
			return null;
		}
		
	}
}
