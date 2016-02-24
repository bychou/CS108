package web;

import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.*;

import java.text.SimpleDateFormat;

public class QuizManager {
	private Statement stmt;
	
	public QuizManager(Statement stmt) {
		this.stmt = stmt;
	}
	
	public synchronized int createQuiz(String quizTitle, String quizDescription, String quizCategory, String creatorName, 
							String dateCreated, boolean isRandom, boolean isOnePage,
							boolean isPracticeMode, int numQuestions) {
		try {
			ResultSet rs = stmt.executeQuery("SELECT * FROM quizzes");
			rs.last();
			int quizNumber = rs.getRow() + 1;
			//String qry = "INSERT INTO quizzes VALUES (" + quizNumber + ", \"" + quizTitle + "\", \"" + quizDescription + "\", \"" + quizCategory + "\", \"" + creatorName
			//+ "\", \"" + dateCreated + "\", '" + isRandom + "', '" + isOnePage + "', '" + isPracticeMode + "'," + numQuestions + ")";
			String qry = "INSERT INTO quizzes VALUES (" + quizNumber + ", \"" + quizTitle + "\", \"" + quizDescription + "\", \"" + quizCategory + "\", \"" + creatorName
			+ "\", NULL, '" + isRandom + "', '" + isOnePage + "', '" + isPracticeMode + "'," + numQuestions + ")";
			System.out.println(qry);
			stmt.executeUpdate(qry);
			return quizNumber;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}
	
	public synchronized int addQuestion(int quizNumber, String questionType, String text) {
		try {
			ResultSet rs = stmt.executeQuery("SELECT * FROM questions");
			rs.last();
			int questionNumber = rs.getRow() + 1;
			String qry = "INSERT INTO questions VALUES (" + questionNumber + ", " + quizNumber + ", \"" + questionType + "\", \"" + text + "\")";
			System.out.println(qry);
			stmt.executeUpdate(qry);
			return questionNumber;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}
	
	public synchronized void addMultiChoiceAnswer(int questionNumber, String[] ansArray, boolean[] correctArray) {
		try {
			ResultSet rs = stmt.executeQuery("SELECT * FROM answerOptions");
			rs.last();
			int keyNum = rs.getRow() + 1;
			for (int i = 0; i < ansArray.length; i++) {
				String qry = "INSERT INTO answerOptions VALUES (" + keyNum + ", " + questionNumber + ", \"" + ansArray[i] + "\", '" + correctArray[i] + "')";
				System.out.println(qry);
				stmt.executeUpdate(qry);
				keyNum++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public synchronized void addAnswer(int questionNumber, String[] ansArray) {
		try {
			ResultSet rs = stmt.executeQuery("SELECT * FROM answers");
			rs.last();
			int keyNum = rs.getRow() + 1;
			for (int i = 0; i < ansArray.length; i++) {
				String qry = "INSERT INTO answers VALUES (" + keyNum + ", " + questionNumber + ", \"" + ansArray[i] + "\")";
				System.out.println(qry);
				stmt.executeUpdate(qry);
				keyNum++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void updateQuizCreation(int quizNumber) {
		try {		
			String timeStamp = ClockTimeStamp.getTimeStamp();
			String qry = "UPDATE quizzes SET dateCreated = \"" + timeStamp + "\" WHERE quizId = " + quizNumber;
			System.out.println(qry);
			stmt.executeUpdate(qry);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ResultSet getQuizList() {
		try {
			ResultSet rs = stmt.executeQuery("SELECT * FROM quizzes WHERE dateCreated IS NOT NULL");
			return rs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public ResultSet getQuizListbyUser(String username) {
		try {
			ResultSet rs = stmt.executeQuery("SELECT * FROM quizzes WHERE creatorUsername=\"" + username + "\"");
			return rs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public ResultSet getQuiz(int quizNumber) {
		try {
			ResultSet rs = stmt.executeQuery("SELECT * FROM quizzes WHERE quizId = " + quizNumber);
			return rs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public ResultSet getQuestion(int quizNumber) {
		try {
			ResultSet rs = stmt.executeQuery("SELECT * FROM questions WHERE quizId = " + quizNumber);
			return rs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public ResultSet getAnswer(int questionNumber) {
		try {
			ResultSet rs = stmt.executeQuery("SELECT * FROM answers WHERE questionId = " + questionNumber);
			return rs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public ResultSet getAnswerOption(int questionNumber) {
		try {
			ResultSet rs = stmt.executeQuery("SELECT * FROM answerOptions WHERE questionId = " + questionNumber);
			return rs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
