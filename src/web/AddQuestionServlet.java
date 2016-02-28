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
		
		String questionType = request.getParameter("quesType");
		
		String questionText = request.getParameter("textAll");
		if (questionType.equals("fill-in-blank")) {
			questionText = request.getParameter("textBefore") + "_____" + request.getParameter("textAfter");
		}
		
		int quesNumber;
		if (questionType.equals("multiple-answer-unordered")) {
			int numSlots = Integer.parseInt(request.getParameter("numSlots"));
			quesNumber = QzManager.addUnorderedQuestion(quizNumber, questionType, questionText, numSlots);
		} else {
			quesNumber = QzManager.addQuestion(quizNumber, questionType, questionText);
		}
		
		request.setAttribute("questionNumber", quesNumber);
		request.setAttribute("questionText", questionText);
		request.setAttribute("numChoices", Integer.parseInt(request.getParameter("numAnswers")));
		request.setAttribute("questionType", questionType);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("AddAnswer.jsp");
		dispatcher.forward(request, response);
	}

}
