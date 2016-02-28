package web;

import java.util.List;
import java.util.Set;

public class MultipleChoiceAnswerQuestion extends Question {
	
	int questionNumber;
	String directions;
	private List<String> questionOptions;
	private Set<String> ans;
	private String questionText;
	int correctOptionIndex;
	
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
	
	/*
	 * Following: Multiple choice specific methods
	 */
	
	/*returns the index of the correct answer choice*/
	public int getCorrectOptionIndex() {
		return correctOptionIndex;
	}
	
	/*Sets the index of the correct answer choice*/
	public void setCorrectOptionIndex(int i) {
		correctOptionIndex = i;
	}
	
	/*returns the array of answer choices*/
	public List<String> getQuestionOptions() {
		return questionOptions;
	}
	
	public void setQuestionOptions(List<String> options) {
		this.questionOptions = options;
	}
	
	public void addAnswers(Set<String> ans) {
		this.ans = ans;
	}
	
	public Set<String> getAnswers() {
		return this.ans;
	}
}
