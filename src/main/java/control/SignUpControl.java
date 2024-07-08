package control;

import java.io.IOException;
import java.io.PrintWriter;

import dao.DAO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import entity.Account;

/**
 * Servlet implementation class SignUpControl
 */
@WebServlet("/signup")
public class SignUpControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUpControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String user = request.getParameter("user");
		String pass = request.getParameter("pass");
		String re_pass = request.getParameter("repass");
		
		DAO dao = new DAO();
		Account a = dao.checkAccountExit(user);
		
		if(!pass.equals(re_pass)) {
			String action = "signup";
			request.setAttribute("note","Mật khẩu không chính xác");
			request.getRequestDispatcher("Login.jsp?action=" + action).forward(request, response);
		}else{
			if(a==null) {
				dao.signUp(user, pass);
				String action = "signin";
				request.setAttribute("mess","Đăng kí thành công");
				request.getRequestDispatcher("Login.jsp?action=" + action).forward(request, response);
				
			}else {
				String action = "signup";
				request.setAttribute("note","Tên người dùng đã được sử dụng");
				request.getRequestDispatcher("Login.jsp?action=" + action).forward(request, response);
			}
				
	}
	}
}
