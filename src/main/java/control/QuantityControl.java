package control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.Item;

/**
 * Servlet implementation class QuantityControl
 */
@WebServlet("/quantity")
public class QuantityControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuantityControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    HttpSession session = request.getSession();

	    if (session.getAttribute("cart") != null) {
	        List<Item> cart = (List<Item>) session.getAttribute("cart");
	        int productId = Integer.parseInt(request.getParameter("id"));
	        String action = request.getParameter("action");

	        int index = isExisting(productId, cart);

	        if (index != -1) {
	            int quantity = cart.get(index).getQuantity();

	            if ("inc".equals(action)) {
	                quantity++;
	            } else if ("dec".equals(action) && quantity > 1) {
	                quantity--;
	            }

	            cart.get(index).setQuantity(quantity);
	            session.setAttribute("cart", cart);
	        }
	    }

	    response.sendRedirect("Cart.jsp");
	}

	private int isExisting(int productId, List<Item> cart) {
	    for (int i = 0; i < cart.size(); i++) {
	        if (cart.get(i).getProduct().getId() == productId) {
	            return i;
	        }
	    }
	    return -1;
	}
		
	


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
