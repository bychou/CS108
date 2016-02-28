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
 * Servlet implementation class QuestionServlet
 */
@WebServlet("/QuestionServlet")
public class QuestionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuestionServlet() {
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
		
		String questionType = request.getParameter("questionType");
		
		request.setAttribute("questionType", "question-response");
		if (questionType.equals("fill-in-blank")) {
			request.setAttribute("questionType", "fill-in-blank");
		} else if (questionType.equals("multiple-choice")) {
			request.setAttribute("questionType", "multiple-choice");
		} else if (questionType.equals("picture-response")) {
			request.setAttribute("questionType", "picture-response");
		} else if (questionType.equals("multiple-answer-ordered")) {
			request.setAttribute("questionType", "multiple-answer-ordered");
		} else if (questionType.equals("multiple-answer-unordered")) {
			request.setAttribute("questionType", "multiple-answer-unordered");
		} else if (questionType.equals("multiple-choice-multiple-answer")) {
			request.setAttribute("questionType", "multiple-choice-multiple-answer");
		} else if (questionType.equals("matching")) {
			request.setAttribute("questionType", "matching");
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("AddQuestionDescription.jsp");
		dispatcher.forward(request, response);
		
	}

}
