package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import JDBC.jdbcwork;

/**
 * Servlet implementation class delContentMsgServlet
 */
@WebServlet("/delContentMsgServlet")
public class delContentMsgServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public delContentMsgServlet() {
        super();
        // TODO Auto-generated constructor stub
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("UTF-8");
//		ÐÞ¸Ä ×Ö ·û ´®£¡£¡£¡£¡£¡£¡£¡£¡£¡£¡£¡£¡£¡£¡£¡
		String idString=request.getParameter("userid");
		String timeString=request.getParameter("time");
		timeString=timeString.replaceAll("É¾³ý", "");
		timeString=timeString.replaceAll("\\r|\\n", "");
		String contentElString=request.getParameter("contentEl");
//		contentElString=contentElString.replaceAll("\\r|\\n", "");
		String[] dataStrings= {idString, timeString,contentElString};
		jdbcwork jdbcwork=new jdbcwork();
		System.out.println(idString);
//		System.out.println();
		System.out.println(timeString);
//		System.out.println();
		System.out.println(contentElString);
		System.out.println("Ö´ÐÐÉ¾³ý");
		boolean istrue= jdbcwork.insertOrDelete("delete usersendmsg where id=? and time= ? and sendcontent= ?", dataStrings);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
