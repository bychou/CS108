package web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AddQuestionServlet
 */
@WebServlet("/AddQuestionServlet")
public class AddQuestionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddQuestionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		ServletContext sc = request.getServletContext();
		QuizManager QzManager = (QuizManager) request.getServletContext().getAttribute("Quiz Manager");
		
		int quizNumber = (Integer) session.getAttribute("quizNumber");
		int currentQuestion = (Integer) session.getAttribute("currentQuestion");
		int numQuestions = (Integer) session.getAttribute("numQuestion");
		QzManager.addQuestion(quizNumber);
		
		if (currentQuestion < numQuestions) {
			session.setAttribute("currentQuestion", currentQuestion+1);
			RequestDispatcher dispatcher = request.getRequestDispatcher("AddQuestion.jsp");
			dispatcher.forward(request, response);
		} else if (currentQuestion == numQuestions) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("QuizCreated.jsp");
			dispatcher.forward(request, response);
		}
	}

}
