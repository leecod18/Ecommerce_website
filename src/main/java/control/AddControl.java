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
import entity.Product;

/**
 * Servlet implementation class AddControl
 */
@WebServlet("/add")
public class AddControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String pname = request.getParameter("name");
		String pimage = request.getParameter("image");
		String pprice = request.getParameter("price");
		String ptitle = request.getParameter("title");
		String pdescription = request.getParameter("description");
		String pcategory = request.getParameter("category");
		HttpSession session = request.getSession();
		
		Account a = (Account) session.getAttribute("acc");
		int sid = a.getuID();
		
		DAO dao  = new DAO();
		 dao.insertProduct(pname, pimage, pprice, ptitle, pdescription,pcategory, sid);
		response.sendRedirect("manager");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
