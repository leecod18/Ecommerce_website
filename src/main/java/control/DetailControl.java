package control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DAO;
import entity.Category;
import entity.Product;

/**
 * Servlet implementation class DetailControl
 */
@WebServlet("/Detail")
public class DetailControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DetailControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("pid");
		String cateID = request.getParameter("cid");
		
		DAO dao  = new DAO();
		Product p = dao.getProductByID(id);
		List<Product> list  = dao.getProductByCID(cateID);
		List<Category> listC = dao.getAllCategory();
		Product last = dao.getLast();
		
		request.setAttribute("detail",p);
		request.setAttribute("listCa", listC);
		request.setAttribute("p",last);
		request.getRequestDispatcher("Detail.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
