package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import JavaBean.GetAllUser;
import JavaBean.UserInfo;
import JavaBean.canLogin;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String userid=request.getParameter("userid");
		String userpasswd=request.getParameter("userpasswd");
		System.out.println(userid+" "+userpasswd);
		canLogin canLogin=new canLogin();
		
		UserInfo userInfo=canLogin.ifCanLogin(userid, userpasswd);
		if(userInfo==null) {
			request.setAttribute("bool", "false");
			request.getRequestDispatcher("JSP/Login.jsp").forward(request, response);
//			response.sendRedirect("JSP/Login.jsp");
			System.out.println("µÇÂ½Ê§°Ü");
		}
		else {
			request.setAttribute("bool", "true");
			request.getSession().setAttribute("userInfo", userInfo);
			request.getSession().setAttribute("userid", userid);
//			request.getServletContext().setAttribute("userinfo", userInfo);
			GetAllUser getAllUser=new GetAllUser();
			request.getServletContext().setAttribute("alluser", getAllUser.getUserInfos());
			System.out.println("µÇÂ½³É¹¦");
			request.getRequestDispatcher("JSP/Main.jsp").forward(request, response);
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
