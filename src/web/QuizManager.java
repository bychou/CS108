package web;

import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.*;

public class QuizManager {
	private Statement stmt;
	
	public QuizManager(Statement stmt) {
		this.stmt = stmt;
	}
	
	public int createQuiz(String quizTitle, String quizDescription, String quizCategory, String creatorName, 
							String dateCreated, boolean isRandom, boolean isOnePage,
							boolean isPracticeMode, int numQuestions) {
		try {
			ResultSet rs = stmt.executeQuery("SELECT * FROM quizzes");
			rs.last();
			int quizNumber = rs.getRow() + 1;
			String qry = "INSERT INTO quizzes VALUES (" + quizNumber + ", \"" + quizTitle + "\", \"" + quizDescription + "\", \"" + quizCategory + "\", \"" + creatorName
			+ "\", \"" + dateCreated + "\", '" + isRandom + "', '" + isOnePage + "', '" + isPracticeMode + "'," + numQuestions + ")";
			System.out.println(qry);
			stmt.executeUpdate(qry);
			return quizNumber;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}
	
	public void addQuestion(int quizNumber) {
		
	}
	
}
