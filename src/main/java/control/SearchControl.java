package control;

import java.io.IOException;
import java.util.List;

import entity.Category;
import entity.Product;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.DAO;
/**
 * Servlet implementation class SearchControl
 */
@WebServlet("/Search")
public class SearchControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String txtSearch = request.getParameter("txt");
		DAO dao = new DAO();
		List<Product> list = dao.searchByName(txtSearch);
		List<Category> listC = dao.getAllCategory();
		Product last = dao.getLast();
		
		
		request.setAttribute("listCa", listC);
		request.setAttribute("p", last);
		request.setAttribute("listP", list);
		request.setAttribute("txtS", txtSearch);
		request.getRequestDispatcher("Home.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
