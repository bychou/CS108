package web;
import java.util.*;

public abstract class Question {
	
	/*Returns the directions of the question in string form*/
	public abstract String getQuestion();
	
	/*Sets the directions of the question in string form*/
	public abstract void setQuestion(String str);
	
	/*Returns the Question number*/
	public abstract int getQuestionNumber();
	
	/*Sets the Question number*/
	public abstract void setQuestionNumber(int i);
	
	public abstract void setQuestionOptions(List<String> options);
	
	public abstract List<String> getQuestionOptions();
	
	public abstract void addAnswers(Set<String> ans);
	
	public abstract Set<String> getAnswers();
	
}

