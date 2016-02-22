package web;

import java.io.IOException;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SearchUsersServlet
 */
@WebServlet("/SearchUsersServlet")
public class SearchUsersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchUsersServlet() {
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
		String keyword = (String) request.getParameter("keyword");
		String action = (String) request.getParameter("action");
		UserDataManager userDataManager = (UserDataManager) request.getServletContext().getAttribute("User Data Manager");
		
		assert (action != null);
		
		if (action.equals("add")) {
			List<String> returnStatusList = new LinkedList<String>();
			Enumeration<String> usernames = request.getParameterNames();
			
			while(usernames.hasMoreElements()){
					String toUser = usernames.nextElement();
					
					System.out.println("Hey");
					
					// TODO: Not a clean way to handle two forms with one Servlet
					// TODO: Perhaps use 2 Servlet?
					if (!toUser.equals("action")) {
						 String returnStatus = userDataManager.sendFriendRequest((String) request.getSession().getAttribute("username"), toUser, "");
			             returnStatusList.add(returnStatus);
			             
					}            
			}
			request.setAttribute("Return Status List", returnStatusList); 
		} else {
			assert (action.equals("search"));
			request.setAttribute("Search Result", userDataManager.searchUsers(keyword));
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("searchUsers.jsp");
		dispatcher.forward(request, response);
		
	}

}
