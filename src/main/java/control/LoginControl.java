package control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DAO;
import entity.Account;

/**
 * Servlet implementation class LoginControl
 */
@WebServlet("/login")
public class LoginControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginControl() {
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
		//get by name in the
		String username = request.getParameter("user");
		String password = request.getParameter("pass");
		DAO dao = new DAO();
		Account a = dao.login(username, password);
	
		if(a != null) {
			HttpSession session = request.getSession();
			session.setAttribute("acc", a);
			response.sendRedirect("Home");
		}else {
			request.setAttribute("mess","Wrong user or password!");
			request.getRequestDispatcher("Login.jsp").forward(request, response);
			//forward(request, response) - forward du lieu len
			//chuyen trang ma can mang theo du lieu
		}
	}

}
