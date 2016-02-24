package web;

public class MultipleChoiceQuestion extends Question {
	
	int questionNumber;
	String directions;
	String questionOptions[];
	int correctOptionIndex;
	
	@Override
	public String getQuestion() {
		return directions;
	}

	@Override
	public void setQuestion(String s) {
		directions = s;

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
	public String[] getQuestionOptions() {
		return questionOptions;
	}
	
	/*Sets the array of answer choices*/
	public void setQuestionOptions(String[] s) {
		questionOptions = s;
	}
}
