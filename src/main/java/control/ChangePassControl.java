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
 * Servlet implementation class ChangePassControl
 */
@WebServlet("/change")
public class ChangePassControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangePassControl() {
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
	
		String u = request.getParameter("user");
		String pas1 = request.getParameter("pass1");
		String pas2 = request.getParameter("pass2");
		String pas3 = request.getParameter("pass3");
		
		DAO dao = new DAO();
		Account a = dao.login(u, pas1);
		
			if(a == null) {
				request.setAttribute("note","Đổi mật khẩu không thành công");
				request.getRequestDispatcher("Account.jsp").forward(request, response);			
			}else {
				Account ac = new Account(a.getuID(),u,pas2,a.getIsSell(),a.getIsAdmin());
				dao.updatePass(ac);
				HttpSession session = request.getSession();
				session.setAttribute("acc", ac);
				response.sendRedirect("Login.jsp");
				
				
				
			}
	}
}
