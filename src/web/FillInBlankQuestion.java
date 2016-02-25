package web;

import java.util.List;
import java.util.Set;

public class FillInBlankQuestion extends Question {
	
	public static final String BLANK = "__________";
	int questionNumber;
	private String questionText;
	private Set<String> ans;
	String[] questionInArray;
	int blankIndex;
	

	@Override
	public String getQuestion() {
		return questionText;
	}

	@Override
	public void setQuestion(String s) {
		questionText = s;
	}

	@Override
	public int getQuestionNumber() {
		return questionNumber;
	}

	@Override
	public void setQuestionNumber(int i) {
		questionNumber = i;
	}
	
	/*Method specific to Fill in the Blank Questions*/
	
	public void setQuestioninArray(String[] arr) {
		//TODO: think more about how to represent questions; how the user will get to create this type of question
		questionInArray = arr;
	}
	
	public String[] getQuestioninArray() {
		return questionInArray;
	}
	
	public int getBlankIndex() {
		return blankIndex;
	}
	
	public void setQuestionOptions(List<String> options) {
		
	}
	
	public List<String> getQuestionOptions() {
		return null;
	}
	
	public void addAnswers(Set<String> ans) {
		this.ans = ans;
	}
	
	public Set<String> getAnswers() {
		return this.ans;
	}

}
