package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import JDBC.jdbcwork;

/**
 * Servlet implementation class saveContentMsgServlet
 */
@WebServlet("/saveContentMsgServlet")
public class saveContentMsgServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public saveContentMsgServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("UTF-8");
		String usernameString=request.getParameter("username");
		String timeString=request.getParameter("time");
		String contentElString=request.getParameter("contentEl");
		String[] dataStrings= {usernameString,timeString,contentElString};
		jdbcwork jdbcwork=new jdbcwork();
		System.out.println(usernameString);
		boolean istrue= jdbcwork.insertOrDelete("insert usersendmsg values (?,?,?)", dataStrings);
		
//		PrintWriter out=response.getWriter();
//		if(istrue) {
//			out.print("true");
//		}else {
//			out.print("false");
//		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
