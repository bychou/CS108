package web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MessageServlet
 */
@WebServlet("/MessageServlet")
public class MessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MessageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String fromUser = (String) request.getSession().getAttribute("username");
		String toUser = (String) request.getParameter("toUser");
		String message = (String) request.getParameter("message");
		
		/* Send message via User Data Manager. */
		UserDataManager userDataManager =   (UserDataManager) request.getServletContext().getAttribute("User Data Manager");
		
		String returnStatus = userDataManager.sendMessage(fromUser, toUser, message);
		request.setAttribute("Return Status", returnStatus);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("message.jsp");
		dispatcher.forward(request, response);
		
	}

}
