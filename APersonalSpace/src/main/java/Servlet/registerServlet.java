package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import JDBC.jdbcwork;
import JavaBean.GetAllUser;
import JavaBean.UserInfo;
import JavaBean.canLogin;

/**
 * Servlet implementation class registerServlet
 */
@WebServlet("/registerServlet")
public class registerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public registerServlet() {
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
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		String userid=request.getParameter("userid");
		String username=request.getParameter("username");
		String userpasswd=request.getParameter("userpasswd");
		System.out.println(userid+" "+userpasswd);

		String[] dataStrings= {userid,username,userpasswd};
		jdbcwork jdbcwork=new jdbcwork();
//		System.out.println(usernameString);
		boolean istrue= jdbcwork.insertOrDelete("insert userinfo(id,name,passwd) "
				+ "values(?,?,?)", dataStrings);
		PrintWriter outPrintWriter=response.getWriter();
		if(istrue) {
			outPrintWriter.print("true");
		}else {
			outPrintWriter.print("false");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
