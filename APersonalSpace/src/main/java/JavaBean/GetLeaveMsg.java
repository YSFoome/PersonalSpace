package JavaBean;

import java.util.Vector;

import JDBC.jdbcwork;

public class GetLeaveMsg {//∑µªÿ¡Ù—‘¡–±Ì
	public Vector<LeaveMsgInfo> getmsg(String id) {
		Vector<LeaveMsgInfo> leaveMsgInfos = new Vector<>();
		jdbcwork jdbcwork = new jdbcwork();
		String[] dataStrings = { id };
		Vector<Vector<String>> resultVectors = jdbcwork.Select("select * from userLeaveMsg where targetid=?",
				dataStrings);
		if (resultVectors.size() > 0) {
			for (Vector<String> vector : resultVectors) {
				LeaveMsgInfo leaveMsgInfo = new LeaveMsgInfo(vector.get(0), vector.get(1), vector.get(2));
				leaveMsgInfos.add(leaveMsgInfo);
			}
			return leaveMsgInfos;
		} else {
			return null;
		}
	}
	public boolean sendmsg(String id,String targetid,String text) {
//		Vector<LeaveMsgInfo> leaveMsgInfos = new Vector<>();
		jdbcwork jdbcwork = new jdbcwork();
		String[] dataStrings = {id,targetid,text};
		return jdbcwork.insertOrDelete("insert userLeaveMsg values (?,?,?)",dataStrings);
	}
	
	
	public Vector<userSendMsg> getSendMsgs() {
		Vector<userSendMsg> results=new Vector<>();
				jdbcwork jdbcwork = new jdbcwork();		Vector<Vector<String>> resultVectors = jdbcwork.Select("select * from usersendmsg order by time desc",
				null);
		if (resultVectors.size() > 0) {
			for (Vector<String> vector : resultVectors) {
				userSendMsg leaveMsgInfo = new userSendMsg(vector.get(0), vector.get(1), vector.get(2));
				results.add(leaveMsgInfo);
			}
			return results;
		} else {
			return null;
		}
	}
}
