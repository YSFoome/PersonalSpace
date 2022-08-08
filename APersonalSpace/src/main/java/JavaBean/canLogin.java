package JavaBean;

import java.util.Vector;

import JDBC.jdbcwork;

public class canLogin {
	public UserInfo ifCanLogin(String userid, String userpasswd) {
		String[] dataStrings = { userid, userpasswd };
		jdbcwork jdbcwork = new jdbcwork();
		Vector<Vector<String>> resultVectors = jdbcwork.Select("select * from userinfo where id=? and passwd=? ",
				dataStrings);
		if (resultVectors.size() > 0) {
			UserInfo clientPeopleInfo = new UserInfo(resultVectors.get(0).get(0), resultVectors.get(0).get(1),
					resultVectors.get(0).get(2), resultVectors.get(0).get(3), resultVectors.get(0).get(4));

			return clientPeopleInfo;
		}
		return null;

	}
}
